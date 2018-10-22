package utils;

import java.net.Socket;

public class Client {
    public static void open() throws Exception {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 10003);
                while (true) {
                    byte[] data = (System.currentTimeMillis() + "hello i am client").getBytes();
                    socket.getOutputStream().write(data);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        }).start();
    }

    public static void main(String[] args) {
        try {
            Client.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
