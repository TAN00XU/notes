import java.io.IOException;
import java.net.*;

/**
 * @author TAN00XU
 * @date 2022/09/14 16:19
 */
public class TestReceive {
    public static void main(String[] args) {


    }

    public static void receive() {
        try {
            DatagramSocket socket = new DatagramSocket(10086);
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            socket.receive(packet);
            System.out.println(packet.getData());
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
