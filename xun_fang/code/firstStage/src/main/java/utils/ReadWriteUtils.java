package utils;

import java.io.*;
import java.nio.file.Files;

/**
 * @author TAN00XU
 * @date 2022/09/08 15:14
 */
public class ReadWriteUtils {
    static final String BASE_PATH = "src/main/resources/file/";

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
                throw new RuntimeException(ex);
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
//            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
        return null;
    }
}
