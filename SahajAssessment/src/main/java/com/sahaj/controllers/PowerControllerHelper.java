/**
 * 
 */
package com.sahaj.controllers;

import com.sahaj.model.Floor;
import com.sahaj.model.Hotel;
import com.sahaj.model.LightBulb;
import com.sahaj.model.Motion;
import com.sahaj.model.SubCorridor;

/**
 * 
 *
 */
public class PowerControllerHelper {

	/**
	 * Switches the AC On at a given SubCorridor.
	 * 
	 * @param subCorridor
	 */
	public void switchACOnAtSubCorridor(SubCorridor subCorridor) {
		subCorridor.getAirConditioners().get(0).setSwitchedOn(true);
	}

	/**
	 * Switches the AC Off at a given SubCorridor.
	 * 
	 * @param subCorridor
	 */
	public void switchACOffAtSubCorridor(SubCorridor subCorridor) {
		subCorridor.getAirConditioners().get(0).setSwitchedOn(false);
	}

	/**
	 * Checks if the {@link LightBulb} located at the given SubCorridor is
	 * Switched on.
	 * 
	 * @param subCorridor
	 * @return Switched on or not.
	 */
	public boolean isLightBulbSwitchedOnAtSubCorridor(SubCorridor subCorridor) {
		return subCorridor.getLightBulbs().get(0).isSwitchedOn();
	}

	/**
	 * For a given Hotel instance, it returns the corresponding Floor instance
	 * where the motion is detected.
	 * 
	 * @param hotel
	 * @param motion
	 * @return
	 */
	public Floor findMatchingFloor(Hotel hotel, Motion motion) {
		Floor matchedFloor=null;
		for(Floor floor:hotel.getFloors()) {
			if(floor.getFloorNumber()==(motion.getFloorNumber()-1))
				matchedFloor=floor;
		}
		return matchedFloor;
	}

	/**
	 * In a given Floor, it returns the SubCorridor where the Motion is
	 * detected.
	 * 
	 * @param motion
	 * @param matchingFloor
	 * @return
	 */
	public SubCorridor findMatchingSubCorridor(Motion motion,
			Floor matchingFloor) {
		SubCorridor matchedSubCorridor=null;
		for(SubCorridor subCorridor:matchingFloor.getSubCorridors()) {
			if(subCorridor.getCorridorNumber()==(motion.getSubCorridorNumber()-1))
				matchedSubCorridor=subCorridor;
		}
		return matchedSubCorridor;
	}

	/**
	 * This tries to do the exact opposite of
	 * {@link #findMatchingSubCorridor(Motion, Floor)} method to retrieve some
	 * other SubCorridor in the same Floor. If there are no other SubCorridors,
	 * returns the only SubCorridor in that floor.
	 * 
	 * @param motion
	 * @param matchingFloor
	 * @param matchingSubCorridor
	 * @return
	 */
	public SubCorridor findSomeOtherSubCorridor(Motion motion,
			Floor matchingFloor, SubCorridor matchingSubCorridor) {
		SubCorridor matchedSubCorridor=null;
		for(SubCorridor subCorridor:matchingFloor.getSubCorridors()) {
			if(subCorridor.getCorridorNumber()!=(motion.getSubCorridorNumber()-1))
				matchedSubCorridor=subCorridor;
		}
		if(matchedSubCorridor==null)
			matchedSubCorridor=matchingSubCorridor;
		return matchedSubCorridor;
	}

}
