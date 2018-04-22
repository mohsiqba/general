package com.test;

public abstract class Job {

	protected final String name;
	protected final int id;
	public Job(String name,int id) {
		this.name=name;
		this.id=id;
	}
}
