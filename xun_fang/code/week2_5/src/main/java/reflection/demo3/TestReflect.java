package reflection.demo3;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 运行配置文件指定内容
 *
 * @author TAN00XU
 * @date 2022/09/16 19:33
 */
public class TestReflect {
    public static final File fileName = new File("files\\class.yaml");

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Student student = new Student();
//        Teacher teacher = new Teacher();
        Properties properties = new Properties();
//        properties.put();
//        InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        new FileReader(fileName)
//        String line = null;
//        while ((line = bufferedReader.readLine()) != null) {
//            line = line.trim();
//
//        }
        FileReader fileReader = new FileReader(fileName);
        properties.load(fileReader);
//        fileReader.close();
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        Class<?> aClass = Class.forName(className);
        Object o = aClass.getConstructor().newInstance();
        Method method = aClass.getMethod(methodName);
        method.invoke(o);

    }
}
