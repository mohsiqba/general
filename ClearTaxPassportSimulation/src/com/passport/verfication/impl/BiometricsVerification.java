package com.passport.verfication.impl;

import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

import com.passport.entities.Agents;
import com.passport.entities.Applicant;
import com.passport.verfication.Verification;

public class BiometricsVerification extends Verification implements Runnable {

	public BiometricsVerification(Integer stage,Agents agents,PriorityBlockingQueue<Applicant> biometricsQ) {
		this.biometricsQ=biometricsQ;
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
						Applicant applicant= biometricsQ.take();
						if(applicant.getStage()==-1)
							break;
						Thread.sleep((int)(5 + (Math.random() * (8 - 5))*1000));
						applicant.setStage(4);
						applicant.setTokenDate(new Date());
						System.out.println(Thread.currentThread().getName() +" verified biometrics for applicant: "+ applicant );

					}else {
						System.out.println(Thread.currentThread().getName() +" waiting to get Agents For Document Verification");
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
