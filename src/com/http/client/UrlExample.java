package com.http.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class UrlExample {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com"); // ��������� �������� � �����
        URLConnection urlConnection = url.openConnection(); // ��������� ����������

        System.out.println(new String(urlConnection.getInputStream().readAllBytes())); // �������� html ���������

        urlConnection.setDoOutput(true); // ��� ������ POST
        try (OutputStream outputStream = urlConnection.getOutputStream()) { // ������� outputStream ���� ����� ���������� ��� body
            outputStream.write("Hello world!".getBytes()); // ���������� ��� body
        }
    }
}
