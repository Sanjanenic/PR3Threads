package Example1;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        Runnable person1 = new Person("Person -1");
        Runnable person2 = new Person("Person -2");

        Thread t1= new Thread(person1);
        Thread t2= new Thread(person2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
                e.printStackTrace();
        }

        System.out.println("ENDE");
    }


}
