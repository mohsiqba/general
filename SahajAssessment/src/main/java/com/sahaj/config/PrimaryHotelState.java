/**
 * 
 */
package com.sahaj.config;

/**
 *
 */
public class PrimaryHotelState {

	private int floorCount;

	private int mainCorridorCount;

	private int subCorridorCount;

	public PrimaryHotelState(int floorCount, int mainCorridorCount,
			int subCorridorCount) {
		this.floorCount = floorCount;
		this.mainCorridorCount = mainCorridorCount;
		this.subCorridorCount = subCorridorCount;
	}

	/**
	 * @return the floorCount
	 */
	public int getFloorCount() {
		return floorCount;
	}

	/**
	 * @return the mainCorridorCount
	 */
	public int getMainCorridorCount() {
		return mainCorridorCount;
	}

	/**
	 * @return the subCorridorCount
	 */
	public int getSubCorridorCount() {
		return subCorridorCount;
	}

}
