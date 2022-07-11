package Netzwerk;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckResponseCode {
    public static void main(String[] args) {
        try {
            URL url = new  URL("https://campus02.at");
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();

            int responseCode= httpURLConnection.getResponseCode();

            if(responseCode!=200){
                System.out.println("ALERT - Website funktioniert nicht...ERROR: ");
            }
            else {
                System.out.println("Alles funktioniert gut!");
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
