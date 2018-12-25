package mysocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/18 19:15
 * @Description:
 */
public class ClientHandler {
    public static final int MAX_DATA_LEN = 1024;
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        System.out.println("新客户端接入");
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    private void doStart() {
        try {
            InputStream inputStream = socket.getInputStream();
            while (true) {
                byte[] data = new byte[MAX_DATA_LEN];
                int len;
                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len);
                    System.out.println("客户端"+socket.getInetAddress().getHostName()
                            +":"+socket.getInetAddress().getHostAddress()+"传来消息: " +
                            message);
                    socket.getOutputStream().write(data);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
