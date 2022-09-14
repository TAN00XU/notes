import java.io.IOException;
import java.net.*;

/**
 * @author TAN00XU
 * @date 2022/09/14 16:01
 */
public class TestSend {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] bytes = "你好啊！".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.137.1"), 10086);
            socket.send(packet);

        } catch (SocketException | UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
