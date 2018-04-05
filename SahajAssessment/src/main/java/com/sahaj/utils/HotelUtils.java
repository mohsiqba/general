/**
 * 
 */
package com.sahaj.utils;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sahaj.config.PrimaryHotelState;
import com.sahaj.config.ChangedHotelState;

/**
 *
 */
public class HotelUtils {


	private static final Pattern SENSOR_INPUT_COUNTS = Pattern
			.compile(".*\\sFloor\\s([\\d]+),.*\\sSub\\scorridor\\s([\\d]+).*");

	public static final String INPUT_FLOOR_COUNT = "Number of floors: ";
	public static final String INPUT_MAIN_CORRIDOR_COUNT = "Main Corridors per floor: ";
	public static final String INPUT_SUB_CORRIDOR_COUNT = "Sub Corridors per floor: ";
	public static final String INPUT_NO_MOVEMENT_PREFIX = "No movement";
	public static final String INPUT_EXIT = "exit";
	public static final String INPUT_INVALID_INTEGER = "Please enter an integer.";
	public static final String INPUT_MALFORMED_FORMAT = "Input mismatched. Format:[Movement in Floor <Integer>, Sub corridor <Integer>][No movement in Floor <Integer>, Sub corridor <Integer> for a minute].";
	public static final Scanner SCANNER = new Scanner(System.in);
	public static final Integer LIGHT_BULB_POWER_RATING = 5;
	public static final Integer AC_POWER_RATING = 10;
	public static final String DOUBLE_SPACES = "  ";
	
	/**
	 * get String value from {@code inputText} at position {@code groupNumber}
	 * @param position
	 * @param inputStr
	 * @return Return the match or null if no match is found.
	 */
	public static String getValueIfExists(int position,
			String inputStr) {
		Matcher matcher = SENSOR_INPUT_COUNTS.matcher(inputStr);
		if (matcher.matches() && matcher.groupCount() >= position) {
			return matcher.group(position);
		} else {
			return null;
		}
	}
	
	/**
	 * closes {@code SCANNER} instance
	 */
	public static void closeStream() {
		SCANNER.close();
	}

	/**
	 * throws Exception/Message for Invalid Type
	 */
	public static void throwException() {
		while (!SCANNER.hasNextInt()) {
			System.err.println(INPUT_INVALID_INTEGER);
			SCANNER.nextLine();
		}
	}
	
	/**
	 * creates an instance from console/sensor input
	 * @return An instance of {@link PrimaryHotelState}
	 */
	public static PrimaryHotelState parseHotelInputs() {
		System.out.println(INPUT_FLOOR_COUNT);
		throwException();
		int floorCount = Integer.parseInt(SCANNER.nextLine());
		System.out.println(INPUT_MAIN_CORRIDOR_COUNT);
		throwException();
		int mainCorridorCount = Integer.parseInt(SCANNER.nextLine());
		System.out.println(INPUT_SUB_CORRIDOR_COUNT);
		throwException();
		int subCorridorCount = Integer.parseInt(SCANNER.nextLine());
		PrimaryHotelState hotelState = new PrimaryHotelState(floorCount,
				mainCorridorCount, subCorridorCount);
		return hotelState;
	}
	
	/**
	 * creates an instance from sensor motion .
	 * @return {@link ChangedHotelState}
	 */
	public static ChangedHotelState parseHotelSensorInputs() {
		String sensorInputLine = SCANNER.nextLine();
		if (sensorInputLine.isEmpty()) {
			throw new IllegalArgumentException(INPUT_MALFORMED_FORMAT);
		} else if (sensorInputLine.equalsIgnoreCase(INPUT_EXIT)) {
			closeStream();
			System.out.println("Exitting Application !!!");
			System.exit(0);
		}
		String floorNumberString = getValueIfExists(1,
				sensorInputLine);
		String subCorridorNumberString = getValueIfExists(2,
				sensorInputLine);
		if (Objects.isNull(floorNumberString)
				|| Objects.isNull(subCorridorNumberString)) {
			// Nothing can be done. Sensor inputs are possibly malformed.
			throw new IllegalArgumentException(INPUT_MALFORMED_FORMAT);
		}
		boolean turnOnLightBulbSwitch;
		if (sensorInputLine.startsWith(INPUT_NO_MOVEMENT_PREFIX)) {
			// switch off bulb
			turnOnLightBulbSwitch = false;
		} else {
			// Motion Detected. switch on bulb
			turnOnLightBulbSwitch = true;

		}

		return new ChangedHotelState(Integer.parseInt(floorNumberString),
				Integer.parseInt(subCorridorNumberString),
				turnOnLightBulbSwitch);
	}
}
