package Uebung1;

import java.util.Date;

public class WorkerUE32 implements Runnable {
    private final int sleepInterval = 1000;
    private boolean isRunning = true; //ovo trebam za zaustaviti

    public void requestShutDown() {
        isRunning = false;
    }

    private static Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {


            while (isRunning == true) {
                Date d = new Date();
               // System.out.println(current_Date.toString());

               // System.out.println(t1.getState());
                System.out.print("[");
                System.out.print(d.toString());
                System.out.print(", CPUS: ");
                System.out.print(Runtime.getRuntime().availableProcessors());
                System.out.print(", FreeMem: ");
                System.out.print(Runtime.getRuntime().freeMemory());
                System.out.print("]");
                try {


                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


