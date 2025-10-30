package com.xiaolin.reinforcement.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 * @author lzh
 * @description: 发送消息 client
 * @date 2025/10/29 20:24
 */
public class UdpSendMessage {

    public static void main(String[] args) throws IOException {

        //Unicast();

        multicast();

    }

    // 组播
    private static void multicast() throws IOException {
        // 创建组播的socket
        MulticastSocket ms = new MulticastSocket();

        // 发送数据的packet 发送的地址要为组播的地址
        byte[] bytes = "hello world".getBytes();
        InetAddress address = InetAddress.getByName("224.0.0.1");
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, 10000);

        // 发送数据
        ms.send(dp);

        // 释放
        ms.close();
    }

    // 单播
    private static void Unicast() throws IOException {
        // 创建发送消息的Socket通道
        DatagramSocket ds = new DatagramSocket();
        System.out.println("输入需要发送的消息：");

        while (true) {
            // 发送数据packet
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            byte[] bytes = str.getBytes();

            // 这里的ip 换成 255.255.255.255 就变成了广播
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 10086);

            // 发送数据
            ds.send(dp);
            if ("886".equals(str)) {
                // 释放
                break;
            }

        }
        ds.close();
    }

}
