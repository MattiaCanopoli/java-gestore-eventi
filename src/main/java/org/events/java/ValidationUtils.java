package org.events.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * Utility class to validate user inputs
 */
public class ValidationUtils {

	/**
	 * Checks if user input is int.<br>
	 * Prints question and waits for user input<br>
	 * If user input is valid, returns the given number. else, prints
	 * errorMessage.<br>
	 * Keeps asking until a valid input is provided.
	 * 
	 * @param scanner      Scanner. an open scanner instance, to get user input
	 * @param question     String. a question to ask. the answer must be an int.
	 *                     (e.g. "What's your age?")
	 * @param errorMessage String. an error message to print if user input is not an
	 *                     int (e.g. "Invalid input. Retry")
	 * @return int. the given number
	 */
	public static int isInt(Scanner scanner, String question, String errorMessage) {
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
				System.out.println(errorMessage);
			}

		} while (!check);

		return number;

	}

	/**
	 * Checks if user input is int equal or greater than lowerLimit.<br>
	 * Prints question and waits for user input<br>
	 * If user input is valid (is an int equal or greater than lowerLimit), returns
	 * the given number. else, prints errorMessage.<br>
	 * Keeps asking until a valid input is provided.
	 * 
	 * @param scanner      Scanner. an open scanner instance, to get user input
	 * @param lowerLimit   int. a number to be compared with user input.
	 * @param question     String. a question to ask. the answer must be an int.
	 *                     (e.g. "What's your age?")
	 * @param errorMessage String. an error message to print if user input is not an
	 *                     int (e.g. "Invalid input. Retry")
	 * @return int. the given number
	 */
	public static int isIntGreater(Scanner scanner, int lowerLimit, String question, String errorMessage) {
		boolean check = false;
		int number = 0;

		do {
			System.out.println(question);

			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				scanner.nextLine();
				if (number >= lowerLimit) {
					check = true;
				} else {
					System.out.println(errorMessage);
				}
			} else {
				scanner.nextLine();
				System.out.println(errorMessage);
			}

		} while (!check);

		return number;
	}

	/**
	 * Checks if user input is int within the given range (lowerLimit -
	 * upperLimit).<br>
	 * Prints question and waits for user input<br>
	 * If user input is valid (is and int within range), returns the given number.
	 * else, prints errorMessage.<br>
	 * Keeps asking until a valid input is provided.
	 * 
	 * @param scanner      Scanner. an open scanner instance, to get user input
	 * @param lowerLimit   int. user input must be equal or greater than lowerLimit
	 * @param upperLimit   int. user input must be equal or lower than upperLimit
	 * @param question     String. a question to ask. the answer must be an int.
	 *                     (e.g. "What's your age?")
	 * @param errorMessage String. an error message to print if user input is not an
	 *                     int (e.g. "Invalid input. Retry")
	 * @return int. the given number
	 * @return
	 */
	public static int isIntWithin(Scanner scanner, int lowerLimit, int upperLimit, String question,
			String errorMessage) {
		boolean check = false;
		int number = 0;

		do {
			System.out.println(question);

			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				scanner.nextLine();
				if (number >= lowerLimit && number <= upperLimit) {
					check = true;
				} else {
					System.out.println(errorMessage);
				}
			} else {
				scanner.nextLine();
				System.out.println(errorMessage);
			}

		} while (!check);

		return number;
	}

	/**
	 * Verify that a given date, defined by three int passed as parameters (year,
	 * month,day) exists and is valid.<br>
	 * A valid date is in the future (current date + 1)<br>
	 * if the provided date does not exist(e.g. 31st February) on it's equal or
	 * before current date, returns false. Else, returns true
	 * 
	 * @param year  int
	 * @param month int
	 * @param day   int
	 * @return boolean. true for valid dates, false for invalid (past or non
	 *         existent) dates
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

	public static boolean checkTime(String userInputTime) {
		try {
			@SuppressWarnings("unused")
			LocalTime time = LocalTime.parse(userInputTime);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Ask question and waits for user input.<br>
	 * Compares user input to positiveCheck and negativeCheck<br>
	 * Every element is converted to lower case before the check.<br>
	 * if no match is found, prints a default error message.<br>
	 * Keeps asking until a valid input is provided.
	 * 
	 * @param scanner       Scanner. an open scanner instance, to get user input
	 * @param question      String. a question to ask. the answer must be an int.
	 *                      (e.g. "What's your age?"
	 * @param positiveCheck String. a string to be compared to user input
	 * @param negativeCheck String. a string to be compared to user input
	 * @return boolean. true if input matches positiveCheck; false if it matches
	 *         negativeCheck
	 */
	public static boolean inputMatches(Scanner scanner, String question, String positiveCheck, String negativeCheck) {
		boolean check = false;
		boolean result = false;
		do {
			System.out.println(question);
			String input = scanner.nextLine().toLowerCase();

			if (input.equals(positiveCheck.toLowerCase())) {
				result = true;
				check = true;
			} else if (input.equals(negativeCheck.toLowerCase())) {
				result = false;
				check = true;
			} else {
				System.out.println("Il valore inserito non è valido. Inserire " + "\"" + positiveCheck
						+ "\" per SI oppure \"" + negativeCheck + "\" per NO");
			}

		} while (!check);

		return result;
	}

	public static int getChoice(Scanner scanner, String question, String errorMessage, String[] choices) {
		boolean check = false;
		int index = -1;
		do {

			System.out.println(question);
			for (String choice : choices) {
				System.out.println("- " + choice);
			}

			String choice = scanner.nextLine();

			for (int i = 0; i < choices.length; i++) {
				if (choice.toLowerCase().equals(choices[i].toLowerCase())) {
					check = true;
					index = i;
				}
			}
			if (index == -1) {
				System.out.println(errorMessage);
			}
		} while (!check);
		return index;
	}

	/**
	 * Checks if user input is float.<br>
	 * Prints question and waits for user input<br>
	 * If user input is valid, returns the given number. else, prints
	 * errorMessage.<br>
	 * Keeps asking until a valid input is provided.
	 * 
	 * @param scanner      Scanner. an open scanner instance, to get user input
	 * @param question     String. a question to ask. the answer must be a float.
	 *                     (e.g. "Insert object price")
	 * @param errorMessage String. an error message to print if user input is not an
	 *                     float. (e.g. "Invalid input. Retry")
	 * @return int. the given number
	 */
	public static float isFloat(Scanner scanner, String question, String errorMessage) {
		boolean check = false;
		float number = 0f;
		do {
			System.out.println(question);
			String strFloat = scanner.nextLine().replace(',', '.');
			try {
				number = Float.valueOf(strFloat);
				check = true;
			} catch (Exception e) {
				System.out.println(errorMessage);
			}
		} while (!check);

		return number;

	}

	/**
	 * Checks if user input is float equal or greater than lowerLimit.<br>
	 * Prints question and waits for user input<br>
	 * If user input is valid (is a float equal or greater than lowerLimit), returns
	 * the given number. else, prints errorMessage.<br>
	 * Keeps asking until a valid input is provided.
	 * 
	 * @param scanner      Scanner. an open scanner instance, to get user input
	 * @param lowerLimit   int. a number to be compared with user input.
	 * @param question     String. a question to ask. the answer must be a float.
	 *                     (e.g. "Insert object price")
	 * @param errorMessage String. an error message to print if user input is not an
	 *                     int (e.g. "Invalid input. Retry")
	 * @return int. the given number
	 */
	public static float isFloatGreater(Scanner scanner, int lowerLimit, String question, String errorMessage) {
		boolean check = false;
		float number = 0f;
		do {
			System.out.println(question);
			String strFloat = scanner.nextLine().replace(',', '.');
			try {
				number = Float.valueOf(strFloat);
				if (number >= lowerLimit) {
					check = true;
				} else {
					System.out.println(errorMessage);
				}
			} catch (Exception e) {
				System.out.println(errorMessage);
			}
		} while (!check);

		return number;

	}
}
