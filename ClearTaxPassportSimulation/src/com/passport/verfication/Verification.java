package com.passport.verfication;

import java.util.concurrent.PriorityBlockingQueue;

import com.passport.entities.Agents;
import com.passport.entities.Applicant;

public abstract class Verification {
	protected Integer stage;
	protected Agents agents;
	protected PriorityBlockingQueue<Applicant> documentQ;
	protected PriorityBlockingQueue<Applicant> policeQ;
	protected PriorityBlockingQueue<Applicant> biometricsQ;
}
