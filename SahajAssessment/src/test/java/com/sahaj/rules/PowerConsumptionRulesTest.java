/**
 * 
 */
package com.sahaj.rules;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sahaj.config.HotelConfig;
import com.sahaj.model.Floor;
import com.sahaj.model.Hotel;
import com.sahaj.rules.PowerConsumptionRule;

/**
 *
 */
public class PowerConsumptionRulesTest {
	
	private PowerConsumptionRule powerConsumptionCriteria;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		powerConsumptionCriteria = new PowerConsumptionRule();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sahaj.rules.PowerConsumptionRule#isRulesApplicable(com.sahaj.model.Floor)}.
	 */
	@Test
	public void testCriteriaMetFor() {
		Hotel hotel = new HotelConfig().addFloors(1).addMainCorridors(1).addSubCorridors(1).build();
		Floor floor = hotel.getFloors().get(0);
		assertTrue("Criteria is not met!", powerConsumptionCriteria.isRulesApplicable(floor));
		floor.getSubCorridors().get(0).getAirConditioners().get(0).setSwitchedOn(true);
		floor.getSubCorridors().get(0).getLightBulbs().get(0).setSwitchedOn(true);
		powerConsumptionCriteria.isRulesApplicable(floor);
		assertFalse("Criteria is somehow met!", powerConsumptionCriteria.isRulesApplicable(floor));
	}

}
