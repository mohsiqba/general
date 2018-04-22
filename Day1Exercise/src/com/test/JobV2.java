package com.test;

public class JobV2 extends Job {

	private final Class<? extends BatchJobV2> cls;
	public JobV2(String name, int id,Class<? extends BatchJobV2> cls) {
		super(name, id);
		this.cls=cls;
	}
	public String name() {
		return name;
	}

	public Class<? extends BatchJobV2> jobClass() {
		return cls;
	}

	public boolean isEnabled(int processBit) {
		return (processBit & id) > 0;
	}

}
