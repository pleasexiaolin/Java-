package com.xiaolin.reinforcement.file;

import java.io.File;

/**
 * @author lzh
 * @description: 文件案例
 * @date 2025/10/30 19:52
 */
public class FileDemo {

    public static void main(String[] args) {
        // 创建
        String path = "E:\\admin\\Desktop\\aaa";
        File file = new File(path);
        System.out.println(file);

        String name = file.getName();
        // 大小是字节 想换成 KB MB G 需要不断除于1024
        // 无法获取文件夹大小 需要遍历
        long length = file.length();
        String absolutePath = file.getAbsolutePath();
        File[] files = file.listFiles();

        // 输出参数
        System.out.println("文件名：" + name);
        System.out.println("文件大小：" + length);
        System.out.println("文件绝对路径：" + absolutePath);

        String parent = "E:\\admin\\Desktop";
        String child = "a.txt";
        File file1 = new File(parent, child);
        System.out.println(file1);

        File file2 = new File(file, child);
        System.out.println(file2);

    }
}
