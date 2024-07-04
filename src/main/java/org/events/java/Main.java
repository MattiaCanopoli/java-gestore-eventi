package org.events.java;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Greets user, than ask for eventName
		System.out.println("Benvenuto nel nostro programma di inserimento di eventi");
		System.out.println("Inserire il nome dell'evento");
		// Creation of a new Scanner instance for System.in
		Scanner scan = new Scanner(System.in);

		String eventName = scan.nextLine();

		String question;
		String invalidInput = "Il valore inserito non è valido" + "\n";

		// int currentYear = LocalDate.now().getYear();
		int year;
		int month;
		int day;

		boolean dataValidation = false;
		do {

			question = "Inserire l'anno dell'evento";
			year = Utils.checkIntInput(scan, question, invalidInput);

			question = "Inserire il mese dell'evento";
			month = Utils.checkIntInput(scan, question, invalidInput);

			question = "Inserire il giorno dell'evento";
			day = Utils.checkIntInput(scan, question, invalidInput);

			dataValidation = Utils.checkDate(year, month, day);

			if (!dataValidation) {
				System.out.println("Sembra che la data inserita sia inesistente oppure passata" + "\n"
						+ "Inserire una data valida per proseguire" + "\n");
			}

		} while (!dataValidation);

		question = "Inserire numero totale di posti disponibili";

		int totalSeats = Utils.checkIntInputGreater(scan, 0, question, invalidInput);

		Evento event = new Evento(eventName, totalSeats, year, month, day);
		question = "Si desidera prenotare dei posti?";
		String positiveChecker = "Y";
		String negativeChecker = "N";
		if (Utils.checkInputString(scan, question, positiveChecker, negativeChecker)) {

			event.prenota(scan);
		}

		question = "Si desidera disdire delle prenotazioni?";

		if (Utils.checkInputString(scan, question, positiveChecker, negativeChecker)) {
			event.disdici(scan);
		}

		int availableSeats = event.getTotalSeats() - event.getBookedSeats();

		System.out
				.println("Posti prenotati: " + event.getBookedSeats() + "\n" + "Posti disponibili: " + availableSeats);

		scan.close();

	}
}
