package Netzwerk.SingleClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UE4 {
    public static void main(String[] args) {  //ovo nisam zavrsila

        //napraviti array listu Thread ovdje i u nju sacuvavati
        //fali mi jos jedna klasa Communicaton Task
        List<Thread> clients =new ArrayList<>();

        System.out.println("Warte auf eingehende Verbindung");
        ServerSocket serverSocket= null;
        try {
            serverSocket = new ServerSocket(9090);

            Socket socket= serverSocket.accept();
            serverSocket.setSoTimeout(30000);  //30 sekuni
            System.out.println("Client hat sich verbunden!");

            BufferedWriter bufferedWriter=
                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("HELLO");
            bufferedWriter.newLine();
            bufferedWriter.flush();  //ohne flush funktioniert es nicht

            BufferedReader bufferedReader=
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String command;


// radim sa Thres und socet While
            //poslije toga ide for(Thread t : clients)7
            //t.join();


//            serverSocket = new ServerSocket(9091);
//            Socket socket1= serverSocket.accept();
//            serverSocket.setSoTimeout(30000);
//            System.out.println("Client hat sich verbunden!");
//            BufferedWriter bufferedWriter1=
//                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            bufferedWriter.write("HELLO");
//            bufferedWriter.newLine();
//            bufferedWriter.flush();  //ohne flush funktioniert es nicht
//
//            BufferedReader bufferedReader1=
//                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String command1;
//
//
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
                    bufferedWriter.write("Unknown Cmmand");
                    bufferedWriter.newLine();  //ove dvije linije su neophodne da radi
                    bufferedWriter.flush();

                }
            }

            bufferedReader.close();
            bufferedReader.close();
            System.out.println("Srver wuede beendet");




        } catch (IOException e) {
            e.printStackTrace();



        }

    }
}
