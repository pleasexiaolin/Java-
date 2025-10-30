package com.xiaolin.reinforcement.network;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lzh
 * @description: tcp 发送端
 * @date 2025/10/30 17:05
 */
public class TcpClient {

    public static void main(String[] args) throws IOException {
        //common();

        // 需求
        // 客户端 将文件上传到服务器 接收服务器反馈
        // 服务端 接收客户端的文件，上传完毕给出反馈

        Socket socket = new Socket("127.0.0.1", 10086);

        OutputStream os = socket.getOutputStream();

        // D:\Project\Practice\Java-Practice\test.txt
        byte[] bytes = new byte[1024];
        File file = new File("D:\\Project\\Practice\\Java-Practice\\test.txt");
        FileInputStream fis = new FileInputStream(file);
        int len;
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }

        // 关闭流
        os.close();
        socket.close();
    }

    private static void common() throws IOException {
        // 创建客户端的socket对象与指定服务器链接
        Socket socket = new Socket("127.0.0.1", 10086);

        // 获取输出流 写数据
        OutputStream os = socket.getOutputStream();

        os.write("你好".getBytes());

        // 关闭流
        os.close();
        socket.close();
    }
}
