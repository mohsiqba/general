package com.passport.entities;
import java.util.concurrent.*;

public class ProducerConsumerDemo {

    public static void main(String args[]){

     BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();

     Thread prodThread1 = new Thread(new Producer(sharedQueue,1));
     Thread prodThread2 = new Thread(new Producer(sharedQueue,2));
     Thread consThread1 = new Thread(new Consumer(sharedQueue,1));
     Thread consThread2 = new Thread(new Consumer(sharedQueue,2));

     prodThread1.start();
     prodThread2.start();
     consThread1.start();
     consThread2.start();
    }

}

class Producer implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;
    private int threadNo;

    public Producer(BlockingQueue<Integer> sharedQueue,int threadNo) {
        this.threadNo = threadNo;
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=1; i<= 5; i++){
            try {
                int number = i+(10*threadNo);
                System.out.println("Produced:" + number + ":by thread:"+ threadNo);
                sharedQueue.put(number);
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        try {
			sharedQueue.put(-1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}

class Consumer implements Runnable{

    private final BlockingQueue<Integer> sharedQueue;
    private int threadNo;
    public Consumer (BlockingQueue<Integer> sharedQueue,int threadNo) {
        this.sharedQueue = sharedQueue;
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        while(true){
            try {
                int num = sharedQueue.take();
                /*if(num==-1)
                	break;*/
                System.out.println("Consumed: "+ num + ":by thread:"+threadNo);
            } catch (Exception err) {
               err.printStackTrace();
            }
        }
    }   
}
