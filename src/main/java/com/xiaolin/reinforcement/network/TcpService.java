package com.xiaolin.reinforcement.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lzh
 * @description: tcp服务端
 * @date 2025/10/30 17:05
 */
public class TcpService {

    public static void main(String[] args) throws IOException {

        // 创捷服务端socket
        ServerSocket ss = new ServerSocket(10086);

        // 监听
        Socket accept = ss.accept();

        // 获取输入流
        InputStream is = accept.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);

//        byte[] bytes = new byte[1024];
        int b;
        while ((b = isr.read()) != -1) {
            System.out.println((char) b);
//            System.out.println("接收的数据：" + new String(bytes, 0, b));

        }

        // 释放
        is.close();
        accept.close();
    }
}
