package Uebung1;

import Example1.ConsoleHelper;

public class Main {
    public static void main(String[] args) {

        Worker date1= new Worker();
        Thread t1=new Thread(date1);

        t1.start();
        System.out.println("T1 - "+ t1.getState());
        System.out.println("Bitte drucken sie eine Taste, um die Threads zu stoppen");
        if(ConsoleHelper.readLine() !=null){
            date1.requestShutDown();


            System.out.println(t1.getState());

            //t1.stop(); --> alternative ist das
        }
        try {

            t1.join();
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
        System.out.println("ENDE");
    }

}
