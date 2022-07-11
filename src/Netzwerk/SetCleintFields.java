package Netzwerk;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SetCleintFields {
    public static void main(String[] args) {

        try{
        URL url = new  URL("https://campus02.at");
            URLConnection urlConnection= url.openConnection();

            System.out.println();

            //ovo nisam stigla do krajan



    } catch (MalformedURLException e) {
                e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
