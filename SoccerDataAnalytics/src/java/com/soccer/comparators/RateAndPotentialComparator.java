package com.soccer.comparators;

import java.util.Comparator;

import com.soccer.beans.PlayerStats;

public class RateAndPotentialComparator implements Comparator<PlayerStats>{

	@Override
	public int compare(PlayerStats o1, PlayerStats o2) {
		if(o1.getOverall_rating()==o2.getOverall_rating()){
			if(o1.getPotential()>o2.getPotential())
				return -1;
			else if(o1.getPotential()<o2.getPotential())
				return 1;
			else
				return 0;
		}else if(o1.getOverall_rating()>o2.getOverall_rating()){
			return -1;
		}else {
			return 1;
		}
	}

}
