/**
 * 
 */
package com.sahaj.model;

import com.sahaj.utils.HotelUtils;

/**
 *
 */
public class SubCorridor extends Corridor {

	private CorridorType type;

	private boolean motionDetected;

	private int corridorNumber;

	public SubCorridor(int corridorNumber) {
		super(CorridorType.SUB);
		this.corridorNumber = corridorNumber;
	}

	/**
	 * @return the corridorNumber
	 */
	public int getCorridorNumber() {
		return corridorNumber;
	}

	@Override
	public CorridorType getType() {
		return type;
	}

	@Override
	public void setType(CorridorType type) {
		this.type = type;
	}

	/**
	 * @return the motionDetected
	 */
	public boolean isMotionDetected() {
		return motionDetected;
	}

	/**
	 * @param motionDetected
	 */
	public void setMotionDetected(boolean motionDetected) {
		this.motionDetected = motionDetected;
	}

	@Override
	public String toString() {
		return HotelUtils.DOUBLE_SPACES + "Sub corridor " + (corridorNumber + 1);
	}

}
