package org.events.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Create a new Scanner instance.
		Scanner scan = new Scanner(System.in);
		System.out.println("Benvenuto nel nostro programma di inserimento di eventi");
//SECTION: EVENT CONSTRUCT

		// SECTION: EVENT TITLE START

		// Ask for eventName. User input is assigned to title variable
		System.out.println("Inserire il nome dell'evento");
		String title = scan.nextLine();

		// SECTION: EVENT TITLE END
		// SECTION: SEATS START

		// Instantiate a boolean variable to be used as do/while loop exit condition.
		// will be set to false before every loop
		boolean check = false;
		// User input is verified and assigned to seats variable.
		// Loops until a valid input is provided (int > 0)
		int seats = 0;
		do {
			System.out.println("Inserire il numero di posti disponibili");
			// checks if user input is an int. if true, is assigned to seats
			if (scan.hasNextInt()) {
				seats = scan.nextInt();
				scan.nextLine();
				// checks if the given int is greater than 0. check is set to true to exit loop
				if (seats > 0) {
					check = true;
				} else {
					System.out.println("Il numero minimo di posti è 1");
				}
			} else {
				scan.nextLine();
				System.out.println("É possibile inserire solamente valori numerici");
			}

		} while (!check);
		// SECTION: SEATS END
		// SECTION: DATE START

		// Instantiate a LocalDate variable that will be reassigned at the end of the
		// do/while loop
		LocalDate eventDate = LocalDate.now();

		do {
			check = false;

			// SECTION: YEAR START

			// User input is verified and assigned to year variable.
			// Loops until a valid input is provided (int >= currentYear)
			int year = 0;
			do {
				check = false;
				System.out.println("Inserire l'anno dell'evento");
				// checks if user input is an int. if true, is assigned to year
				if (scan.hasNextInt()) {
					year = scan.nextInt();
					scan.nextLine();
					int currentYear = LocalDate.now().getYear();
					// checks if user input is >= currentYear. set check to true to exit loop
					if (year >= currentYear) {
						check = true;
					} else {
						System.out.println("L'anno deve essere maggiore o uguale a " + currentYear);
					}
				} else {
					scan.nextLine();
					System.out.println("É possibile inserire solamente valori numerici");
				}

			} while (!check);
			// SECTION: YEAR END
			// SECTION: MONTH START

			// User input is verified and assigned to month variable.
			// Loops until a valid input is provided (int >0 <= 12)
			int month = 0;
			do {
				check = false;
				System.out.println("Inserire il mese dell'evento (1-12)");
				// checks if user input is an int. if true, is assigned to month
				if (scan.hasNextInt()) {
					month = scan.nextInt();
					scan.nextLine();
					// checks if user input is within range. set check to true to exit loop
					if (month > 0 && month <= 12) {
						check = true;
					} else {
						System.out.println("Deve essere un valore compreso tra 1 e 12");
					}
				} else {
					scan.nextLine();
					System.out.println("É possibile inserire solamente valori numerici");
				}
			} while (!check);

			// SECTION: MONTH END
			// SECTION: DAY START

			// User input is verified and assigned to day variable.
			// Loops until a valid input is provided (int >0 <= 31)
			int day = 0;
			do {
				check = false;
				System.out.println("Inserire il giorno dell'evento");
				// checks if user input is an int. if true, is assigned to day
				if (scan.hasNextInt()) {
					day = scan.nextInt();
					scan.nextLine();
					// checks if user input is within range. set check to true to exit loop
					if (day > 0 && day <= 31) {
						check = true;
					} else {
						System.out.println("Deve essere un valore compreso tra 1 e 31");
					}
				} else {
					scan.nextLine();
					System.out.println("É possibile inserire solamente valori numerici");
				}

			} while (!check);

			// SECTION: DAY END

			/*
			 * Verify the given date. if date is not valid (past, current date or not
			 * existent) print a message and loop again. Else, assign the given date to
			 * eventDate and exit the loop
			 */
			if (ValidationUtils.checkDate(year, month, day)) {
				eventDate = LocalDate.of(year, month, month);
				check = true;
			} else {
				check = false;
				System.out.println("Sembra che la data inserita sia inesistente oppure passata." + "\n"
						+ "Inserire una data valida per proseguire." + "\n");
			}

		} while (!check);

		// SECTION: DATE END

		// constructs a new Evento. the previously gotten values are passed as arguments
		Evento event = new Evento(title, seats, eventDate);

