package com.passport.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

import com.passport.entities.Agents;
import com.passport.entities.Applicant;
import com.passport.verfication.impl.BiometricsVerification;
import com.passport.verfication.impl.DocumentVerification;
import com.passport.verfication.impl.PoliceVerfication;

public class PassportSimulation {

	public static void main(String[] args) {

		System.out.println("Start Time :"+System.currentTimeMillis());
		PriorityBlockingQueue<Applicant> documentQ=new PriorityBlockingQueue<>(1,Applicant.randomComparator);
		PriorityBlockingQueue<Applicant> policeQ=new PriorityBlockingQueue<>(1, Applicant.randomComparator);
		PriorityBlockingQueue<Applicant> biometricsQ=new PriorityBlockingQueue<>(1, Applicant.randomComparator);

		Agents documentAgents=new Agents(15);
		Agents policeAgents=new Agents(10);
		Agents biometricsAgents=new Agents(12);


		Thread producer1 = new Thread(new ApplicantProducer(documentQ));
		producer1.start();

		/*	Thread docAgent = new Thread(new DocumentVerification(1,documentAgents,documentQ,policeQ));
		docAgent.start();

		Thread policeAgent = new Thread(new PoliceVerfication(2,policeAgents,policeQ,biometricsQ));
		policeAgent.start();

		Thread bioAgent = new Thread(new BiometricsVerification(3,biometricsAgents,biometricsQ));
		bioAgent.start();*/

		ExecutorService documentAgentsExecutor = Executors.newFixedThreadPool(15);
		Runnable agent1 = new DocumentVerification(1,documentAgents,documentQ,policeQ);
		documentAgentsExecutor.execute(agent1);


		ExecutorService policeAgentsExecutor = Executors.newFixedThreadPool(10);
		Runnable agent2 = new PoliceVerfication(2,policeAgents,policeQ,biometricsQ);
		policeAgentsExecutor.execute(agent2);


		ExecutorService biometricsAgentsExecutor = Executors.newFixedThreadPool(12);
		Runnable agent3 = new BiometricsVerification(3,biometricsAgents,biometricsQ);
		biometricsAgentsExecutor.execute(agent3);


		documentAgentsExecutor.shutdown();
		while (!documentAgentsExecutor.isTerminated()) {
		}
		policeAgentsExecutor.shutdown();
		while (!policeAgentsExecutor.isTerminated()) {
		}
		biometricsAgentsExecutor.shutdown();
		while (!biometricsAgentsExecutor.isTerminated()) {
		}

		System.out.println("End Time :"+System.currentTimeMillis());
	}
}
