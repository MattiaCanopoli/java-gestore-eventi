package org.events.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Benvenuto nel nostro programma di inserimento di eventi");
		System.out.println("Inserire il nome dell'evento");
		Scanner scan = new Scanner(System.in);
		String eventName = scan.nextLine();

		String question;
		String invalidInput = "Il valore inserito non è valido";

		int currentYear = LocalDate.now().getYear();
		int year;
		int month;
		int day;

		boolean dataValidation = false;
		do {

			question = "Inserire l'anno dell'evento";
			year = Utils.checkIntInputGreater(scan, currentYear, question, invalidInput);

			question = "Inserire il mese dell'evento";
			month = Utils.checkIntInput(scan, 1, 12, question, invalidInput, invalidInput);

			question = "Inserire il giorno dell'evento";
			day = Utils.checkIntInput(scan, 1, 31, question, invalidInput, invalidInput);

			dataValidation = Utils.checkDate(year, month, day);

			if (!dataValidation) {
				System.out.println("la data inserita non è valida");
			}

		} while (!dataValidation);

		question = "Inserire numero totale di posti disponibili";

		int totalSeats = Utils.checkIntInputGreater(scan, 0, question, invalidInput);

		Evento event = new Evento(eventName, totalSeats, year, month, day);
//TODO inserire domanda Y/N con validazione per prenotazione
		event.prenota(scan);
		// TODO inserire domanda Y/N con validazione per disdetta
		event.disdici(scan);

		int availableSeats = event.getTotalSeats() - event.getBookedSeats();

		System.out
				.println("Posti prenotati: " + event.getBookedSeats() + "\n" + "Posti disponibili: " + availableSeats);

		scan.close();

	}
}
