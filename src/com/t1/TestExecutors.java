package com.t1;

public class TestExecutors {
    private int count = 0;
    public synchronized void add(int n) {
        if (n < 0) {
            dec(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec(int n) {
        count += n;
        System.out.println(count);
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main() is start");
        Thread thread=new GoRun();
        thread.start();
        thread.interrupt();
        thread.join();
        System.out.println("main() is end");


    }
}
class GoRun extends Thread {
    @Override
    public void run() {
        System.out.println("Thread go");
        System.out.println("Thread end");
    }
}