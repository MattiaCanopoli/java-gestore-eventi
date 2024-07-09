package org.events.java;

import java.time.LocalDate;
import java.time.LocalTime;
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
	 * If the date does not exist (e. 30th February) return false.<br>
	 * Accept a String as argument.the inputDate String must follow the pattern
	 * <strong>"yyyy-MM-dd"</strong><br>
	 * dashes within date elements in string are mandatory<br>
	 * inputDate String is parsed with LocalDate type and then checked<br>
	 * if it's before or equal to current day, return false
	 * 
	 * @param inputDate String with date to check. must follow the pattern
	 *                  "yyyy-MM-dd"
	 * @return boolean true for future dates, false for non-existent,past or current
	 *         date
	 */
	public static boolean checkDate(String inputDate) {
		try {
			LocalDate date = LocalDate.parse(inputDate);
			if (date.isBefore(LocalDate.now().plusDays(1))) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Checks if a date is in the future.<br>
	 * If the date does not exist (e. 30th February) return false.<br>
	 * If it's before or equal to current day, return false<br>
	 * Accepts three int as argument (year, month and day)
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return boolean. true for future dates, false for non-existent,past or
	 *         current date
	 */
	public static boolean checkDate(int year, int month, int day) {
		try {
			LocalDate date = LocalDate.of(year, month, day);
			if (date.isBefore(LocalDate.now().plusDays(1))) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * ask question to user and checks if answer is an integer.<br>
	 * if user provides an integer, return the integer given.<br>
	 * else, prints invalidImput message and keeps on asking until a valid input is
	 * provided.<br>
	 * 
	 * @param scanner             a scanner instance for System.in
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

	/**
	 * Ask question to user and checks if answer is an integer within the given
	 * limits<br>
	 * If user provides a valid integer, return the integer given.<br>
	 * An integer equal to the limits is considered a valid input<br>
	 * Else, prints invalidImput message and keeps on asking until a valid input is
	 * provided.<br>
	 * 
	 * @param scanner             a scanner instance for System.in
	 * @param min                 lower limit
	 * @param max                 upper limit
	 * @param question            a string representing the question to ask
	 * @param invalidImputMessage error message for not int input
	 * @param outOfRangeInput     error message for out of range input
	 * @return int the requested integer
	 */
	public static int checkIntInput(Scanner scanner, int min, int max, String question, String invalidImputMessage,
			String outOfRangeInput) {
		boolean check = false;
		int number = 0;

		do {
			System.out.println(question);

			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				scanner.nextLine();

			} else {
				scanner.nextLine();
				System.out.println(invalidImputMessage);
			}

			if (number <= max && number >= min) {
				check = true;
			} else {
				System.out.println(outOfRangeInput);
			}

		} while (!check);

		return number;
	}

	/**
	 * Ask question to user and checks if answer is an integer greater than a lower
	 * limit<br>
	 * If user provides a valid integer, return the integer given.<br>
	 * An integer equal to the lower limit is considered a valid input<br>
	 * Else, prints invalidImput message and keeps on asking until a valid input is
	 * provided.<br>
	 * 
	 * @param scanner             a scanner instance for System.in
	 * @param min                 lower limit
	 * @param question            a string representing the question to ask
	 * @param invalidImputMessage a string representing the message to print in case
	 *                            of invalid input
	 * @return requested integer
	 */
	public static int checkIntInputGreater(Scanner scanner, int min, String question, String invalidImputMessage) {
		boolean check = false;
		int number = 0;

		do {
			System.out.println(question);

			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				scanner.nextLine();
			} else {
				scanner.nextLine();
				System.out.println(invalidImputMessage);
			}

			if (number >= min) {
				check = true;
			} else {
				System.out.println(invalidImputMessage);
			}

		} while (!check);

		return number;
	}

	/**
	 * Ask question to user and checks if answer is an integer lesser than an upper
	 * limit<br>
	 * If user provides a valid integer, return the integer given.<br>
	 * An integer equal to the upper limit is considered a valid input<br>
	 * Else, prints invalidImput message and keeps on asking until a valid input is
	 * provided.<br>
	 * 
	 * @param scanner             a scanner instance for System.in
	 * @param max                 upper limit
	 * @param question            a string representing the question to ask
	 * @param invalidImputMessage a string representing the message to print in case
	 *                            of invalid input
	 * @return requested integer
	 */
	public static int checkIntInputLesser(Scanner scanner, int max, String question, String invalidImputMessage) {
		boolean check = false;
		int number = 0;

		do {
			System.out.println(question);

			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				scanner.nextLine();
			} else {
				scanner.nextLine();
				System.out.println(invalidImputMessage);
			}

			if (number >= max) {
				check = true;
			} else {
				System.out.println(invalidImputMessage);
			}

		} while (!check);

		return number;
	}

	/**
	 * Prints question and verify that the answer, got through scanner, matches
	 * positiveChecker or negativeChecker.<br>
	 * Return true for positiveChecker or false for negativeChecker match.<br>
	 * if neither conditions is verified, prints error message and keeps asking for
	 * a valid input<br>
	 * The comparison is case insensitive<br>
	 * 
	 * @param scanner         a scanner instance, used to get user input
	 * @param question        a question to ask
	 * @param positiveChecker comparison string
	 * @param negativeChecker comparison string
	 * @return true for positive match, false for negative match
	 */
	public static boolean checkInputString(Scanner scanner, String question, String positiveChecker,
			String negativeChecker) {

		String yesOrNo;
		boolean inputError = false;
		boolean result = false;

		do {
			System.out.println(question);
			yesOrNo = scanner.nextLine().toLowerCase();

			if (yesOrNo.equals(positiveChecker.toLowerCase())) {
				result = true;
				inputError = false;

			} else if (yesOrNo.equals(negativeChecker.toLowerCase())) {
				result = false;
				inputError = false;

			} else {
				System.out.println("il valore inserito non è valido." + "\n" + "Inserire \"" + positiveChecker
						+ "\" per SI oppure \"" + negativeChecker + "\" per NO" + "\n");
				inputError = true;
			}
		} while (inputError);
//		
		return result;
	}

	/**
	 * validate time entry
	 * 
	 * @param hour    if not within range 00-23, return false
	 * @param minutes in not in range 00-59, return false
	 * @return true if time provided is valid, false for invalid entry
	 */
	public static boolean checkTime(int hour, int minutes) {
		try {
			LocalTime.of(hour, minutes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * validate time entry in String type
	 * 
	 * @param time a string representing the time to verify. must follow the pattern
	 *             "hh:mm" or "hh:mm:ss"
	 * @return true if time provided is valid, false for invalid entry
	 */
	public static boolean checkTime(String time) {
		try {
			LocalTime.parse(time);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
