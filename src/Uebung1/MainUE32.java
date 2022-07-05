package Uebung1; //zu verbessern

import Example1.ConsoleHelper;

import java.util.Date;

public class MainUE32 {
    public static void main(String[] args) {

        Worker date1= new Worker();
        Thread t1=new Thread(date1);

        Date d = new Date();
        Thread t2=new Thread(String.valueOf(d));


        t1.start();
        t2.start();
        System.out.println("T1 - "+ t1.getState());
        System.out.println("T2 - "+ t2.getState());

        System.out.println("Bitte drucken sie eine Taste, um die Threads zu stoppen");
        if(ConsoleHelper.readLine() !=null){
            date1.requestShutDown();


            //t1.stop(); --> alternative ist das
        }
        try {

            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ENDE");
    }

}
