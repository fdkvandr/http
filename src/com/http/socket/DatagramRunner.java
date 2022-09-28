package com.http.socket;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class DatagramRunner {

    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        try (DatagramSocket datagramSocket = new DatagramSocket()) { //������� ����� ��� �������� ���������
//            byte[] bytes = new byte[512]; //������ ������ ����������������, ������ ��� �� ������ ���� �������� ���������� ��� ������� � ��� �������. ���� ���������� ���� � ������ ������, ��� ����� ������� ������, �� ���������� ����� ����� ������ �������.
            byte[] bytes = "Hello from UDP socket!".getBytes(); //�� �� ������ �������� ������
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 7777); //������� ����� ��� ��������
            datagramSocket.send(packet);
        }
    }
}
