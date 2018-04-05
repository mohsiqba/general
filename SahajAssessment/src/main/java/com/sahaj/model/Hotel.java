/**
 * 
 */
package com.sahaj.model;

import java.util.List;

/**
 * 
 * Hotel is an entity in this application. Represents a real-life Hotel which
 * will have components associated with it and probably a few actions as well.
 * 
 *
 */
public class Hotel {

	private List<Floor> floors;

	private String name;

	public Hotel(String name) {
		this.name = name;
	}

	/**
	 * @return the floors
	 */
	public List<Floor> getFloors() {
		return floors;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param floors
	 *            the floors to set
	 */
	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Traverses through the Tree-like <code>Hotel</code> object and prints out
	 * the state of each individual node.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Floor floor:getFloors()) {
			sb.append(floor.toString()).append(System.lineSeparator());
			for(MainCorridor mainCorridor:floor.getMainCorridors()) {
				sb.append(mainCorridor.toString()).append(System.lineSeparator());
				for(LightBulb lightBulb:mainCorridor.getLightBulbs()) {
					sb.append(lightBulb.toString()).append(System.lineSeparator());
					for(AirConditioner airConditioner:mainCorridor.getAirConditioners()) {
						sb.append(airConditioner.toString()).append(System.lineSeparator());
					}
				}
			}
			for(SubCorridor subCorridor:floor.getSubCorridors()) {
				sb.append(subCorridor.toString()).append(System.lineSeparator());
				for(LightBulb lightBulb:subCorridor.getLightBulbs()) {
					sb.append(lightBulb.toString()).append(System.lineSeparator());
					for(AirConditioner airConditioner:subCorridor.getAirConditioners()) {
						sb.append(airConditioner.toString()).append(System.lineSeparator());
					}
				}
			}


		}
		return sb.toString();
	}

}
