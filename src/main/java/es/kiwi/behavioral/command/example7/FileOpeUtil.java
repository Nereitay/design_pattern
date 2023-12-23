package es.kiwi.behavioral.command.example7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 读写文件的辅助工具
 */
public class FileOpeUtil { // 2. 请求队列实现成了List对象，文件操作的工具类，实现向文件中写入List和从文件中获取List的对象
    /**
     * 私有化构造方法，避免外部无谓的创建类实例
     * 这个工具类不需要创建类实例
     */
    private FileOpeUtil() {
    }

    /**
     * 读文件，从文件里面获取存储的List对象
     *
     * @param pathName 文件路径和文件名
     * @return 存储的List对象
     */
    public static List readFile(String pathName) {
        List list = new ArrayList();
        try (ObjectInputStream oin = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(pathName)))) {
            list = (List) oin.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 写文件，把list对象写出到文件中去
     *
     * @param pathName 文件路径和文件名
     * @param list     要写到文件的list对象
     */
    public static void writeFile(String pathName, List list) {
        try (ObjectOutputStream oout = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(pathName)))) {
            oout.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
