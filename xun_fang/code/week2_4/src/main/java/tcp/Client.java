package tcp;

import java.io.*;
import java.net.Socket;

/**
 * 客户端类
 *
 * @author TAN00XU
 * @date 2022/09/15
 */
public class Client {
    public static void main(String[] args) throws IOException {
        clientThread();
    }


    static String fileName = "files\\client.txt";


    static void clientThread() throws IOException {
        //创建客户端的Socket对象
        Socket socket = new Socket("localhost", 8888);

        //封装文本文件数据
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));


        //封装输出流写入数据
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        //传输结束标记
        socket.shutdownOutput();
        //接收反馈
        BufferedReader response = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("服务器响应=>" + response.readLine());


        socket.close();
        bufferedReader.close();
    }


    static void clientFile() throws IOException {
        //创建客户端的Socket对象
        Socket socket = new Socket("localhost", 8888);

        //封装文本文件数据
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));


        //封装输出流写入数据
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        socket.close();
        bufferedReader.close();
    }


    public static void client() throws IOException {
        //创建客户端的Socket对象
        Socket socket = new Socket("localhost", 8888);

        //获取输出流，写数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,TCP".getBytes());

        //接收服务器反馈
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        System.out.println("服务器的反馈是:\n" + new String(bytes, 0, read));

        // 释放资源
        socket.close();
    }

    static void clientkeyboard() throws IOException {
        //创建客户端的Socket对象
        Socket socket = new Socket("localhost", 8888);
        //数据来自键盘
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //封装输出流对象
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            if ("886".equals(line)) {
                break;
            }

            //获取输入流对象
//            socket.getOutputStream().write(line.getBytes());
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        socket.close();
    }


}

