package cn.itcast.web.ui;

public class XXX {


    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        new Thread(myThread).start();
        myThread.start();
    }

    synchronized public void xx() {

    }
}


class MyThread extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " xxx");
        }

    }
}