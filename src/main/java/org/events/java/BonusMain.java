package org.events.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class BonusMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Benvenuto nel nostro programma di inserimento di eventi");
		System.out.println("Inserire un nome per il programma di eventi");
		String programTitle = scan.nextLine();
		// constructs a new programmaEventi
		ProgrammaEventi programma = new ProgrammaEventi(programTitle);
		// declare an Evento instance. will be initialized according to user choices
		Evento event;
		// inizialized an array of strings representing the event types available
		String[] choices = { "Evento", "Concerto", "Esci" };
		String userChoice;
		boolean check = false;

		//
		boolean anotherEvent = true;

		// program is executed until user choose to stop
		while (anotherEvent) {
			do {
				System.out.println("Che tipo di evento si vuole creare?");

				for (String choice : choices) {
					System.out.println("-" + choice);
				}
				userChoice = scan.nextLine().toLowerCase().trim();
				check = ValidationUtils.checkChoice(userChoice, choices);
				if (!check) {
					System.out.println("La scelta effettuata non è valida. Riprovare");

				}

			} while (!check);

			switch (userChoice) {

			case "evento":
			case "concerto":
				// SECTION: EVENT CONSTRUCT

				// SECTION: EVENT TITLE START

				// Ask for eventName. User input is assigned to title variable
				System.out.println("Inserire il nome dell'evento");
				String title = scan.nextLine();

				// SECTION: EVENT TITLE END
				// SECTION: SEATS START

				// Instantiate a boolean variable to be used as do/while loop exit condition.
				// will be set to false before every loop
				check = false;
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

				if (userChoice.equals("evento")) {
					// constructs a new Evento. the previously gotten values are passed as arguments
					event = new Evento(title, seats, eventDate);
					// the newly created event is added to ProgrammaEventi instance
					programma.addEvent(event);
				}
				// SECTION: EVENT CONSTRUCT END
				// SECTION: CONCERT CONSTRUCT START
				if (userChoice.equals("concerto")) {
					// SECTION: CONCERT TIME START

					// initialized a new LocalTime instance. Default value is now. will be updated
					// according to user input
					LocalTime time = LocalTime.now();

					do {
						check = false;
						System.out.println("Inserire l'ora del concerto (hh:mm)");
						String inputTime = scan.nextLine();
						// user input for time is validated
						check = ValidationUtils.checkTime(inputTime);

						if (check) {
							time = LocalTime.parse(inputTime);
						} else {
							System.out.println("L'orario inserito non è valido");
						}
					} while (!check);
					// SECTION: CONCERT TIME END

					// SECTION: CONCERT PRICE START
					float price = 0f;
					do {
						check = false;
						System.out.println("Inserire il prezzo del concerto (##.##)");
						// price is taken as string
						String priceInput = scan.nextLine().replace(',', '.');

						// the price string is converted to Float and check is set to true.
						// if NumberFormatException is thrown, prints an error message and loop starts
						// again
						try {
							price = Float.valueOf(priceInput);
							if (price >= 0) {
								check = true;
							} else {
								System.out.println("Il prezzo deve essere maggiore o ugule a 0");
							}
						} catch (NumberFormatException e) {
							System.out.println("Il numero inserito non è valido. Riprovare");

						}

					} while (!check);
					// SECTION: CONCERT PRICE END

					// constructs a new Concerto as Evento. the previously gotten values are passed
					// as arguments
					event = new Concerto(title, seats, eventDate, time, price);
					// the newly created event is added to ProgrammaEventi instance
					programma.addEvent(event);

				} // if concerto close

				String question = "Si desidera creare altri eventi(S/N)";
				anotherEvent = ValidationUtils.inputMatches(scan, question, "S", "N");
				if (!anotherEvent) {
					System.out.println("A presto!");
				}

				break;
			// case evento/concerto close
			case "esci":
				System.out.println("A presto!");
				anotherEvent = false;
				break;

			}// switch close
		} // while (answer) close
		scan.close();

		if (programma.eventsCount() > 0) {
			System.out.print(programma.showProgram());
		}
	}
}
