package utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author weijianyu
 */
public class Service {

    public static void open() throws Exception {
        ServerSocket serverSocket = new ServerSocket(10003);
        new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    new Thread(() -> {
                        try {
                            byte[] buffer = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            int len;
                            while ((len = inputStream.read(buffer)) != -1) {
                                System.out.println(new String(buffer, 0, len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public static void main(String[] args) {
        try {
            Service.open();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
