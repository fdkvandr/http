package com.http.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpServer {

    private final int port; // Номер нашего порта

    public HttpServer(int port) { // Инициализируем наш порт
        this.port = port;
    }

    public void run() { // Метод который будет запускать наш сервер
        try {
            ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();
            processSocket(socket); // Обработаем наш запрос
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) { // Метод который обработает запрос
        try (socket; // Он реализует интерфейс Cloasable. Возможность помещать уже созданный объект в try with resources появялась позже Java 1.8
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {
            // step 1 handle request
            System.out.println("Request " + new String(inputStream.readNBytes(400)));

            // step 2 creating response
            byte[] body = Files.readAllBytes(Path.of("resources", "example.html"));
            String headers = String.format("""
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-lengths: %s
                    """, body.length);
            outputStream.write(headers.getBytes());
            outputStream.write(System.lineSeparator().getBytes()); // Добавим пустую строку
            outputStream.write(body);
        } catch (IOException e) {
            // TODO: 28.09.2022 log error message
            e.printStackTrace();
        }

    }
}
