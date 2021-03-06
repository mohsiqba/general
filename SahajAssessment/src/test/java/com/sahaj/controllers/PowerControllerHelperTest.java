/**
 * 
 */
package com.sahaj.controllers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sahaj.config.HotelConfig;
import com.sahaj.controllers.PowerControllerHelper;
import com.sahaj.model.Floor;
import com.sahaj.model.Hotel;
import com.sahaj.model.Motion;
import com.sahaj.model.SubCorridor;

/**
 *
 */
public class PowerControllerHelperTest {

	private PowerControllerHelper powerControllerHelper;

	private Hotel hotel;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		powerControllerHelper = new PowerControllerHelper();
		hotel = new HotelConfig().addFloors(2).addMainCorridors(2)
				.addSubCorridors(2).build();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.sahaj.controllers.PowerControllerHelper#switchACOnAtSubCorridor(com.sahaj.model.SubCorridor)}
	 * .
	 */
	@Test
	public void testSwitchACOnAtSubCorridor() {
		SubCorridor subCorridor = hotel.getFloors().get(0).getSubCorridors()
				.get(0);
		powerControllerHelper.switchACOnAtSubCorridor(subCorridor);
		assertTrue("AC is Off!", subCorridor.getAirConditioners().get(0)
				.isSwitchedOn());
	}

	/**
	 * Test method for
	 * {@link com.sahaj.controllers.PowerControllerHelper#switchACOffAtSubCorridor(com.sahaj.model.SubCorridor)}
	 * .
	 */
	@Test
	public void testSwitchACOffAtSubCorridor() {
		SubCorridor subCorridor = hotel.getFloors().get(0).getSubCorridors()
				.get(0);
		powerControllerHelper.switchACOffAtSubCorridor(subCorridor);
		assertFalse("AC is still On!", subCorridor.getAirConditioners().get(0)
				.isSwitchedOn());
	}

	/**
	 * Test method for
	 * {@link com.sahaj.controllers.PowerControllerHelper#isLightBulbSwitchedOnAtSubCorridor(com.sahaj.model.SubCorridor)}
	 * .
	 */
	@Test
	public void testIsLightBulbSwitchedOnAtSubCorridor() {
		SubCorridor subCorridor = hotel.getFloors().get(0).getSubCorridors()
				.get(0);
		assertFalse("LightBulb is On!",
				powerControllerHelper
						.isLightBulbSwitchedOnAtSubCorridor(subCorridor));
		subCorridor.getLightBulbs().get(0).setSwitchedOn(true);
		assertTrue("LightBulb is Off!",
				powerControllerHelper
						.isLightBulbSwitchedOnAtSubCorridor(subCorridor));
	}

	/**
	 * Test method for
	 * {@link com.sahaj.controllers.PowerControllerHelper#findMatchingFloor(com.sahaj.model.Hotel, com.sahaj.model.Motion)}
	 * .
	 */
	@Test
	public void testFindMatchingFloor() {
		Motion motion = new Motion(1, 1);
		Floor matchingFloor = powerControllerHelper.findMatchingFloor(hotel,
				motion);
		assertTrue("Not the same floor", 0 == matchingFloor.getFloorNumber());
		// Let's create a Motion in an invalid Floor.
		motion = new Motion(-1, 1);
		try {
			matchingFloor = powerControllerHelper.findMatchingFloor(hotel,
					motion);
			assertNull("Fake floor found!", matchingFloor);
		} catch (NoSuchElementException exception){
			// Expected. Ignored.
		}
			
		
	}

	/**
	 * Test method for
	 * {@link com.sahaj.controllers.PowerControllerHelper#findMatchingSubCorridor(com.sahaj.model.Motion, com.sahaj.model.Floor)}
	 * .
	 */
	@Test
	public void testFindMatchingSubCorridor() {
		Motion motion = new Motion(1, 2);
		Floor matchingFloor = powerControllerHelper.findMatchingFloor(hotel,
				motion);
		SubCorridor matchingSubCorridor = powerControllerHelper
				.findMatchingSubCorridor(motion, matchingFloor);
		assertTrue("Not the same floor",
				1 == matchingSubCorridor.getCorridorNumber());
	}

	/**
	 * Test method for
	 * {@link com.sahaj.controllers.PowerControllerHelper#findSomeOtherSubCorridor(com.sahaj.model.Motion, com.sahaj.model.Floor, com.sahaj.model.SubCorridor)}
	 * .
	 */
	@Test
	public void testFindSomeOtherSubCorridor() {
		Motion motion = new Motion(1, 2);
		Floor matchingFloor = powerControllerHelper.findMatchingFloor(hotel,
				motion);
		SubCorridor matchingSubCorridor = powerControllerHelper
				.findMatchingSubCorridor(motion, matchingFloor);
		SubCorridor someOtherSubCorridor = powerControllerHelper
				.findSomeOtherSubCorridor(motion, matchingFloor,
						matchingSubCorridor);
		assertFalse("It's the same SubCorridor",
				1 == someOtherSubCorridor.getCorridorNumber());
		// Let's remove the only other SubCorridor and see!
		SubCorridor removedSubCorridor = hotel.getFloors().get(0)
				.getSubCorridors().remove(0);
		someOtherSubCorridor = powerControllerHelper.findSomeOtherSubCorridor(
				motion, matchingFloor, matchingSubCorridor);
		assertTrue("It's the same SubCorridor",
				1 == someOtherSubCorridor.getCorridorNumber());
		// Let's add it back. Our test is successful. It has to be, otherwise it
		// can't be executing this line!
		hotel.getFloors().get(0).getSubCorridors().add(removedSubCorridor);
	}

}
