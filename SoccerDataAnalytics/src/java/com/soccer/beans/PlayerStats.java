package com.soccer.beans;


public class PlayerStats {
	int player_fifa_api_id,player_api_id,overall_rating,potential;	
	String preferred_foot,attacking_work_rate,defensive_work_rate;
	int year;

	public PlayerStats(int player_fifa_api_id,int player_api_id,int date,int overall_rating,int potential,String preferred_foot,String attacking_work_rate,String defensive_work_rate){
		this.player_fifa_api_id=player_fifa_api_id;
		this.player_api_id=player_api_id;
		this.year=date;
		this.overall_rating=overall_rating;
		this.potential=potential;
		this.preferred_foot=preferred_foot;
		this.attacking_work_rate=attacking_work_rate;
		this.defensive_work_rate=defensive_work_rate;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPlayer_fifa_api_id() {
		return player_fifa_api_id;
	}
	public void setPlayer_fifa_api_id(int player_fifa_api_id) {
		this.player_fifa_api_id = player_fifa_api_id;
	}
	public int getPlayer_api_id() {
		return player_api_id;
	}
	public void setPlayer_api_id(int player_api_id) {
		this.player_api_id = player_api_id;
	}
	public int getOverall_rating() {
		return overall_rating;
	}
	public void setOverall_rating(int overall_rating) {
		this.overall_rating = overall_rating;
	}
	public int getPotential() {
		return potential;
	}
	public void setPotential(int potential) {
		this.potential = potential;
	}
	public String getPreferred_foot() {
		return preferred_foot;
	}
	public void setPreferred_foot(String preferred_foot) {
		this.preferred_foot = preferred_foot;
	}
	public String getAttacking_work_rate() {
		return attacking_work_rate;
	}
	public void setAttacking_work_rate(String attacking_work_rate) {
		this.attacking_work_rate = attacking_work_rate;
	}
	public String getDefensive_work_rate() {
		return defensive_work_rate;
	}
	public void setDefensive_work_rate(String defensive_work_rate) {
		this.defensive_work_rate = defensive_work_rate;
	}
	
	@Override
	public String toString(){
		return "[player_fifa_api_id:"+player_fifa_api_id+",player_api_id:"+player_api_id+",overall_rating:"+overall_rating+",potential:"+potential+",year:"+year+",preferred_foot:"+preferred_foot+",attacking_work_rate:"+attacking_work_rate+",defensive_work_rate:"+defensive_work_rate+"]";
	}
}
