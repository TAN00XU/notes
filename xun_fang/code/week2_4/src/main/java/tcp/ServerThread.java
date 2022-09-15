package tcp;

import java.io.*;
import java.net.Socket;

/**
 * @author TAN00XU
 * @date 2022/09/15 11:19
 */
public class ServerThread implements Runnable {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //写入文件
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("files\\server.txt"));
            int count = 0;
            File file = new File("files\\server[" + count + "].txt");
            while (file.exists()) {
                count++;
                file = new File("files\\server[" + count + "].txt");
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            System.out.println(25222);
            //给出反馈
            BufferedWriter server = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            server.write("已收到！");
            server.newLine();
            server.flush();
            // 关闭
            bufferedReader.close();
            bufferedWriter.close();
            server.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
