package edu.ijse;

import java.util.concurrent.atomic.AtomicInteger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
       Adder adder=new Adder();
        Thread t1 = new Thread(()->{
            for(int i=0;i<1000;i++){
                adder.Increment();
            }
        });
        Thread t2 = new Thread(()->{
             for(int i=0;i<1000;i++){
                 adder.Increment();
             }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(adder.num);
    }

    static class Adder{
        int num=0;

        public synchronized void  Increment(){
            num++;//while one thread accessing a method it locked for other threads by synchronized
            //deadlock-infinite loop
            //race condition-unpredictable result// use synchronized to avoid this
        }
//        public synchronized void  Decrement(){
//            num--;
//        }
    }
}