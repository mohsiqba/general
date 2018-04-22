package com.soccer.main;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.soccer.beans.PlayerInfo;
import com.soccer.beans.PlayerStats;
import com.soccer.csv.ReadCSV;
import com.soccer.csv.WriteCSV;
import com.soccer.utils.PlayerStatsUtil;

public class PlayerStatsMain {

	public static void main(String[] args) throws ParseException, IOException {
		//part1 - highest rating every year
		List<PlayerStats> pList=ReadCSV.getPlayerStatsList();
		Map<Integer,PlayerInfo> playerInfoMap=ReadCSV.getPlayerInfoMap();
		Map<Integer,List<PlayerStats>> map=PlayerStatsUtil.getFinalMapByYear(pList, PlayerStatsUtil.getMapOfHighestRatingPerYear(pList));
		WriteCSV.write1("Q_1_part_1.csv", map,playerInfoMap);
		
		//part2 -each player highest rating
		List<PlayerStats> list=PlayerStatsUtil.getFinalListByPlayer(pList, PlayerStatsUtil.getMapOfHighestRatingPerPlayer(pList));
		WriteCSV.write3("Q_1_part_2.csv", list,playerInfoMap);
		
		//Q2-attacking_work_rate,defensive_work_rate is high
		List<PlayerStats> wList=PlayerStatsUtil.getFinalListByPlayerForWorkRate(pList);
		WriteCSV.write2("Q_2_part.csv", wList, playerInfoMap);
		
		System.out.println("Application rans successfully... Please look into output directory");
	}
}
