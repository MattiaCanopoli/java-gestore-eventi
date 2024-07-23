package org.events.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Evento class is used to create generic events instances.<br>
 * <br>
 * <strong>Fields</strong>
 * <ol>
 * <li><strong>String eventTile:</strong> Title of the event. Can be set with
 * setEventName() or read with getEventName()</li>
 * <li><strong>int totalSeats:</strong> Total seats of the venue. <strong>It
 * must be greater than 0.</strong> Can be set with setTotalSeats() and read
 * with getTotalSeats()</li>
 * <li><strong>int bookedSeats:</strong> Seats booked When an Evento instance is
 * created, <strong>it is initialized to 0</strong></li>
 * <li><strong>LocalDate eventDate:</strong> Date of the event. <strong>Cannot
 * be set in the past.</strong> Can be set with setEventDate() and read with
 * getEventDate(). getFormattedDate() returns a String of the date, formatted
 * with the dateFormat pattern
 * <li><strong>DateTimeFormatter dateFormat</strong> Default pattern to
 * represent a date
 */
public class Evento {

	private String eventTitle;
	private LocalDate eventDate;
	private int totalSeats;
	private int bookedSeats;
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");

	/**
	 * Constructs a new Evento
	 * 
	 * @param eventTitle <strong>String</strong> title of the event
	 * @param totalSeats <strong>int</strong> total seats available at the venue. if
	 *                   it's 0 or lower, is set to a default value 100. Error
	 *                   message is printed to console.
	 * @param eventDate  <strong>LocalDate</strong> date of the event. if it's in
	 *                   the past, is set to a future date (15 days since current
	 *                   date). An error message is printed to console.
	 */
	public Evento(String eventTitle, int totalSeats, LocalDate eventDate) {
		this.eventTitle = eventTitle;

		if (totalSeats > 0) {
			this.totalSeats = totalSeats;
		} else {
			this.totalSeats = 100;
			System.out.println("Impossibile creare un evento con " + totalSeats + " posti." + "\n"
					+ "Il numero di posti è stato impostato a " + this.totalSeats);
		}

		if (eventDate.isAfter(LocalDate.now())) {
			this.eventDate = eventDate;
		} else {
			this.eventDate = LocalDate.now().plusDays(15);
			System.out.println("Sembra che la data inserita non sia valida. La data è stata impostata al giorno: "
					+ this.eventDate.format(dateFormat));
		}
		this.bookedSeats = 0;
	}

	/**
	 * Gets the eventTitle field
	 * 
	 * @return String
	 */
	public String getEventTitle() {
		return eventTitle;
	}

	/**
	 * Sets eventTitle to a new one, passed as parameter
	 * 
	 * @param eventTitle String. new eventTitle
	 */
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	/**
	 * Gets eventDate field
	 * 
	 * @return LocalDate
	 */
	public LocalDate getEventDate() {
		return eventDate;
	}

	/**
	 * Gets eventDate field, formatted like dd MMMM yyyy
	 * 
	 * @return String
	 */
	public String getFormattedEventDate() {
		return this.eventDate.format(dateFormat);
	}

	/**
	 * Sets eventDate to a new date, passed as parameter.<br>
	 * Before changing, check if the new date is in the future. it's not possible to
	 * set eventDate in the past.<br>
	 * Confirmation or error messages are printed to console.
	 * 
	 * @param eventDate LocalDate. new event date
	 */
	public void setEventDate(LocalDate eventDate) {
		if (eventDate.isAfter(LocalDate.now())) {
			this.eventDate = eventDate;
			System.out.println("Data aggiornata");
		} else {
			System.out.println("Sembra che la data inserita non sia valida. La data è stato impostata al giorno: "
					+ this.eventDate.format(dateFormat));
		}

	}

	/**
	 * Sets eventDate to a new date, passed as parameter in the form of three
	 * integers (year, month, day)<br>
	 * Before changing, check if the new date is in the future. it's not possible to
	 * set eventDate in the past.<br>
	 * Confirmation or error messages are printed to console.
	 * 
	 * @param year  int
	 * @param month int
	 * @param day   int
	 */
	public void setEventDate(int year, int month, int day) {
		LocalDate date = LocalDate.of(year, month, day);
		if (date.isAfter(LocalDate.now())) {
			this.eventDate = date;
			System.out.println("Data aggiornata");
		} else {
			System.out.println("Sembra che la data inserita non sia valida. La data è stata impostata al giorno: "
					+ this.eventDate.format(dateFormat));
		}
	}

	/**
	 * Gets totalSeats field
	 * 
	 * @return int
	 */
	public int getTotalSeats() {
		return totalSeats;
	}

	/**
	 * Sets totalSeats field to a new value, passed as parameter<br>
	 * Private method, cannot be seen outside this class
	 * 
	 * @param availableSeats
	 */
	@SuppressWarnings("unused")
	private void setTotalSeats(int availableSeats) {
		this.totalSeats = availableSeats;
	}

	/**
	 * Gets bookedSeats field
	 * 
	 * @return int
	 */
	public int getBookedSeats() {
		return bookedSeats;
	}

	/**
	 * Sets bookedSeats field to a new value, passed as parameter<br>
	 * Private method, cannot be seen outside this class
	 * 
	 * @param bookedSeats
	 */
	@SuppressWarnings("unused")
	private void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	/**
	 * Checks if eventDate is in the future and that there are available seats.<br>
	 * if all checks are passed, adds 1 to bookedSeats.<br>
	 * Eventually, prints error messages to console.
	 */
	public void prenota() {
		if (LocalDate.now().isBefore(this.eventDate)) {
			int availableSeats = this.totalSeats - this.bookedSeats;
			if (availableSeats == 0) {
				System.out.println("Siamo spiacenti, ma non ci sono più posti disponibili");
			} else {
				this.bookedSeats += 1;
			}
		} else {
			System.out.println("Siamo spiacenti, ma l'evento si è già concluso");
		}
	}

