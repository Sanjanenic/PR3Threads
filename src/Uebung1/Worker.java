package Uebung1;

import java.util.Date;

public class Worker implements Runnable{
    private final int sleepInterval=1000;
    private boolean isRunning =true; //ovo trebam za zaustaviti

    public void requestShutDown(){
        isRunning=false;
    }


    @Override
    public void run() {



       while(isRunning==true){
           Date current_Date =new Date();
            System.out.println(current_Date.toString());
            try {


                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
