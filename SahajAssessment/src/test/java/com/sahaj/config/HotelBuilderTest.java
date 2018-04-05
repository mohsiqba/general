/**
 * 
 */
package com.sahaj.config;

import com.sahaj.config.HotelConfig;
import com.sahaj.model.Hotel;

import junit.framework.TestCase;

/**
 *
 */
public class HotelBuilderTest extends TestCase {

	private HotelConfig hotelConfig;

	protected void setUp() throws Exception {
		super.setUp();
		hotelConfig = new HotelConfig();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * 
	 */
	public void testConstructor() {
		Hotel hotel = hotelConfig.build();
		assertNotNull(hotel.getName(), "Hotel name is not inited!");
	}

	/**
	 * Test method for
	 * {@link com.sahaj.config.HotelConfig#addFloors(int)}.
	 */
	public void testAddFloors() {
		Hotel hotel = hotelConfig.addFloors(2).build();
		assertTrue("Invalid floor count", hotel.getFloors().size() == 2);
	}

	/**
	 * Test method for
	 * {@link com.sahaj.config.HotelConfig#addMainCorridors(int)}.
	 */
	public void testAddMainCorridors() {
		Hotel hotel = hotelConfig.addFloors(2).addMainCorridors(2).build();
		assertTrue("Invalid floor count", hotel.getFloors().get(0)
				.getMainCorridors().size() == 2);
		assertTrue("Invalid floor count", hotel.getFloors().get(1)
				.getMainCorridors().size() == 2);
	}

	/**
	 * Test method for
	 * {@link com.sahaj.config.HotelConfig#addSubCorridors(int)}.
	 */
	public void testAddSubCorridors() {
		Hotel hotel = hotelConfig.addFloors(2).addSubCorridors(2).build();
		assertTrue("Invalid floor count", hotel.getFloors().get(0)
				.getSubCorridors().size() == 2);
		assertTrue("Invalid floor count", hotel.getFloors().get(1)
				.getSubCorridors().size() == 2);
	}

	/**
	 * Test method for {@link com.sahaj.config.HotelConfig#build()}
	 * .
	 */
	public void testBuild() {
		Hotel hotel = hotelConfig.build();
		assertNotNull("Hotel is null!", hotel);
	}

}
