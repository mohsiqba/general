/**
 * 
 */
package com.sahaj.controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sahaj.config.HotelConfig;
import com.sahaj.controllers.PowerController;
import com.sahaj.model.Hotel;
import com.sahaj.model.Motion;

/**
 *
 */
public class PowerControllerTest {

	private PowerController powerController;

	private Hotel hotel;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		hotel = new HotelConfig().addFloors(2)
				.addMainCorridors(2).addSubCorridors(2).build();
		powerController = new PowerController(hotel);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.sahaj.controllers.PowerController#PowerController(com.sahaj.model.Hotel)}
	 * .
	 */
	@Test
	public void testPowerController() {
		assertEquals(hotel, powerController.getHotel());
	}

	/**
	 * Test method for
	 * {@link com.sahaj.controllers.PowerController#update(java.util.Observable, java.lang.Object)}
	 * .
	 */
	@Test
	public void testUpdate() {
		powerController.update(new Motion(1, 2), true);
		assertTrue("Not switched on!", hotel.getFloors().get(0)
				.getSubCorridors().get(1).getLightBulbs().get(0).isSwitchedOn());
		powerController.update(new Motion(1, 2), true);
		assertTrue("Not switched on!", hotel.getFloors().get(0)
				.getSubCorridors().get(1).getLightBulbs().get(0).isSwitchedOn());
		powerController.update(new Motion(1, 2), false);
		assertFalse("Still switched on!", hotel.getFloors().get(0)
				.getSubCorridors().get(1).getLightBulbs().get(0).isSwitchedOn());
		powerController.update(new Motion(1, 2), false);
		assertFalse("Still switched on!", hotel.getFloors().get(0)
				.getSubCorridors().get(1).getLightBulbs().get(0).isSwitchedOn());

	}

}
