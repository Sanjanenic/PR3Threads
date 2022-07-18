package Netzwerk.SingleClient;

import java.io.*;
import java.net.Socket;

public class CleintToServer1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9090);  //ovako se povezujm na server
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));  //citati sa servera
            System.out.println("Answer Server");
            System.out.println(bufferedReader.readLine());

            BufferedWriter bufferedWriter =   //socer je koristen kao komunikacijski kanal
                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //pisati na server
            bufferedWriter.write("PORT");
            bufferedWriter.newLine();  //bitna linija jer bez nje se nista ne desava
            bufferedWriter.flush();
            System.out.println(bufferedReader.readLine());



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
