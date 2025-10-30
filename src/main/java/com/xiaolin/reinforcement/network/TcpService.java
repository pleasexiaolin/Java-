package com.xiaolin.reinforcement.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lzh
 * @description: tcp服务端
 * @date 2025/10/30 17:05
 */
public class TcpService {

    public static void main(String[] args) throws IOException {

        // 简单的tcp通信
        //common();

        // 需求
        // 客户端 将文件上传到服务器 接收服务器反馈
        // 服务端 接收客户端的文件，上传完毕给出反馈

        ServerSocket ss = new ServerSocket(10086);

        Socket accept = ss.accept();

        InputStream is = accept.getInputStream();

        FileOutputStream fos = new FileOutputStream("D:\\Project\\Practice\\Java-Practice\\testCopy.txt");

        byte[] bytes = new byte[12];
        int len;
        while ((len = is.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }

        // 释放
        is.close();
        accept.close();
    }

    private static void common() throws IOException {
        // 创捷服务端socket
        ServerSocket ss = new ServerSocket(10086);

        // 监听
        Socket accept = ss.accept();

        // 获取输入流
        InputStream is = accept.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);

        // byte[] bytes = new byte[1024];
        int b;
        while ((b = isr.read()) != -1) {
            System.out.println((char) b);
            // System.out.println("接收的数据：" + new String(bytes, 0, b));
        }

        // 释放
        is.close();
        accept.close();
    }
}
