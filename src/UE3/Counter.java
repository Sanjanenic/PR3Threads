package UE3;  //zu vergleichen

public class Counter implements Runnable {
    private static Object lock = new Object();
    public int counter=0;
    @Override
    public void run() {

        synchronized (lock) {

           while(counter<20) {
                lock.notifyAll();
                counter++;

                System.out.println(Thread.currentThread().getName() + "Counter ______ " + counter);

                try {
                    Thread.sleep(1000);
               lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
                lock.notify();  //RELESES ALL WEITINGtHEADS
            }


        }
    }


}
