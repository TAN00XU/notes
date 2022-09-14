package udp;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

/**
 * 接收测试
 *
 * @author TAN00XU
 * @date 2022/09/14 16:19
 */
public class TestReceive {

    public static void receive() {
        try {
            DatagramSocket socket = new DatagramSocket(8888);
            while (true) {
                byte[] bytes = new byte[1024];
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
                socket.receive(packet);
                System.out.println("收到的数据：");
                System.out.println(new String(packet.getData(), 0, packet.getLength()));

            }

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
