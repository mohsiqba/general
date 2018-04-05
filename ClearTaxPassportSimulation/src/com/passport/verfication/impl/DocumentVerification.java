package com.passport.verfication.impl;

import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

import com.passport.entities.Agents;
import com.passport.entities.Applicant;
import com.passport.verfication.Verification;

public class DocumentVerification extends Verification implements Runnable{

	public DocumentVerification(Integer stage,Agents agents,PriorityBlockingQueue<Applicant> documentQ,PriorityBlockingQueue<Applicant> policeQ) {
		this.documentQ=documentQ;
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
						Applicant applicant= documentQ.take();
						if(applicant.getStage()==-1) {
							policeQ.put(applicant);
							break;
						}
						System.out.println(Thread.currentThread().getName() +" verified Document for application: "+ applicant );
						Thread.sleep((int)(5 + (Math.random() * (11 - 5))*1000));
						applicant.setStage(2);
						applicant.setTokenDate(new Date());
						policeQ.put(applicant);
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
