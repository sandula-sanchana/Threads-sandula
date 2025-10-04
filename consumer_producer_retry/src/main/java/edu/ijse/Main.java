package edu.ijse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         Box box = new Box();
         Consumer consumer = new Consumer(box);
         Producer producer = new Producer(box);
         Thread producerThread = new Thread(producer);
         Thread consumerThread = new Thread(consumer);
         producerThread.start();
         consumerThread.start();
    }


}

class Producer implements Runnable {
   private Box box;
   public Producer(Box box) {
       this.box = box;
   }
   int count = 0;
    @Override
    public void run() {
       while (true) {
           box.put(count);
           System.out.println(count);
           count++;
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
           }
       }
    }
}

class Consumer implements Runnable {
    private Box box;
    public Consumer(Box box) {
        this.box = box;
    }
    @Override
    public void run() {
        while (true) {
            int removed=box.get();
            System.out.println(removed);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Box{
    boolean flag = false;
    int BoxValue ;

    public synchronized void put(int value){
        while(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        BoxValue =value;
        flag = true;
        notify();
    }

    public synchronized int get(){
        while(!flag){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        flag = false;
        notify();
        return BoxValue;
    }

}