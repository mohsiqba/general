package com.exercise.main;

public class Group {
	String childGrp;
	String parentGrp;
	public Group(String childGrp,String parentGrp) {
		this.childGrp=childGrp;
		this.parentGrp=parentGrp;
	}
	public String getChildGrp() {
		return childGrp;
	}
	public void setChildGrp(String childGrp) {
		this.childGrp = childGrp;
	}
	public String getParentGrp() {
		return parentGrp;
	}
	public void setParentGrp(String parentGrp) {
		this.parentGrp = parentGrp;
	}
	
	@Override
	public String toString(){
		return "\n[child:"+childGrp+" | parent:"+parentGrp+"]";
	}
}