//SECTION: EVENT CONSTRUCT END
//SECTION: PRENOTA START

		// ask question and validate answer. loops until a valid input is provided.
		String question = "Si desidera prenotare dei posti? (S/N)";
		// answer is set to true if input="S", to false if input = "N"
		boolean answer = ValidationUtils.inputMatches(scan, question, "S", "N");
		// if answer = true, ask for bookings
		int totalBookings = 0;
		check = false;
		// NOTE this part of code will be executed only if user answer=true
		if (answer) {
			int bookings = 0;
			while (answer) {
				do { // start of do/while loop to validate user input. once a valid input is
						// provided, prenota is called
					System.out.println("Quanti posti si desidera prenotare");
					// checks if user input is an int. if true, is assigned to bookings
					if (scan.hasNextInt()) {
						bookings = scan.nextInt();
						scan.nextLine();
						// checks if bookings > 0. calls prenota with booking passed as parameter.
						// prenota check if there are enough available seats
						// set check to true to exit loop
						if (bookings > 0) {
							totalBookings += event.prenota(bookings);
							check = true;
						} else {
							System.out.println("Impossibile prenotare " + bookings + " posti");
						}
					} else {
						scan.nextLine();
						System.out.println("É possibile inserire solamente valori numerici");
					}

				} while (!check); // end of do/while (!check) loop

				// if there are enough available seats, user is asked to book again
				if (event.getTotalSeats() - event.getBookedSeats() > 0) {
					question = "Si desidera prenotare altri posti? (S/N)";
					answer = ValidationUtils.inputMatches(scan, question, "S", "N");
				} else {
					answer = false;
				}
			} // end of while(answer)

			// bookings and available seats are printed only if answer=true
			System.out.println("Hai prenotato " + totalBookings + " posti." + "\n" + "Ci sono ancora "
					+ (event.getTotalSeats() - event.getBookedSeats()) + " posti disponibili");
		}
//SECTION: PRENOTA END
//SECTION: DISDICI START

		// NOTE: this part of code will be executed only if user has booked any seat
		if (totalBookings > 0) {
			// ask question and validate answer. loops until a valid input is provided.
			question = "Si desidera disdire dei posti? (S/N)";
			// answer is set to true if input="S", to false if input = "N"
			answer = ValidationUtils.inputMatches(scan, question, "S", "N");
			// if answer is true, ask for cancellations
			int totalCancellations = 0;
			check = false;
			if (answer) {
				int cancellations = 0;
				while (answer) {
					do { // start of do/while loop to validate user input. once a valid input is
							// provided, disdici is called
						System.out.println("Quanti posti si desidera disdire?");
						// checks if user input is an int. if true, is assigned to cancellations
						if (scan.hasNextInt()) {
							cancellations = scan.nextInt();
							scan.nextLine();
							// checks if cancellations in in range (0 to totalBookings).
							// calls disdici. cancellations in passed as parameter.
							// cancellations is subtracted from totalBookings
							// set check to true to exit loop
							if (cancellations > 0 && cancellations <= totalBookings) {
								totalCancellations += event.disdici(cancellations);
								totalBookings -= cancellations;
								check = true;
							} else {
								System.out.println("Impossibile disdire " + cancellations + " posti");
							}
						} else {
							scan.nextLine();
							System.out.println("É possibile inserire solamente valori numerici");
						}

					} while (!check);// end of do/while (!check) loop

					// if there are bookings left, user is asked to cancel again
					if (totalCancellations < totalBookings) {
						question = "Si desidera disdire altri posti? (S/N)";
						answer = ValidationUtils.inputMatches(scan, question, "S", "N");
					} else {
						answer = false;
					}

				} // end of while(answer) loop
				System.out.println("Hai disdetto " + totalCancellations + " posti." + "\n" + "Ci sono ancora "
						+ (event.getTotalSeats() - event.getBookedSeats()) + " posti disponibili");
			}
		}

//SECTION: DISDICI END
//SECTION: RECAP START

		// get available seats after bookings and cancellations
		int availableSeats = event.getTotalSeats() - event.getBookedSeats();

		// prints available and booked seats
		System.out.println("Posti disponibili: " + availableSeats);
		System.out.println("Totale posti prenotati: " + event.getBookedSeats());

//SECTION: RECAP END
		scan.close();
	}

}