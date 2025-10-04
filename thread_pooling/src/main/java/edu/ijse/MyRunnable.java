package edu.ijse;

class MyRunnable implements Runnable {
    String  name;
    public MyRunnable(String name) {
        this.name = name;
    }
    @Override
        public void run() {
        System.out.println(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("run end");
    }
}