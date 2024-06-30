package org.events.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	private String eventName;
	private int totalSeats;
	private int bookedSeats;
	private LocalDate eventDate;
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");

	/**
	 * Costruttore per classe Evento
	 * 
	 * @param eventName  nome dell'evento
	 * @param totalSeats numero totale posti
	 * @param year       anno dell'evento
	 * @param month      mese dell'evento
	 * @param day        giorno dell'evento
	 */
	public Evento(String eventName, int totalSeats, int year, int month, int day) {
		this.eventName = eventName;
		this.totalSeats = totalSeats;
		this.eventDate = LocalDate.of(year, month, day);
		this.bookedSeats = 0;

	}

	public String getEventName() {
		return eventName;
	}

	private void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	private void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	private void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public String getEventDate() {
		return this.eventDate.format(dateFormat);
	}

	private void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public void prenota(int numeroPosti) {

		if (LocalDate.now().isAfter(this.eventDate)) {

			System.out.println("Evento passato");
		} else if (this.bookedSeats + numeroPosti > totalSeats) {
			System.out.println("Posti non disponibili");
		} else {
			this.bookedSeats += numeroPosti;
			System.out.println("Prenotato " + numeroPosti + " posti");
		}

	}

	public void disdici(int numeroPosti) {

		if (LocalDate.now().isAfter(this.eventDate)) {
			System.out.println("Evento passato");
		} else if (this.bookedSeats < numeroPosti) {
			System.out.println("Impossibile disdire posti non prenotati");
		} else {
			this.bookedSeats -= numeroPosti;
			System.out.println("Disdetto " + numeroPosti + " posti");
		}

	}
}
