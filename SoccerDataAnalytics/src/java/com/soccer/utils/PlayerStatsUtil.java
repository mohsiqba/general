package com.soccer.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.soccer.beans.PlayerStats;
import com.soccer.comparators.RateAndPotentialComparator;

public class PlayerStatsUtil {

	public static Map<Integer,Integer> getMapOfHighestRatingPerYear(List<PlayerStats> list){
		Map<Integer,Integer> rateMap=new HashMap<Integer, Integer>();
		ListIterator<PlayerStats> it= list.listIterator();
		while(it.hasNext()){
			PlayerStats ps=it.next();
			if(rateMap.containsKey(ps.getYear())){
				if(rateMap.get(ps.getYear())<ps.getOverall_rating())
					rateMap.put(ps.getYear(), ps.getOverall_rating());
			}else{
				rateMap.put(ps.getYear(), ps.getOverall_rating());
			}
		}
		return rateMap;
	}
	
	public static Map<Integer,Integer> getMapOfHighestRatingPerPlayer(List<PlayerStats> list){
		Map<Integer,Integer> rateMap=new HashMap<Integer, Integer>();
		ListIterator<PlayerStats> it= list.listIterator();
		while(it.hasNext()){
			PlayerStats ps=it.next();
			if(rateMap.containsKey(ps.getPlayer_api_id())){
				if(rateMap.get(ps.getPlayer_api_id())<ps.getOverall_rating())
					rateMap.put(ps.getPlayer_api_id(), ps.getOverall_rating());
			}else{
				rateMap.put(ps.getPlayer_api_id(), ps.getOverall_rating());
			}
		}
		return rateMap;
	}
	
	public static List<PlayerStats> getFinalListByPlayer(List<PlayerStats>list,Map<Integer,Integer> rateMap){
		List<PlayerStats> finalList=new ArrayList<PlayerStats>();
		Collections.sort(list, new RateAndPotentialComparator());
		finalList=removeDups(list);
		return finalList;
	}
	
	public static List<PlayerStats> getFinalListByPlayerForWorkRate(List<PlayerStats>list){
		List<PlayerStats> finalList=new ArrayList<PlayerStats>();
		ListIterator<PlayerStats>li=list.listIterator();
		while(li.hasNext()){
			PlayerStats ps= li.next();
			if(ps.getAttacking_work_rate().equalsIgnoreCase("high") && ps.getDefensive_work_rate().equalsIgnoreCase("high"))
				finalList.add(ps);
		}
		finalList=removeDups(finalList);
		return finalList;
	}
	
	public static Map<Integer,List<PlayerStats>> getFinalMapByYear(List<PlayerStats>list,Map<Integer,Integer> rateMap){
		Map<Integer,List<PlayerStats>> map=new HashMap<Integer, List<PlayerStats>>();
		Iterator<Map.Entry<Integer,Integer>> it=rateMap.entrySet().iterator();
		while(it.hasNext()){
			Entry<Integer, Integer> en=it.next();
			List<PlayerStats> temp=removeDups(getsublistByYearAndRating(list, en.getKey(), en.getValue()));
			Collections.sort(temp, new RateAndPotentialComparator());
			map.put(en.getKey(), temp);
		}
		return map;
	}
	
	public static List<PlayerStats> getsublistByYearAndRating(List<PlayerStats>list,int year,int rating){
		List<PlayerStats> subList=new ArrayList<PlayerStats>();
		ListIterator<PlayerStats> it= list.listIterator();
		while(it.hasNext()){
			PlayerStats ps=it.next();
			if(ps.getYear()==year && ps.getOverall_rating()==rating)
				subList.add(ps);	
		}
		return subList;
	}
	
	public static List<PlayerStats> getsublistByRating(List<PlayerStats>list,int rating){
		List<PlayerStats> subList=new ArrayList<PlayerStats>();
		ListIterator<PlayerStats> it= list.listIterator();
		while(it.hasNext()){
			PlayerStats ps=it.next();
			if(ps.getOverall_rating()==rating)
				subList.add(ps);	
		}
		return subList;
	}
	
	public static List<PlayerStats> getsublistByYear(List<PlayerStats>list,int year){
		List<PlayerStats> subList=new ArrayList<PlayerStats>();
		ListIterator<PlayerStats> it= list.listIterator();
		while(it.hasNext()){
			PlayerStats ps=it.next();
			if(ps.getYear()==year)
				subList.add(ps);	
		}
		return subList;
	}
	
	public static List<PlayerStats>removeDups(List<PlayerStats> list){
		Set<PlayerStats> set = new TreeSet<PlayerStats>(new Comparator<PlayerStats>() {
			@Override
			public int compare(PlayerStats o1, PlayerStats o2) {
				if(o1.getPlayer_api_id()==o2.getPlayer_api_id()){
	        		return 0;
	        	}
	        	return 1;
			}
		});
		set.addAll(list);
	    return new ArrayList<PlayerStats>(set);
	}
}
