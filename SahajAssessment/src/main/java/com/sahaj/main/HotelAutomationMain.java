package com.sahaj.main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.sahaj.config.HotelConfig;
import com.sahaj.config.PrimaryHotelState;
import com.sahaj.controllers.MotionDetector;
import com.sahaj.model.Hotel;
import com.sahaj.utils.HotelUtils;

/**
 * Application Start Class
 * <ul>
 * <li>Parse console input and create  {@link PrimaryHotelState} instance.
 * <li>{@link HotelConfig} builder creates {@link Hotel} instance
 * <li>Thread implementation {@link MotionDetector} senses periodic motion.
 * </ul>
 *
 */
public class HotelAutomationMain {

	public static void main(String[] args) {

		PrimaryHotelState hotelState = HotelUtils.parseHotelInputs();

		HotelConfig hotelConfig = new HotelConfig();
		Hotel hotel = hotelConfig.addFloors(hotelState.getFloorCount())
				.addMainCorridors(hotelState.getMainCorridorCount())
				.addSubCorridors(hotelState.getSubCorridorCount()).build();

		System.out.println(hotel);

		MotionDetector motionDetector=new MotionDetector(hotel);
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		scheduledExecutorService.scheduleAtFixedRate(motionDetector, 5,5, TimeUnit.SECONDS);
		Runtime.getRuntime().addShutdownHook(
		new Thread() {
			@Override
			public void run() {
				scheduledExecutorService.shutdownNow();
			}
		});
	}

}
