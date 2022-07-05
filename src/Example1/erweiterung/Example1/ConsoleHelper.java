package Example1.erweiterung.Example1;

import java.util.Scanner;

public class ConsoleHelper {
    public static String readLine(){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        return s;
    }
}
