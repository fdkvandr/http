package com.http.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramServerRunner {

    public static void main(String[] args) throws IOException {
        try (DatagramSocket datagramServer = new DatagramSocket(7777)) { //�������� ����, �� ������� ����� �������� ������
            byte[] buffer = new byte[512]; // ���� ����� ������������ ������
            DatagramPacket paket = new DatagramPacket(buffer, buffer.length); //������� �����, ���� ����� ������������ ������
            datagramServer.receive(paket); // �������� �����

            System.out.println(new String(buffer));
//            System.out.println(new String(paket.getData())); ��� ���� �����
        }
    }
}
