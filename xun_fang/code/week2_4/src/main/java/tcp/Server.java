package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器类
 *
 * @author TAN00XU
 * @date 2022/09/15
 */
public class Server {
    public static void main(String[] args) throws IOException {
        serverThread();
    }


    static void serverThread() throws IOException {
        //创建服务器端的Socket对象(ServerSocket)
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            //监听客户端连接，返回一个Socket对象
            Socket socket = serverSocket.accept();
            //为每个客户端开启一个线程
//            new Thread(new ServerThread(socket)).start();
            new Thread(() -> {
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
                    BufferedWriter result = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    result.write("已收到！");
                    result.newLine();
                    result.flush();
                    // 关闭
                    bufferedReader.close();
                    bufferedWriter.close();
//                    result.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }


    static String fileName = "files\\server.txt";

    static void serverFile() throws IOException {
        //创建服务器端的Socket对象(ServerSocket)
        ServerSocket serverSocket = new ServerSocket(8888);
        //监听客户端连接，返回一个Socket对象
        Socket socket = serverSocket.accept();
        //接收数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //数据写入文件
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
//            bufferedWriter.write(line);
//            bufferedWriter.newLine();
//            bufferedWriter.flush();
            fileOutputStream.write(line.getBytes());
            fileOutputStream.write("\r\n".getBytes());
            fileOutputStream.flush();
        }

        serverSocket.close();
        bufferedReader.close();

    }

    public static void server() throws IOException {
        //创建服务器端的Socket对象(ServerSocket)
        ServerSocket serverSocket = new ServerSocket(8888);

        //监听客户端连接，返回一个Socket对象
        Socket socket = serverSocket.accept();

        //获取输入流
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        String s = new String(bytes, 0, read);
        System.out.println("数据是\n" + s);

        //给客户端反馈
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("数据已收到".getBytes());

        //释放资源
        serverSocket.close();
    }

    static void serverKeyboard() throws IOException {
        //创建服务器端的Socket对象(ServerSocket)
        ServerSocket serverSocket = new ServerSocket(8888);

        //监听客户端连接，返回一个Socket对象
        Socket socket = serverSocket.accept();

        //获取输入流
//        InputStream inputStream = socket.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        serverSocket.close();
    }


}
