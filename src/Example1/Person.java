package Example1;

public class Person implements Runnable {

    private boolean isRunning =true; //ovo trebam za zaustaviti

    public void requestShutDown(){
        isRunning=false;
    }

   private String name;
   public Person(String name ){
       this.name=name;
   }

    public String getName() {
        return name;
    }

    @Override
    public void run() {


       while(isRunning){  //-->oder mit vor scchleife un if bedinung isRunning/und else block mit break
            System.out.println(getName() + " "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
