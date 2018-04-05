/**
 * 
 */
package com.sahaj.model;

import java.util.List;

/**
 * Defines number of floors.
 * Has {@link MainCorridor}, {@link SubCorridor}
 *
 */
public class Floor {

	private int floorNumber;

	/**
	 * @return the floorNumber
	 */
	public int getFloorNumber() {
		return floorNumber;
	}

	/**
	 * Has exactly one Main corridor.
	 */
	private List<MainCorridor> mainCorridors;

	/**
	 * May have one or more Sub Corridors.
	 */
	private List<SubCorridor> subCorridors;

	/**
	 * 
	 */
	public Floor(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	/**
	 * @return the mainCorridors
	 */
	public List<MainCorridor> getMainCorridors() {
		return mainCorridors;
	}

	/**
	 * @param mainCorridors
	 *            the mainCorridors to set
	 */
	public void setMainCorridors(List<MainCorridor> mainCorridors) {
		this.mainCorridors = mainCorridors;
	}

	/**
	 * @return the subCorridors
	 */
	public List<SubCorridor> getSubCorridors() {
		return subCorridors;
	}

	/**
	 * @param subCorridors
	 *            the subCorridors to set
	 */
	public void setSubCorridors(List<SubCorridor> subCorridors) {
		this.subCorridors = subCorridors;
	}

	@Override
	public String toString() {
		return "Floor " + (floorNumber + 1);
	}
}
