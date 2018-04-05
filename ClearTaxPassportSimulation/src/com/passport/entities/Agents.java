package com.passport.entities;

public class Agents {
	Integer totalAgents;
	Integer availableAgents;
	
	public Agents() {
	}
	
	public Agents(Integer totalAgents){
		this.totalAgents=totalAgents;
		this.availableAgents=totalAgents;
	}
	
	public Boolean isAvailable() {
		return availableAgents<=totalAgents;
	}

	public Integer getTotalAgents() {
		return totalAgents;
	}

	public void setTotalAgents(Integer totalAgents) {
		this.totalAgents = totalAgents;
	}

	public Integer getAvailableAgents() {
		return availableAgents;
	}

	public void setAvailableAgents(Integer availableAgents) {
		this.availableAgents = availableAgents;
	}
	
	public void incrementAgent() {
		if(availableAgents<totalAgents)
			availableAgents++;
	}
	public void decrementAgent() {
		if(availableAgents>0)
			availableAgents--;
	}
}

