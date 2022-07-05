package Example1;

public class Person implements Runnable {

   private String name;
   public Person(String name ){
       this.name=name;
   }

    public String getName() {
        return name;
    }

    @Override
    public void run() {

      //  System.out.println("HELLO " + getName());
        for(int i =0; i<10; i++){
            System.out.println(getName() + " "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
