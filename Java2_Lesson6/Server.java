package ru.geekbrains.com;

//Java 2. Lesson 6.
//Ученик Николай Горобий
//1. Написать консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения,
// как на клиентской стороне, так и на серверной. Т.е. если на клиентской стороне написать "Привет",
// нажать Enter то сообщение должно передаться на сервер и там отпечататься в консоли.
// Если сделать то же самое на серверной стороне, сообщение соответственно передается клиенту и печатается у него в консоли.
// Есть одна особенность, которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд, такую ситуацию необходимо корректно обработать

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
            SRV s = new SRV();
            s.start();
            s.catchClient();
            new Thread(() -> {
                while (true) {
                    String txt = null;
                    try {
                        txt = s.in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (txt != null) {
                        try {
                            s.sendMessage(txt);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            new Thread(() -> {
                try {
                    s.writeToConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            s.writeToConsole();
        }
    }

    class SRV {
        BufferedReader in = null;
        PrintWriter out = null;
        ServerSocket serverSocket = null;
        Socket socket = null;
        String input;
        BufferedReader console = null;

        void start() {
            try {
                serverSocket = new ServerSocket(8080);
            } catch (IOException e) {
                System.out.println("Не возможно открыть порт 8080 ");
                System.exit(1);
            }
            System.out.print("Сервер запущен. Ожидание пользователя...");
        }

        void catchClient() throws IOException {
            try {
                socket = serverSocket.accept();
                System.out.println("Пользователь подключился");
            } catch (IOException e) {
                System.out.println("Отказ в доступе");
                System.exit(1);
            }

            in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);

            System.out.println("Ожидание ответа...");
        }

        void sendMessage(String msg) throws IOException {
            if (msg.equalsIgnoreCase("exit")) close();
            out.println("Сервер: " + msg);
            System.out.println(msg);
        }

        void close() throws IOException {
            out.close();
            in.close();
            socket.close();
            serverSocket.close();
        }

        void writeToConsole() throws IOException {
            while (true) {
                console = new BufferedReader(new InputStreamReader(System.in));
                String txt = console.readLine();
                sendMessage(txt);
            }
        }
}

