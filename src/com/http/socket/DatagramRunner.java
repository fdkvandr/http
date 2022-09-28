package com.http.socket;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class DatagramRunner {

    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        try (DatagramSocket datagramSocket = new DatagramSocket()) { //—оздаем сокет дл€ отправки сообщений
//            byte[] bytes = new byte[512]; //–азмер обычно регламентируетс€, потому что он должен быть примерно одинаковым дл€ клиента и дл€ сервера. ≈сли количество байт в пакете больше, чем может прин€ть сервер, то оставша€с€ часть будет просто утер€на.
            byte[] bytes = "Hello from UDP socket!".getBytes(); //Ќо мы просто отправим строку
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 7777); //—оздаем пакет дл€ отправки
            datagramSocket.send(packet);
        }
    }
}
