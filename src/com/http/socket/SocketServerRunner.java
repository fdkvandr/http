package com.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerRunner {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(7777);
             Socket socket = serverSocket.accept(); //∆дем, пока кто-то подключитс€
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream()); // —юда мы будем отсылать response клиенту
             DataInputStream inputStream = new DataInputStream(socket.getInputStream()); // —юда получим запрос от клиента
             Scanner scanner = new Scanner(System.in)) {

            String request = inputStream.readUTF();
            while (!"stop".equals(request)) {
                System.out.println("Client request " + request);
                String response = scanner.nextLine();
                outputStream.writeUTF(response);
                request = inputStream.readUTF();
            }
        }
    }
}
