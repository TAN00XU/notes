package com.tan00xu.utils;

import java.io.*;

/**
 * @author TAN00XU
 * @date 2022/09/08 15:14
 */
public class ReadWriteUtils {
    static final String BASE_PATH = "src/main/resources/";

    public static void writeObject(Object object,String filePath){
        File file = new File(BASE_PATH+filePath);
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();

            try {
                file.createNewFile();
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        }

        try {
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Object readObject(String filePath) {
        File file = new File(BASE_PATH+filePath);
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream= new ObjectInputStream(new FileInputStream(file));
            return objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
