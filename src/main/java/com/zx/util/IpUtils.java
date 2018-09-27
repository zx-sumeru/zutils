package com.zx.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Create by zx on 2018/9/27 8:26
 */
public class IpUtils {
    private static final Logger logger = LoggerFactory.getLogger(IpUtils.class);

    public static String getHostIp() {
        String ip = null;
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface networkInterface = en.nextElement();
                Enumeration<InetAddress> enumIpAddr = networkInterface.getInetAddresses();
                while (enumIpAddr.hasMoreElements()) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()
                            && !inetAddress.isLinkLocalAddress()
                            && inetAddress.isSiteLocalAddress()) {
                        ip = inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            logger.error("Fail to get IP address.", e);
        }
        return ip;
    }

    public static String getHostName() {
        String hostName = null;
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface networkInterface = en.nextElement();
                Enumeration<InetAddress> enumIpAddr = networkInterface.getInetAddresses();
                while (enumIpAddr.hasMoreElements()) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()
                            && !inetAddress.isLinkLocalAddress()
                            && inetAddress.isSiteLocalAddress()) {
                        hostName = inetAddress.getHostName();
                    }
                }
            }
        } catch (SocketException e) {
            logger.error("Fail to get host name.", e);
        }
        return hostName;
    }

    public static void main(String[] args) {
        System.out.println(getHostIp());
        System.out.println(getHostName());
    }
}
