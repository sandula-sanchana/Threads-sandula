package edu.ijse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       A a = new A();
       a.start();
       B b = new B();
       b.start();

        }

}

class A extends Thread {
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println("A");
        }

    }
}

class B extends Thread {
    public void run() {
       for (int i = 1; i <10; i++) {
           System.out.println("B");
       }
    }
}