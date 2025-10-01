package edu.ijse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+" p-"+Thread.currentThread().getPriority());
            }
        });
        Thread t2=new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+" p-"+Thread.currentThread().getPriority());
            }
        });
        t1.start();
        t1.setPriority(Thread.MAX_PRIORITY);//priority max-10,5,min-1
        t1.join();//pause the current thread untill the t1 is complete(pause main thread here)
        System.out.println(t1.isAlive());
        t2.start();
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.join();
        System.out.println(t2.isAlive());//check if the calling thread is running or not
        System.out.println("bb");//this prints 1st because the main thread starts first and the proceed to the other threads

    }
}