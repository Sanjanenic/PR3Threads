package Example1.erweiterung.Example1;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person("Person -1");
        Person person2 = new Person("Person -2");

        Thread t1= new Thread(person1);
        Thread t2= new Thread(person2);

        t1.start();
        t2.start();

        System.out.print("T1 - "+ t1.getState());
        System.out.println("T2 - "+ t2.getState());
        System.out.print("Bitte drucken sie eine Taste, um die Threads zu steoppen");

        if(ConsoleHelper.readLine() !=null){
           person1.requestShutDown();
           person2.requestShutDown();

            System.out.println(t1.getState());
            System.out.println(t2.getState());
            //t1.stop(); --> alternative ist das
        }


        try {
            t1.join();
            t2.join();

            System.out.println(t1.getState());
            System.out.println(t2.getState());
        } catch (InterruptedException e) {
                e.printStackTrace();
        }

        System.out.println("ENDE");
    }


}
