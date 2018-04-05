/**
 * 
 */
package com.sahaj.controllers;

import com.sahaj.config.ChangedHotelState;
import com.sahaj.model.Hotel;
import com.sahaj.utils.HotelUtils;

/**
 *
 */
public class MotionDetector implements Runnable{
	
	private Hotel hotel;
	
	public MotionDetector(Hotel hotel) {
		this.hotel=hotel;
	}

	@Override
	public void run() {
		try {
			ChangedHotelState state = HotelUtils.parseHotelSensorInputs();
			if (state != null) {
				PowerController powerController=new PowerController(hotel);
				MotionController motionController = new MotionController(state.getFloorNumber(), state.getSubCorridorNumber(),powerController);
				motionController.raiseMotionDetectedEvent(state.isLightBulbToTurnOn());
				System.out.println(hotel);	
			}
		} catch (IllegalArgumentException exception) {
			System.err.println(exception.getMessage());
		}
	
	}

}
