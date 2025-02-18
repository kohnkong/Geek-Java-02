package com.geekbang.JVM.gateway;

import com.geekbang.JVM.gateway.inbound.HttpInboundServer;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author: kongqf
 * @date: 2021年03月30日 22:19
 */
public class NettyServerApplication {
    public static final String GATEWAY_NAME = "NIOGateway";
    public static final String GATEWAY_VERSION = "3.0.0";

    public static void main(String[] args) {
        String proxyPort = System.getProperty("proxyPort", "8888");

        String proxyServers = System.getProperty("proxyServers", "http://localhost:8801,http://localhost:8802");
        int port = Integer.parseInt(proxyPort);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION + " starting...");
        HttpInboundServer server = new HttpInboundServer(port, Arrays.asList(proxyServers.split(",")));
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION + " started at http://localhost:" + port + " for server:" + server.toString());
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
