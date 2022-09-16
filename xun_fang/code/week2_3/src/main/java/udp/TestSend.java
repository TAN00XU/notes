package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * 发送测试
 *
 * @author TAN00XU
 * @date 2022/09/14 16:01
 */
public class TestSend {
    public static void main(String[] args) {
        new Thread(() -> send()).start();
        new Thread(() -> TestReceive.receive()).start();

    }

    public static void send() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                DatagramSocket socket = new DatagramSocket();
                System.out.println("输入传输的文字：");
                String context = scanner.nextLine();
                byte[] data = context.getBytes();
                DatagramPacket packet = new DatagramPacket(
                        data,
                        data.length,
                        InetAddress.getByName("localhost"),
                        8888);
                socket.send(packet);
                socket.close();
                System.out.println("发送成功");
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
