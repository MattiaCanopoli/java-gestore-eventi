package org.events.java;

import java.time.LocalDate;
import java.util.Random;

public class Utils {

	/**
	 * Generate a random int
	 * 
	 * @param max int, upper limit
	 * @param min int, lower limit
	 * @return int, a random int within given limit
	 */
	public static int generateRandomInt(int max, int min) {

		Random rnd = new Random();
		int randomNumber = rnd.nextInt(max - min) + min;
		return randomNumber;
	}

	public static boolean checkDate(String inputDate) {
		LocalDate date = LocalDate.parse(inputDate);
		if (date.isBefore(LocalDate.now().plusDays(1))) {
			return false;
		} else {
			return true;
		}
	}

}
