package com.passport.verfication.impl;

import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

import com.passport.entities.Agents;
import com.passport.entities.Applicant;
import com.passport.verfication.Verification;

public class PoliceVerfication extends Verification implements Runnable{

	public PoliceVerfication(Integer stage,Agents agents,PriorityBlockingQueue<Applicant> policeQ,PriorityBlockingQueue<Applicant> biometricsQ) {
		this.biometricsQ=biometricsQ;
		this.policeQ=policeQ;
		this.stage=stage;
		this.agents=agents;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				//synchronized (this) {
					if(agents.isAvailable()) {
						agents.decrementAgent();
						Applicant applicant= policeQ.take();
						if(applicant.getStage()==-1) {
							biometricsQ.put(applicant);
							break;
						}
						System.out.println(Thread.currentThread().getName() +" verified by police for applicant: "+ applicant );
						Thread.sleep((int)(3 + (Math.random() * (9 - 3))*1000));
						applicant.setStage(3);
						applicant.setTokenDate(new Date());
						biometricsQ.put(applicant);
						
					}else {
						System.out.println(Thread.currentThread().getName() +" waiting to get Agents For Police Verification");
					}
				//}
			} catch (Exception err) {
				err.printStackTrace();
			}finally {
				agents.incrementAgent();
			}
		}
	}
}
