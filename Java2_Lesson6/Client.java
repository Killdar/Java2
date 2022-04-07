package ru.geekbrains.com;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        CLI cli = new CLI();
        System.out.println("Клиент запущен. Подключение к локальному хосту: 8080 ");

        new Thread(() -> {
            try {
                cli.readMSG();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                cli.sendMSG();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class CLI {
    Socket socket = null;
    BufferedReader in = null;
    PrintWriter out= null;
    BufferedReader console = null;
    String userMsg, serverMsg;

    public CLI() throws IOException {
        socket = new Socket("localhost",8080);
        in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    void sendMSG() throws IOException {
        while (true) {
            if ((userMsg = console.readLine()) != null) {
                out.println(userMsg);
                if (userMsg.equalsIgnoreCase("close") || userMsg.equalsIgnoreCase("exit")) break;
            }
        }
    }

    void readMSG() throws IOException {
        while (true) {
            if ((serverMsg = in.readLine()) != null){
                System.out.println(serverMsg);
            }
        }
    }

      void close() throws IOException {
        out.close();
        in.close();
        console.close();
        socket.close();
    }
}
