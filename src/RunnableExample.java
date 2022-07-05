import java.sql.SQLOutput;

public class RunnableExample implements Runnable {
    public static void main(String[] args) {
        System.out.println("Thread 1 "+ Thread.currentThread().getName());
      //  System.out.println("Create runnable");
        Runnable runnable=new RunnableExample();


      //  System.out.println("Create thread");
        Thread thread = new Thread();
        System.out.println(thread.getName());

      //  System.out.println("Start Thread");
        thread.start();
    }
    @Override

    public void run() {
        System.out.println("LOGIC THREAD START");
        System.out.println("Thread: "+Thread.currentThread().getName());
        System.out.println("LOGIC THREAD START");
    }
}
