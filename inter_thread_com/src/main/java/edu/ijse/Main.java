package edu.ijse;

public class Main {
    public static void main(String[] args) {
        Box box = new Box();
        Consumer consumer = new Consumer(box);
        Producer producer = new Producer(box);

        producer.start();
        consumer.start();
    }
}

class Producer extends Thread {
    Box box;

    public Producer(Box box) {
        this.box = box;
    }

    public void run() {
        int i = 0;
        while (true) {
            box.addValue(i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    Box box;

    public Consumer(Box box) {
        this.box = box;
    }

    public void run() {
        while (true) {
            int value = box.removeValue();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Box {
    int valueBOx;
    boolean hasPut = false;

    public synchronized void addValue(int value) {
        while (hasPut) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        valueBOx = value;
        System.out.println("Adding " + value + " to box");
        hasPut = true;
        notify();
    }

    public synchronized int removeValue() {
        while (!hasPut) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        int val = valueBOx;
        System.out.println("Removing " + val + " from box");
        hasPut = false;
        notify();
        return val;
    }
}
