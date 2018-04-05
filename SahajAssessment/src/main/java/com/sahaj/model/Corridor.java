/**
 * 
 */
package com.sahaj.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.sahaj.rules.PowerConsumptionRule;
import com.sahaj.utils.HotelUtils;

/**
 * abstract class defining types of Corridor.
 * Has {@link MainCorridor}, {@link SubCorridor}}
 *
 */
public abstract class Corridor {

	/**
	 * @return the lightBulbs
	 */
	public List<LightBulb> getLightBulbs() {
		return lightBulbs;
	}

	/**
	 * @return the airConditioners
	 */
	public List<AirConditioner> getAirConditioners() {
		return airConditioners;
	}

	private List<LightBulb> lightBulbs;

	private List<AirConditioner> airConditioners;

	/**
	 * Create a new Corridor with the default equipments.
	 */
	public Corridor(CorridorType type) {
		lightBulbs = new ArrayList<>();
		lightBulbs.add(new LightBulb(
				HotelUtils.LIGHT_BULB_POWER_RATING, lightBulbs
						.size(), type == CorridorType.MAIN));
		airConditioners = new ArrayList<>();
		airConditioners.add(new AirConditioner(
				HotelUtils.AC_POWER_RATING,
				airConditioners.size(), true));
		setType(type);
	}

	public void addLightBulbs(LightBulb... lightBulbs) {
		this.lightBulbs.addAll(Arrays.asList(lightBulbs));
	}

	public void addAirConditioners(AirConditioner... airConditioners) {
		this.airConditioners.addAll(Arrays.asList(airConditioners));
	}

	/**
	 * @return the type
	 */
	public abstract CorridorType getType();

	/**
	 * @param type
	 *            the type to set
	 */
	public abstract void setType(CorridorType type);

	static enum CorridorType {
		MAIN, SUB
	}

}
