/**
 * 
 */
package com.sahaj.config;

/**
 *
 */
public class ChangedHotelState {

	private int floorNumber;

	private int subCorridorNumber;

	private boolean lightBulbToTurnOn;

	/**
	 * Default constructor.
	 */
	public ChangedHotelState(int floorNumber, int subCorridorNumber,
			boolean lightBulbToTurnOn) {
		this.floorNumber = floorNumber;
		this.subCorridorNumber = subCorridorNumber;
		this.lightBulbToTurnOn = lightBulbToTurnOn;
	}

	/**
	 * @return the floorNumber
	 */
	public int getFloorNumber() {
		return floorNumber;
	}

	/**
	 * @return the subCorridorNumber
	 */
	public int getSubCorridorNumber() {
		return subCorridorNumber;
	}

	/**
	 * @return the lightBulbToTurnOn
	 */
	public boolean isLightBulbToTurnOn() {
		return lightBulbToTurnOn;
	}

}
