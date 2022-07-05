package Example1.erweiterung.Example1;

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

    private static Object lock = new Object();


    @Override
    public void run() {
      synchronized (lock) {

          while (isRunning) {  //-->oder mit vor scchleife un if bedinung isRunning/und else block mit break
              System.out.print("[");
              System.out.print(getName() + " " + Thread.currentThread().getName());
              System.out.println("]");

              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }

      }

    }
}
