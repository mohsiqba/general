/**
 * 
 */
package com.sahaj.config;

import java.util.ArrayList;

import com.sahaj.model.Floor;
import com.sahaj.model.Hotel;
import com.sahaj.model.MainCorridor;
import com.sahaj.model.SubCorridor;

/**
 * Custom Builder pattern to build a <code>Hotel</code> instance based on the
 * user inputs.
 * 
 *
 */
public class HotelConfig {

	private Hotel hotel;

	public HotelConfig() {
		createHotel();
	}

	/**
	 * This is the first method to be invoked to ensure the Hotel instance is
	 * setup before adding on other components to it.
	 * 
	 * @return
	 */
	private HotelConfig createHotel() {
		hotel = new Hotel("New Hotel!");
		hotel.setFloors(new ArrayList<Floor>());
		return this;
	}

	/**
	 * Adds as many floors to the count as requested.
	 * 
	 * @param floorCount
	 * @return
	 */
	public HotelConfig addFloors(int floorCount) {
		for (int counter = 0; counter < floorCount; counter++) {
			Floor floor = new Floor(counter);
			floor.setMainCorridors(new ArrayList<MainCorridor>());
			floor.setSubCorridors(new ArrayList<SubCorridor>());
			hotel.getFloors().add(floor);
		}
		return this;
	}

	/**
	 * Adds as many MainCorridors to each floor as requested.
	 * 
	 * @param mainCorridorCount
	 * @return
	 */
	public HotelConfig addMainCorridors(int mainCorridorCount) {
		int floorCount = hotel.getFloors().size();
		for (int floorCounter = 0; floorCounter < floorCount; floorCounter++) {
			for (int corridorCounter = 0; corridorCounter < mainCorridorCount; corridorCounter++) {
				MainCorridor mainCorridor = new MainCorridor(corridorCounter);
				hotel.getFloors().get(floorCounter).getMainCorridors()
						.add(mainCorridor);
			}
		}
		return this;
	}

	/**
	 * Adds as many SubCorridors to each floor as requested.
	 * 
	 * @param subCorridorCount
	 * @return
	 */
	public HotelConfig addSubCorridors(int subCorridorCount) {
		int floorCount = hotel.getFloors().size();
		for (int floorCounter = 0; floorCounter < floorCount; floorCounter++) {
			for (int corridorCounter = 0; corridorCounter < subCorridorCount; corridorCounter++) {
				SubCorridor subCorridor = new SubCorridor(corridorCounter);
				hotel.getFloors().get(floorCounter).getSubCorridors()
						.add(subCorridor);
			}
		}
		return this;
	}

	/**
	 * Returns the hotel instance at this given instant.
	 * 
	 * @return
	 */
	public Hotel build() {
		return hotel;
	}

}
