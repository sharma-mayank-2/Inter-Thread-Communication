package com.app;

/**
 * class to implement bank using Thread and interThread Communication.
 */
public class Bank {
    int amount = 10000;
    public static void main(String[] args) {
        final Bank bank = new Bank();
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            bank.withdraw(11000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            bank.deposit(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        t1.start();
        t2.start();
    }

    public synchronized void withdraw(int amount) throws InterruptedException {
        System.out.println("withdrawing started");
        if(this.amount < amount){
            System.out.println("amount is less");
            wait();
        }
        this.amount -= amount;
        System.out.println(this.amount);
        System.out.println("withdraw is completed");
    }

    public synchronized void deposit(int amount) throws InterruptedException {
        Thread.sleep(100);
        System.out.println("deposited the amount");
        this.amount += amount;
        System.out.println(this.amount);
        notify();
    }
}


