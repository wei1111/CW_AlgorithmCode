package mysocket;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/18 19:15
 * @Description:
 */
public class ServerBoot {
    private static final int PORT = 8000;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }
}
