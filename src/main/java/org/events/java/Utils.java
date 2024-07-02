package org.events.java;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Utils {

	/**
	 * Generate a random int within given limits
	 * 
	 * @param max int, upper limit
	 * @param min int, lower limit
	 * @return int a random int within given limit
	 */
	public static int generateRandomInt(int max, int min) {

		Random rnd = new Random();
		int randomNumber = rnd.nextInt(max - min) + min;
		return randomNumber;
	}

	/**
	 * checks if a date is in the future.<br>
	 * if the input date is the current day or before, return false
	 * 
	 * @param inputDate
	 * @return boolean true for future dates, false for past or current date
	 */
	public static boolean checkDate(LocalDate inputDate) {
		if (inputDate.isBefore(LocalDate.now().plusDays(1))) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * checks if a date is in the future.<br>
	 * accept a String as argument.the inputDate String must follow the pattern
	 * <strong>"yyyy-MM-dd"</strong><br>
	 * dashes within date elements in string are mandatory<br>
	 * inputDate String is parsed with LocalDate type and then checked<br>
	 * if it's before or equal to current day, return false
	 * 
	 * @param inputDate String with date to check. must follow the pattern
	 *                  "yyyy-MM-dd"
	 * @return boolean true for future dates, false for past or current date
	 */
	public static boolean checkDate(String inputDate) {
		LocalDate date = LocalDate.parse(inputDate);

		if (date.isBefore(LocalDate.now().plusDays(1))) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if a date is in the future.<br>
	 * If it's before or equal to current day, return false<br>
	 * Accepts three int as argument (year, month and day)
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return boolean. true for future dates, false for past or current date
	 */
	public static boolean checkDate(int year, int month, int day) {
		LocalDate date = LocalDate.of(year, month, day);

		if (date.isBefore(LocalDate.now().plusDays(1))) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * ask question to user and checks if answer is an integer.<br>
	 * if user provides an integer, return the integer given.<br>
	 * else, prints invalidImput message and keeps on asking until a valid input is
	 * provided.<br>
	 * 
	 * @param scanner             a scanner instance
	 * @param question            a string representing the question to ask
	 * @param invalidImputMessage a string representing the message to print in case
	 *                            of invalid input
	 * @return integer asked
	 */
	public static int checkIntInput(Scanner scanner, String question, String invalidImputMessage) {
		boolean check = false;
		int number = 0;

		do {
			System.out.println(question);

			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				scanner.nextLine();
				check = true;
			} else {
				scanner.nextLine();
				System.out.println(invalidImputMessage);
			}

		} while (!check);

		return number;
	}

}
