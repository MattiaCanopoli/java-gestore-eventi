package org.events.java;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Greets user, than ask for eventName
		System.out.println("Benvenuto nel nostro programma di inserimento di eventi");
		System.out.println("Inserire il nome dell'evento");
		// Creation of a new Scanner instance for System.in
		Scanner scan = new Scanner(System.in);
		// Initialization of a new string. The value is obtained from user input
		String eventName = scan.nextLine();
		// Declaration of a new string. will be assigned multiple times to different
		// values, depending on the question to ask
		String question;
		// Initialization of a new string for a default error message to be printed in
		// case of invalid user input
		String invalidInput = "Il valore inserito non è valido" + "\n";

		// Declaration of three variables. The values are obtained from user input
		int year;
		int month;
		int day;

		// Initialization of a boolean variable to be used in the following do/while
		// loop.
		// Loop will ends if dataValidation is true
		boolean dataValidation = false;
		do {

			// ask for year. loops until an int is provided
			question = "Inserire l'anno dell'evento";
			year = Utils.checkIntInput(scan, question, invalidInput);

			// ask for month. loops until an int is provided
			question = "Inserire il mese dell'evento";
			month = Utils.checkIntInput(scan, question, invalidInput);

			// ask for day. loops until an int is provided
			question = "Inserire il giorno dell'evento";
			day = Utils.checkIntInput(scan, question, invalidInput);

			// validate the date. a valid date is an existing date in the future
			dataValidation = Utils.checkDate(year, month, day);

			// if the provided date is not valid, prints error message and restart the loop
			if (!dataValidation) {
				System.out.println("Sembra che la data inserita sia inesistente oppure passata" + "\n"
						+ "Inserire una data valida per proseguire" + "\n");
			}

		} while (!dataValidation);

		// ask for total seats. loops until a valid int (>1) is provided
		question = "Inserire numero totale di posti disponibili";
		int totalSeats = Utils.checkIntInputGreater(scan, 1, question, invalidInput);

		// creation of a new Evento instance
		Evento event = new Evento(eventName, totalSeats, year, month, day);

		// ask user if wants to book and verify the answer. loops until a valid input is
		// provided.
		// Valid inputs are defined via positiveChecker and negativeChecker variables
		// if input is equal to positive checker, calls Evento.prenota method
		question = "Si desidera prenotare dei posti? (S/N)";
		String positiveChecker = "S";
		String negativeChecker = "N";

		if (Utils.checkInputString(scan, question, positiveChecker, negativeChecker)) {

			event.prenota(scan);
		}

		// ask user if will to cancel any booking. loops until a valid input is
		// provided.
		// Valid inputs are defined via positiveChecker and negativeChecker variables
		// if input is equal to positive checker, calls Evento.disdici method
		question = "Si desidera disdire delle prenotazioni? (S/N)";

		if (Utils.checkInputString(scan, question, positiveChecker, negativeChecker)) {
			event.disdici(scan);
		}

		// initialization of a new variable. calls two methods to get the available
		// seats value
		int availableSeats = event.getTotalSeats() - event.getBookedSeats();

		// prints a string of total of booked seats and available seats
		System.out
				.println("Posti prenotati: " + event.getBookedSeats() + "\n" + "Posti disponibili: " + availableSeats);

		scan.close();

	}
}
