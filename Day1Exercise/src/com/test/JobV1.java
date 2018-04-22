package com.test;

public class JobV1 extends Job {

	private final Class<? extends BatchJobV1> cls;
	
	public JobV1(String name,int id,Class<? extends BatchJobV1> cls) {
		super(name,id);
		this.cls=cls;
	}
	
	public String name() {
		return name;
	}

	public Class<? extends BatchJobV1> jobClass() {
		return cls;
	}

	public boolean isEnabled(int processBit) {
		return (processBit & id) > 0;
	}
}
