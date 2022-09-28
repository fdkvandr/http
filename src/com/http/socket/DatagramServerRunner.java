package com.http.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramServerRunner {

    public static void main(String[] args) throws IOException {
        try (DatagramSocket datagramServer = new DatagramSocket(7777)) { //ѕередаем порт, на котором будет работать сервер
            byte[] buffer = new byte[512]; // —юда будут записыватьс€ данные
            DatagramPacket paket = new DatagramPacket(buffer, buffer.length); //—оздаем пакет, куда будут записыватьс€ данные
            datagramServer.receive(paket); // ѕолучаем пакет

            System.out.println(new String(buffer));
//            System.out.println(new String(paket.getData())); это тоже самое
        }
    }
}
