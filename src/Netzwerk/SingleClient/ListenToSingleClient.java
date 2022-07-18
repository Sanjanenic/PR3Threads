package Netzwerk.SingleClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ListenToSingleClient {
    public static void main(String[] args) {

        try {
            System.out.println("Warte auf eingehende Verbindung");
            ServerSocket serverSocket= new ServerSocket(9090);
            Socket socket= serverSocket.accept();  //get weiter nur wenn jemand hat sich verbunden, das ist multiple Socet
            System.out.println("Client hat sich verbunden!");

            BufferedWriter bufferedWriter=
                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("HELLO");
            bufferedWriter.newLine();
            bufferedWriter.flush();  //ohne flush funktioniert es nicht


            BufferedReader bufferedReader=
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String command;

            while((command=bufferedReader.readLine()) !=null){
            System.out.println("Client has send: "+ command);

            if("TIME".equals(command)){
                Date date =new Date();
                bufferedWriter.write(date.toString());

                bufferedWriter.newLine();  //ove dvije linije su neophodne da radi
                bufferedWriter.flush();
            }
            else if("PORT".equals(command)){
                bufferedWriter.write("Remote Port: " + socket.getPort());
                bufferedWriter.write("PORT: " + socket.getLocalPort());
                bufferedWriter.newLine();  //ove dvije linije su neophodne da radi
                bufferedWriter.flush();

            }
            else if("END".equals(command)){
                bufferedWriter.write("ENDE");
                bufferedWriter.newLine();  //ove dvije linije su neophodne da radi
                bufferedWriter.flush();
                break; //ovako izlazimo iz while loop
            }
            else{
                bufferedWriter.write("Unknown Command");
                bufferedWriter.newLine();  //ove dvije linije su neophodne da radi
                bufferedWriter.flush();

            }
            }

            bufferedReader.close();
            bufferedReader.close();
            System.out.println("Srver wurde beendet");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
