package org.events.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create a new Scanner instance.
		// Greet user
		Scanner scan = new Scanner(System.in);
		System.out.println("Benvenuto nel nostro programma di inserimento di eventi");

		// Ask for eventName. waits for input
		System.out.println("Inserire il nome dell'evento");
		String title = scan.nextLine();

		// Instantiate two strings, to be used as parameters in following methods
		String errorMessage = "Il valore inserito non è valido";
		String question = "Inserire il numero di posti disponibili";

		// Get seats value through user input, verified with isIntGreater method
		int seats = ValidationUtils.isIntGreater(scan, 1, question, errorMessage);

		// Instantiate a boolean variable to be used as do/while exit condition
		boolean validDateCheck = false;
		// Instantiate a LocalDate variable that will be reassigned at the end of the
		// do/while loop
		LocalDate eventDate = LocalDate.now();

		do {
			// Get year value through user input, verified with isInt method
			question = "Inserire l'anno dell'evento";
			int year = ValidationUtils.isInt(scan, question, errorMessage);
			// Get month value through user input, verified with isInt method
			question = "Inserire il mese dell'evento (1-12)";
			int month = ValidationUtils.isInt(scan, question, errorMessage);
			// Get day value through user input, verified with isInt method
			question = "Inserire il giorno dell'evento";
			int day = ValidationUtils.isInt(scan, question, errorMessage);
			/*
			 * Verify the given date. if date is not valid (past, current date or not
			 * existent) print a message and loop again. Else, assign the value to eventDate
			 * and exit the loop
			 */
			if (ValidationUtils.checkDate(year, month, day)) {
				eventDate = LocalDate.of(year, month, month);
				validDateCheck = true;
			} else {
				System.out.println("Sembra che la data inserita sia inesistente oppure passata." + "\n"
						+ "Inserire una data valida per proseguire." + "\n");
			}

		} while (!validDateCheck);

		// constructs a new Evento. the previously gotten values are passed as arguments
		Evento event = new Evento(title, seats, eventDate);

		// ask user if wants to book seats. input is verified with inputMatches
		question = "Si desidera prenotare dei posti? (S/N)";
		if (ValidationUtils.inputMatches(scan, question, "S", "N")) {
			// on positive answer, ask for quantity to book
			event.prenota(scan);
		}

		// if there are booked seats, ask user if wants to cancel any booking
		if (event.getBookedSeats() > 0) {
			question = "Si desidera disdire dei posti? (S/N)";
			if (ValidationUtils.inputMatches(scan, question, "S", "N")) {
				// on positive answer, ask for quantity to cancel
				event.disdici(scan);
			}
		}

		// get available seats after bookings and cancellations
		int availableSeats = event.getTotalSeats() - event.getBookedSeats();

		// prints available and booked seats
		System.out.println("Posti disponibili: " + availableSeats);
		System.out.println("Posti prenotati: " + event.getBookedSeats());

		scan.close();
	}

}
