/**
 * 
 */
package com.sahaj.rules;

import java.util.List;

import com.sahaj.model.AirConditioner;
import com.sahaj.model.Floor;
import com.sahaj.model.LightBulb;
import com.sahaj.model.MainCorridor;
import com.sahaj.model.SubCorridor;

/**
 *  {@link PowerConsumptionRule defines power consumption rule}
 *
 */
public class PowerConsumptionRule implements Rules {

	@Override
	public boolean isRulesApplicable(Floor floor) {
		return powerConsumptionForFloor(floor) <= getMaxPowerAllowedForFloor(floor);
	}

	/**
	 * get Maximum Power for Floor 
	 * @param floor
	 * @return total power consumption for floor
	 */
	private int getMaxPowerAllowedForFloor(Floor floor) {
		List<MainCorridor> mainCorridors = floor.getMainCorridors();
		List<SubCorridor> subCorridors = floor.getSubCorridors();
		return (mainCorridors.size() * 15) + subCorridors.size() * 10;
	}

	/**
	 * get actual power being consumed for Floor
	 * @param floor
	 * @return actual power being consumed.
	 */
	private int powerConsumptionForFloor(Floor floor) {
		List<MainCorridor> mainCorridors = floor.getMainCorridors();
		List<SubCorridor> subCorridors = floor.getSubCorridors();

		Integer sumMainCorridorsLightBulbs=0;
		for(MainCorridor mainCorridor:mainCorridors) {
			for(LightBulb lightBulb:mainCorridor.getLightBulbs()) {
				sumMainCorridorsLightBulbs+=lightBulb.isSwitchedOn()?lightBulb.getPowerRating():0;
			}
		}
		
		Integer sumMainCorridorsAirConditioners=0;
		for(MainCorridor mainCorridor:mainCorridors) {
			for(AirConditioner airConditioner:mainCorridor.getAirConditioners()) {
				sumMainCorridorsAirConditioners+=airConditioner.isSwitchedOn()?airConditioner.getPowerRating():0;
			}
		}
		
		Integer sumSubCorridorsLightBulbs=0;
		for(SubCorridor subCorridor:subCorridors) {
			for(LightBulb lightBulb:subCorridor.getLightBulbs()) {
				sumSubCorridorsLightBulbs+=lightBulb.isSwitchedOn()?lightBulb.getPowerRating():0;
			}
		}
		
		Integer sumSubCorridorsAirConditioners=0;
		for(SubCorridor subCorridor:subCorridors) {
			for(AirConditioner airConditioner:subCorridor.getAirConditioners()) {
				sumSubCorridorsAirConditioners+=airConditioner.isSwitchedOn()?airConditioner.getPowerRating():0;
			}
		}
		
		return sumMainCorridorsLightBulbs+ sumMainCorridorsAirConditioners+ sumSubCorridorsLightBulbs+sumSubCorridorsAirConditioners ;
	}

}
