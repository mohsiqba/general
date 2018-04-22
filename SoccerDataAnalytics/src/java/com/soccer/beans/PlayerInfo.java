package com.soccer.beans;

public class PlayerInfo {
	int player_api_id,player_fifa_api_id;
	String player_name	;
	
	public PlayerInfo(int player_api_id,String player_name,int player_fifa_api_id){
		this.player_api_id=player_api_id;
		this.player_fifa_api_id=player_fifa_api_id;
		this.player_name=player_name;
	}
	public int getPlayer_api_id() {
		return player_api_id;
	}
	public void setPlayer_api_id(int player_api_id) {
		this.player_api_id = player_api_id;
	}
	public int getPlayer_fifa_api_id() {
		return player_fifa_api_id;
	}
	public void setPlayer_fifa_api_id(int player_fifa_api_id) {
		this.player_fifa_api_id = player_fifa_api_id;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
}
