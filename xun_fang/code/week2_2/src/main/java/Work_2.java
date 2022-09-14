import java.io.*;

/**
 * 复制多级文件夹【应用】
 *
 * @author TAN00XU
 * @date 2022/09/13 18:10
 */
public class Work_2 {

    public static void main(String[] args) throws IOException {
        //创建数据源File对象
        File srcFile = new File("E:\\TAN00XU\\Desktop\\网页背景");
        //创建目的地File对象
        File destFile = new File("E:\\copy");
        //写方法实现文件夹的复制，参数为数据源File对象和目的地File对象
        copyFolder(srcFile, destFile);
    }

    /**
     * 复制文件夹
     *
     * @param srcFile  源文件位置
     * @param destFile 目标文件位置
     * @throws IOException ioexception
     */
    public static void copyFolder(File srcFile, File destFile) throws IOException {
        //判断数据源File是否是目录
        if (srcFile.isDirectory()) {
            //在目的地下创建和数据源File名称一样的目录
            String srcFileName = srcFile.getName();
            System.out.println("srcFileName" + srcFileName);
            File newFolder = new File(destFile, srcFileName);
            if (!newFolder.exists()) {
                newFolder.mkdir();
            }
            //获取数据源File下所有文件或者目录的File数组
            File[] fileArray = srcFile.listFiles();
            //遍历该File数组，得到每一个File对象
            for (File file : fileArray) {
                //把该File作为数据源File对象，递归调用复制文件夹的方法
                copyFolder(file, newFolder);
            }
        } else {
            //说明是文件，直接复制，用字节流
            File newFile = new File(destFile, srcFile.getName());
            copyFile(srcFile, newFile);
        }
    }

    /**
     * 复制文件
     *
     * @param srcFile  源文件位置
     * @param destFile 目标文件位置
     * @throws IOException ioexception
     */
    public static void copyFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bos.close();
        bis.close();
    }
}


