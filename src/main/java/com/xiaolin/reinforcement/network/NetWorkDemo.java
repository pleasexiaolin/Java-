package com.xiaolin.reinforcement.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author lzh
 * @description: 网络编程 案例
 * @date 2025/10/29 20:11
 */
public class NetWorkDemo {

    public static void main(String[] args) throws UnknownHostException {

        // IP的对象 就是一台电脑 电脑的对象
        InetAddress ip = InetAddress.getByName("DESKTOP-KSB3R9J");

        System.out.println(ip);


    }
}
