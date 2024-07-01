package org.events.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate eventDate;

		Scanner scan = new Scanner(System.in);

		System.out.println("Benvenuto nel nostro programma di inserimento di eventi");
		System.out.println("Insetrire il nome dell'evento");
		String eventName = scan.nextLine();

		boolean dataValidation = false;
		do {

			String question = "Inserire l'anno dell'evento";
			String invalidImput = "Il valore inserito non è valido";
			int year = Utils.checkIntImput(scan, question, invalidImput);

			question = "Inserire il mese dell'evento";
			int month = Utils.checkIntImput(scan, question, invalidImput);

			question = "Inserire il giorno dell'evento";
			int day = Utils.checkIntImput(scan, question, invalidImput);

			eventDate = LocalDate.of(year, month, day);

			dataValidation = Utils.checkDate(eventDate);

			if (!dataValidation) {
				System.out.println("la data inserita non è valida");
			}

		} while (!dataValidation);

		System.out.println("Insetrire numero totale di posti disponibili");
		int totalSeats = scan.nextInt();
		scan.nextLine();

		Evento event = new Evento(eventName, totalSeats, eventDate);

		System.out.print(event.toString());

		scan.close();

	}

}
