package com.cascado.lesson6;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String userName;
    private static final String IP = "127.0.0.1";
    private static final int PORT = 8189;

    public Client(Socket socket, String userName){
        try{
            this.socket = socket;
            this.userName = userName;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e){
            closeEverything(socket, bufferedWriter, bufferedReader);
        }
    }

    public void sendMessage(){
        try {
            bufferedWriter.write(userName);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()){
                String messageToSend = scanner.nextLine();
                bufferedWriter.write(userName + ": " + messageToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e){
            closeEverything(socket, bufferedWriter, bufferedReader);
        }
    }

    public void listenForMessages(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String messageFromGroupChat;

                while (socket.isConnected()){
                    try {
                        messageFromGroupChat = bufferedReader.readLine();
                        System.out.println(messageFromGroupChat);
                    } catch (IOException e){
                        closeEverything(socket, bufferedWriter, bufferedReader);
                    }
                }
            }
        }).start();
    }

    public void closeEverything(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader){
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }

            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

            if (socket != null) {
                socket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username for group chat: ");
        String userName = scanner.nextLine();
        Socket socket = new Socket(IP, PORT);
        Client client = new Client(socket, userName);
        client.listenForMessages();
        client.sendMessage();

    }

}