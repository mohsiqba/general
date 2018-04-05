/**
 * 
 */
package com.sahaj.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sahaj.utils.HotelUtils;

/**
 *
 */
public class HotelUtilsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.sahaj.utils.HotelUtils#getValueIfExists(int, java.lang.String)}
	 * .
	 */
	@Test
	public void testGetMatchAtGroupIfExists() {
		assertNull("Invalid input has a matching group!",
				HotelUtils.getValueIfExists(1, "sdsdsa"));
		assertTrue(
				"Valid input doesn't have a matching group!",
				HotelUtils.getValueIfExists(1,
						"Blah blah Floor 34, Sub corridor 4 blah blah").equals(
						"34"));
		assertTrue(
				"Valid input doesn't have a matching group!",
				HotelUtils.getValueIfExists(2,
						"Blah blah Floor 34, Sub corridor 4 blah blah").equals(
						"4"));
	}

}
