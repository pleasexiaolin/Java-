package com.xiaolin.reinforcement.network;

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
