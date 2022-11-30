package com.example.f22comp1011s2movies;

public class ThreadExperiment {
    public static void main(String[] args) {
//        MyCustomThread customThread1 = new MyCustomThread("ct1");
//        MyCustomThread customThread2 = new MyCustomThread("ct2");
//        MyCustomThread customThread3 = new MyCustomThread("ct3");
//        MyCustomThread customThread4 = new MyCustomThread("ct4");
//        MyCustomThread customThread5 = new MyCustomThread("ct5");
//        customThread1.start();
//        customThread2.start();
//        customThread3.start();
//        customThread4.start();
//        customThread5.start();

        Runnable netanPlaneRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Started: "+Thread.currentThread().getName());
                System.out.println("Ended: "+Thread.currentThread().getName());
            }
        };

        Thread npr1 = new Thread(netanPlaneRunnable, "thread-1");
        Thread npr2 = new Thread(netanPlaneRunnable, "thread-2");
        Thread npr3 = new Thread(netanPlaneRunnable, "thread-3");
        Thread npr4 = new Thread(netanPlaneRunnable, "thread-4");
        Thread npr5 = new Thread(netanPlaneRunnable, "thread-5");

        npr1.start();
        npr2.start();
        npr3.start();
        npr4.start();
        npr5.start();

    }
}
