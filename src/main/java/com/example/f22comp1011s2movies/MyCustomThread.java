package com.example.f22comp1011s2movies;

public class MyCustomThread extends Thread {

    public MyCustomThread(String name)
    {
        this.setName(name);
    }

    /**
     * This is the code that operates in the Thread when it runs
     */
    public void run(){
        System.out.println("Started: "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ended: "+Thread.currentThread().getName());
    }
}
