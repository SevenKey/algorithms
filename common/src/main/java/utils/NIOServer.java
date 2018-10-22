package utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author weijianyu
 */
public class NIOServer {
    public static void open() throws Exception {
        Selector serverSelect = Selector.open();
        Selector clientSelect = Selector.open();

        new Thread(() -> {
            try {
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(10003));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(serverSelect, SelectionKey.OP_ACCEPT);

                while (true) {
                    if (serverSelect.select(1) > 0) {
                        Set<SelectionKey> sets = serverSelect.selectedKeys();
                        Iterator<SelectionKey> selectionKeyIterator = sets.iterator();
                        while (selectionKeyIterator.hasNext()) {
                            SelectionKey selectionKey = selectionKeyIterator.next();
                            if (selectionKey.isAcceptable()) {
                                try {
                                    SocketChannel clientChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(clientSelect, SelectionKey.OP_READ);
                                } finally {
                                    selectionKeyIterator.remove();
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    if (clientSelect.select(1) > 0) {
                        Set<SelectionKey> sets = clientSelect.selectedKeys();
                        Iterator<SelectionKey> selectionKeyIterator = sets.iterator();
                        while (selectionKeyIterator.hasNext()) {
                            SelectionKey selectionKey = selectionKeyIterator.next();
                            if (selectionKey.isReadable()) {
                                try {
                                    SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    clientChannel.read(byteBuffer);
                                    byteBuffer.flip();
                                    System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                } finally {
                                    selectionKeyIterator.remove();
                                    selectionKey.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        try {
            NIOServer.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
