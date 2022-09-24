package com.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunner {

    public static void main(String[] args) throws IOException {
        //http - 80
        //http - 443
        //TCP
        InetAddress inetAddress = Inet4Address.getByName("localhost"); //Для удобства указания хоста можно использовать этот класс. Можно также просто захардкодить строкой.
        try (Socket socket = new Socket(inetAddress, 7777);// Открываем соединение
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream()); // Для того, чтобы отправлять запросы
             DataInputStream inputStream = new DataInputStream(socket.getInputStream()); // Для принятия ответа
             Scanner scanner = new Scanner(System.in)) {

            while (scanner.hasNextLine()) {
                String request = scanner.nextLine();
                outputStream.writeUTF(request); //Отправляем запрос
                System.out.println("Response from server: " + inputStream.readUTF()); // Принимаем ответ
            }
        }
    }
}
