package com.passport.main;

import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

import com.passport.entities.Applicant;

public class ApplicantProducer implements Runnable {

	    private final PriorityBlockingQueue<Applicant> sharedQueue;

	    public ApplicantProducer(PriorityBlockingQueue<Applicant> sharedQueue) {
	        this.sharedQueue = sharedQueue;
	    }

	    @Override
	    public void run() {
	        for(int i=1; i<= 5; i++){
	            try {
	                int number = i+(int)Math.random()*200;
	                Applicant applicant=new Applicant(i, 1, number, new Date());
	                System.out.println("applicant"+applicant);
	                
	                sharedQueue.put(applicant);
	                Thread.sleep((int)(Math.random() * 4)*1000);
	            } catch (Exception err) {
	                err.printStackTrace();
	            }
	        }
	        sharedQueue.put(new Applicant(182, -1, 123456, new Date()));
	    }

	}