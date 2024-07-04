package org.events.java;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Extends Evento<br>
 * <strong>Fields</strong>
 * <ol>
 * <li><strong>float concertPrice</strong> Price of the concert</li>
 * <li><strong>LocalTime concertTime</strong> Starting time of the concert, in
 * hh:mm</li>
 * </ol>
 */
public class Concerto extends Evento {

	float concertPrice;
	LocalTime concertTime;

	public Concerto(String eventName, int totalSeats, String eventDate, String concertTime, float concertPrice) {
		super(eventName, totalSeats, eventDate);
		this.concertTime = LocalTime.parse(concertTime);
		this.concertPrice = concertPrice;

	}

	public Concerto(String eventName, int totalSeats, LocalDate eventDate, int hours, int minutes, float concertPrice) {
		super(eventName, totalSeats, eventDate);
		if (Utils.checkTime(hours, minutes)) {
			this.concertTime = LocalTime.of(hours, minutes);
		} else {
			this.concertTime = LocalTime.of(00, 00);
			System.out.println("Sembra che l'orario inserito non sia valido" + "\n"
					+ "Si prega di ricontrollarlo e modificarlo manualmente");
			System.out.println("L'orario è stato impostato al valore predefinito " + this.concertTime);

		}

		this.concertPrice = concertPrice;
	}

	public Concerto(String eventName, int totalSeats, int year, int month, int day, int hours, int minutes,
			float concertPrice) {
		super(eventName, totalSeats, year, month, day);
		if (Utils.checkTime(hours, minutes)) {
			this.concertTime = LocalTime.of(hours, minutes);
		} else {
			this.concertTime = LocalTime.of(00, 00);
			System.out.println("Sembra che l'orario inserito non sia valido" + "\n"
					+ "Si prega di ricontrollarlo e modificarlo manualmente");
			System.out.println("L'orario è stato impostato al valore predefinito " + this.concertTime);
			this.concertPrice = concertPrice;
		}

	}
}
