//package Netzwerk;
//
//import java.io.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//
//public class readFormular2 {
//    public static void main(String[] args) {
//        try {
//
//
//            URL url = new URL("https://www.google.com");
//            URLConnection urlConnection = url.openConnection();
//
//            BufferedReader bufferedReader= new BufferedReader(
//                    new InputStreamReader(urlConnection.getInputStream()));
//
//            BufferedWriter bufferedWriter =new BufferedWriter(new FileWriter("content.html"));
//
//            //BufferReader verarbeiten
//            String line;
//            while(line = bufferedReader.readLine()) != null){
//
//                System.out.println(line);
//                bufferedWriter.write(line);
//                bufferedWriter.newLine();
//
//              //  nisa zavrsila
//
//            }
//
//
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
