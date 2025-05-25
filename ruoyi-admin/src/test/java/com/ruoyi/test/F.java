package com.ruoyi.test;

public class F {

    static class WorkerSender implements Runnable {
        @Override
        public void run() {

        }

    };
    static Thread worders = new Thread(new WorkerSender(), "worker");

    public static void main(String[] args) {
        worders.start();
    }
}
