package com.xiaolin.reinforcement.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @author lzh
 * @description: 接收消息的客户端
 * @date 2025/10/30 16:00
 */
public class UdpReceiveMessage {

    public static void main(String[] args) throws IOException {
        //unicast();

        multicast();
    }

    private static void multicast() throws IOException {
        MulticastSocket ms = new MulticastSocket(10000);

        ms.joinGroup(InetAddress.getByName("224.0.0.1"));

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        // 接收
        ms.receive(dp);

        System.out.println("接收主机 " + dp.getAddress() + ":" + dp.getPort() + ",发送的数据: " + new String(dp.getData(), 0, dp.getLength()));

        ms.close();
    }

    // 单播
    private static void unicast() throws IOException {
        //创建接收消息的Socket通道
        // 接收的时候 一定要绑定端口
        DatagramSocket ds = new DatagramSocket(10086);

        // 接收
        while (true) {

            // 接收数据packet
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println("接收到主机 " + dp.getAddress() + ":" + dp.getPort() + ",发送的数据: " + str);
        }

        // ds.close();
    }
}