	/**
	 * Checks if eventDate is in the future, that there are enough available seats
	 * and that the int, passed as parameter, is a positive number.<br>
	 * if all checks are passed, adds and integer, passed as parameter, to
	 * bookedSeats.<br>
	 * Eventually, prints error messages to console.
	 * 
	 * @param seats int. seats to book
	 */
	public void prenota(int seats) {
		if (LocalDate.now().isBefore(this.eventDate)) {
			int availableSeats = this.totalSeats - this.bookedSeats;
			if (this.bookedSeats + seats > this.totalSeats) {
				System.out
						.println("Siamo spiacenti, ma non ci sono abbastanza posti disponibili. Sono rimasti solamente "
								+ availableSeats + " posti");
			} else if (seats <= 0) {
				System.out.println("Impossibile prenotare " + seats + "posti.");
			} else {
				this.bookedSeats += seats;
			}
		} else {
			System.out.println("Siamo spiacenti, ma l'evento si è già concluso");
		}
	}

	/**
	 * Checks if current date is before event date. if not, prints error message to
	 * console.<br>
	 * Prints question to console and waits for an int. if there are enough
	 * available seats, adds the int to bookedSeats. if not, prints an error
	 * message.<br>
	 * The int got with Scanner must be greater than 0. if not, prints an error
	 * message.<br>
	 * Requires an open Scanner instance, passed as parameter.
	 * 
	 * @param scanner an open scanner instance to get user input
	 */
	public void prenota(Scanner scanner) {

		if (LocalDate.now().isBefore(this.eventDate)) {
			int seats = 0;

			String question = "Quanti posti si desidera prenotare?";
			String errorMessage = "Il valore inserito non è valido";

			boolean check = false;

			do {
				seats = ValidationUtils.isIntGreater(scanner, 1, question, errorMessage);

				int availableSeats = this.totalSeats - this.bookedSeats;

				if (availableSeats >= seats) {
					this.bookedSeats += seats;
					System.out.println("Sono stati prenotati " + seats + " posti." + "\n" + "Rimangono ancora "
							+ (this.totalSeats - this.bookedSeats) + " posti disponibili");
					check = true;
				} else {
					System.out.println("Siamo spiacenti, rimangono solamente " + availableSeats + " posti disponibili");
				}
			} while (!check);

		} else {
			System.out.println("Siamo spiacenti, ma l'evento si è già concluso");
		}

	}

	/**
	 * Checks if eventDate is in the future and that there are booked seats.<br>
	 * if all checks are passed, subtract 1 from bookedSeats.<br>
	 * Eventually, prints error messages to console.
	 */
	public void disdici() {
		if (LocalDate.now().isBefore(this.eventDate)) {
			if (this.bookedSeats == 0) {
				System.out.println("Siamo spiacenti, ma non ci sono posti da disdire");
			} else {
				this.bookedSeats -= 1;
			}
		} else {
			System.out.println("Siamo spiacenti, ma l'evento si è già concluso");
		}

	}

	/**
	 * Checks if eventDate is in the future, that there are enough booked seats and
	 * that the int, passed as parameter, is a positive number.<br>
	 * if all checks are passed, subtract and integer, passed as parameter, from
	 * bookedSeats.<br>
	 * Eventually, prints error messages to console.
	 * 
	 * @param seats int. seats to cancel
	 */
	public void disdici(int seats) {
		if (LocalDate.now().isBefore(this.eventDate)) {
			if (this.bookedSeats < seats) {
				System.out.println("Siamo spiacenti, ma non è possibile disdire " + seats + " posti. Ci sono solamente "
						+ this.bookedSeats + " posti prenotati");
			} else if (seats <= 0) {
				System.out.println("Impossibile disdire " + seats + "posti.");
			} else {
				this.bookedSeats -= seats;
			}
		} else {
			System.out.println("Siamo spiacenti, ma l'evento si è già concluso");
		}

	}

	/**
	 * Checks if current date is before event date. if not, prints error message to
	 * console.<br>
	 * Prints question to console and waits for an int. if there are enough booked
	 * seats, sutract the int from bookedSeats. if not, prints an error message.<br>
	 * The int got with Scanner must be greater than 0. if not, prints an error
	 * message.<br>
	 * Requires an open Scanner instance, passed as parameter.
	 * 
	 * @param scanner an open scanner instance to get user input
	 */
	public void disdici(Scanner scanner) {

		if (LocalDate.now().isBefore(this.eventDate)) {

			int seats = 0;
			String question = "Quanti posti si desidera disdire?";
			String errorMessage = "Il valore inserito non è valido";

			boolean check = false;

			do {
				seats = ValidationUtils.isIntGreater(scanner, 1, question, errorMessage);

				if (this.bookedSeats >= seats) {
					this.bookedSeats -= seats;
					System.out.println("Sono stati disdetti " + seats + " posti." + "\n" + "Rimangono ancora "
							+ (this.totalSeats - this.bookedSeats) + " posti disponibili");
					check = true;
				} else {
					System.out.println("Impossibile disdire " + seats + " posti." + "\n" + "Ci sono solamente "
							+ this.bookedSeats + " posti prenotati");
				}
			} while (!check);

		} else {
			System.out.println("Siamo spiacenti, ma l'evento si è già concluso");
		}

	}

	/**
	 * Gets a string of formatted eventDate and eventTitle
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return this.eventDate.format(dateFormat) + " - " + this.eventTitle;
	}
}
