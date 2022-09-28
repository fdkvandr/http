package com.http.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class UrlExample {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com"); // Указываем протокол и домен
        URLConnection urlConnection = url.openConnection(); // Открываем соединение

        System.out.println(new String(urlConnection.getInputStream().readAllBytes())); // Получили html страничку

        urlConnection.setDoOutput(true); // Для метода POST
        try (OutputStream outputStream = urlConnection.getOutputStream()) { // Создаем outputStream куда будем записывать наш body
            outputStream.write("Hello world!".getBytes()); // Записываем наш body
        }
    }
}
