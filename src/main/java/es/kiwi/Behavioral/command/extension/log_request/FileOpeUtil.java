package es.kiwi.Behavioral.command.extension.log_request;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 读写文件的辅助工具类
 */
public class FileOpeUtil {

    /**
     * 私有化构造方法，避免外部无谓的创建类实例
     * 这个工具类不需要创建类实例
     */
    private FileOpeUtil() {

    }

    /**
     * 该文件,从文件中获取存储的List对象
     *
     * @param pathName 文件路径和文件名
     * @return 存储的List对象
     */
    public static Queue readFile(String pathName) {

        Queue list = new LinkedList();

        ObjectInputStream oin = null;

        try {
            File f = new File(pathName);
            if (f.exists()) {
                oin = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(f)));
                list = (Queue) oin.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oin != null)
                    oin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    /**
     * 写文件，把list对象写到文件中
     * @param pathName 文件路径和文件名
     * @param list 要写到文件的List对象
     */
    public static void writeFile(String pathName, Queue list) {
        File f = new File(pathName);
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(f)));
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
