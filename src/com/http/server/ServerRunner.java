package com.http.server;

public class ServerRunner {

    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(9000, 100); // 100 ����������� - �������� ��������, ��� ������������ � Apache Tomcat
        httpServer.run();
    }
}
