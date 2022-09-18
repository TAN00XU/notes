package com.tan00xu.dailymail.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

/**
 * http请求工具
 *
 * @author TAN00XU
 * @date 2022/09/05
 */
public class HttpRequestUtil {


    /**
     * GET请求得到json
     *
     * @param httpUrl http url
     * @return {@link String} json
     */
    public static String getJson(String httpUrl) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            URL url = new URL(httpUrl);
            //获取HttpURRLConnection对象
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //获取到内容编码
            String contentEncoding = connection.getContentEncoding();
            //缓存字符流
            BufferedReader bufferedReader = null;
            //输入流
            InputStream inputStream = connection.getInputStream();
            if ("gzip".equalsIgnoreCase(contentEncoding)) {
                //如果使用了gzip压缩就进行解压
                GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
                InputStreamReader reader = new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8);
                bufferedReader = new BufferedReader(reader);
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            }
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
//            CharBuffer charBuffer = CharBuffer.allocate(1024);
//            while (bufferedReader.read(charBuffer) != -1) {
//                charBuffer.flip();//注意，这里不调会死循环。。。flip()将缓存字节数组的指针设置为数组的开始序列即数组下标0。这样就可以从buffer开头，对该buffer进行读取。
//                stringBuffer.append(charBuffer.toString());
//            }
            // 关闭流
            inputStream.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String httpUrl = "https://devapi.qweather.com/v7/weather/now?location=101270802&key=24134c7fcaa04dc4836601bfae6bd3d4";
//        String httpUrl = "http://api.tianapi.com/caihongpi/index?key=ad2c4b18e5812fc18c0c3f4a14665575";
        System.out.println(getJson(httpUrl));
    }

}
