package org.events.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Extends Evento<br>
 * <strong>Fields</strong>
 * <ol>
 * <li><strong>float concertPrice</strong> Price of the concert</li>
 * <li><strong>LocalTime concertTime</strong> Starting time of the concert, in
 * hh:mm</li>
 * <li><strong>String formattedPrice</strong> concertPrice in human form
 * (##.##€)
 * <li><strong>DateTimeFormatter timeFormat</strong> default time formatter
 * </ol>
 */
public class Concerto extends Evento {

	private float concertPrice;
	private LocalTime concertTime;
	private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm");

	public Concerto(String eventName, int totalSeats, String eventDate, String concertTime, float concertPrice) {
		super(eventName, totalSeats, eventDate);
		if (Utils.checkTime(concertTime)) {
			this.concertTime = LocalTime.parse(concertTime);
		} else {
			this.concertTime = LocalTime.of(00, 00);
			System.out.println("Sembra che l'orario inserito non sia valido" + "\n"
					+ "Si prega di ricontrollarlo e modificarlo manualmente");
			System.out.println("L'orario è stato impostato al valore predefinito " + this.concertTime);
		}
		if (concertPrice > 0) {
			this.concertPrice = concertPrice;
		} else {
			this.concertPrice = 0.00f;
			System.out
					.println("Il prezzo del concerto è stato impostato a " + String.format("%.2f€", this.concertPrice));
		}

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

		if (concertPrice > 0) {
			this.concertPrice = concertPrice;
		} else {
			this.concertPrice = 0.00f;
			System.out
					.println("Il prezzo del concerto è stato impostato a " + String.format("%.2f€", this.concertPrice));
		}

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
		}
		if (concertPrice > 0) {
			this.concertPrice = concertPrice;
		} else {
			this.concertPrice = 0.00f;
			System.out
					.println("Il prezzo del concerto è stato impostato a " + String.format("%.2f€", this.concertPrice));
		}
	}

	public float getConcertPrice() {
		return this.concertPrice;
	}

	public void setConcertPrice(float concertPrice) {
		this.concertPrice = concertPrice;
	}

	public LocalTime getConcertTime() {
		return this.concertTime;
	}

	public void setConcertTime(LocalTime concertTime) {
		this.concertTime = concertTime;
	}

	public void setConcertTime(int hour, int minutes) {
		if (Utils.checkTime(hour, minutes)) {
			this.concertTime = LocalTime.of(hour, minutes);
		} else {
			System.out.println("L'orario inserito non è valido");
		}

	}

	public String getFormattedPrice() {
		return String.format("%.2f€", this.concertPrice);
	}

	@Override
	public String toString() {
		return "DATA: " + super.getFormattedEventDate() + "\n" + "ORARIO: " + this.concertTime + "\n" + "TITOLO: "
				+ super.getEventName() + "\n" + "PREZZO: " + String.format("%.2f€", this.concertPrice);
	}
}
