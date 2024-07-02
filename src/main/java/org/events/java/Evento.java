package org.events.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Evento class is used to generate general events instances.<br>
 * <strong>Fields</strong>
 * <ol>
 * <li><strong>eventName:</strong> String representing the title of the event.
 * Can be set with setEventName() or read with getEventName()</li>
 * <li><strong>totalSeats:</strong> int of the total seats of the venue.
 * <strong>It must be greater than 0.</strong> Can be set with setTotalSeats()
 * and read with getTotalSeats()</li>
 * <li><strong>bookedSeats:</strong> int. When an Evento instance is created,
 * <strong>it is initialized to 0</strong></li>
 * <li><strong>eventDate:</strong> LocalDate. date of the event. <strong>Cannot
 * be set in the past.</strong> Can be set with setEventDate() and read with
 * getEventDate(). getFormattedDate() returns a String of the date, formatted
 * with the dateFormat pattern
 * <li><strong>dateFormat</strong> DateTimeFormatter. deafult pattern to
 * represent a date
 */
public class Evento {

	private String eventName;
	private int totalSeats;
	private int bookedSeats;
	private LocalDate eventDate;
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");

	/**
	 * Create a new Evento instance.<br>
	 * Requires three arguments.<br>
	 * <strong>totalSeats</strong> is checked. if it's 0 or lower it's set to 100.
	 * an error message is printed.<br>
	 * <strong>eventDate</strong> is checked. if it's in the past, will be set to 90
	 * days from the current day<br>
	 * <strong>bookedSeats</strong> it's set to 0 on creation.<br>
	 * 
	 * @param eventName  String. title of the event
	 * @param totalSeats int. total seats available at the chosen venue.
	 *                   <strong>must be greater then 0</strong>
	 * @param eventDate  LocalDate. date of the event.
	 */
	public Evento(String eventName, int totalSeats, LocalDate eventDate) {
		this.eventName = eventName;
		// checks if total seats in greater than 0. if is 0 or less, sets totalSeats
		// to 100 and print a message
		if (totalSeats > 0) {
			this.totalSeats = totalSeats;
		} else {
			this.totalSeats = 100;
			System.out.println("Il numero di posti deve essere maggiore di 0\n" + "É stato quindi impostato a "
					+ this.totalSeats + "\nSi prega di modificarlo manualmente");
		}
		// checks if eventDate is in the future. if it is equal to current date or in
		// the past, sets eventDate 90 days from current date and prints a message
		if (Utils.checkDate(eventDate)) {
			this.eventDate = eventDate;
		} else {
			this.eventDate = LocalDate.now().plusDays(90);
			System.out.println("Impossiblile impostare la data nell'evento ad un giorno passato.\n"
					+ "La data è stata impostata automaticamente al giorno " + this.eventDate.format(dateFormat));

		}

		this.bookedSeats = 0;

	}

	/**
	 * Create a new Evento instance.<br>
	 * Requires five arguments.<br>
	 * <strong>totalSeats</strong> is checked. if it's 0 or lower it's set to 100.
	 * an error message is printed.<br>
	 * <strong>year, month, day</strong>are used to create a LocalDate instance that
	 * will be checked. if it's in the past, will be set to 90 days from the current
	 * day<br>
	 * <strong>bookedSeats</strong> it's set to 0 on creation.<br>
	 * 
	 * @param eventName  String. title of the event
	 * @param totalSeats int. total seats available at the chosen venue.
	 *                   <strong>must be greater then 0</strong>
	 * @param year       int. year of the event.
	 * @param month      int. month of the event.
	 * @param day        int.day of the event.
	 */
	public Evento(String eventName, int totalSeats, int year, int month, int day) {
		this.eventName = eventName;
		// checks if total seats in greater than 0. if is 0 or less, sets totalSeats
		// to 100 and print a message
		if (totalSeats > 0) {
			this.totalSeats = totalSeats;
		} else {
			this.totalSeats = 100;
			System.out.println("Il numero di posti deve essere maggiore di 0\n" + "É stato quindi impostato a "
					+ this.totalSeats + "\nSi prega di modificarlo manualmente");
		}
		// checks if eventDate is in the future. if it is equal to current date or in
		// the past, sets eventDate 90 days from current date and prints a message
		if (Utils.checkDate(year, month, day)) {
			this.eventDate = LocalDate.of(year, month, day);
		} else {
			this.eventDate = LocalDate.now().plusDays(90);
			System.out.println("Impossiblile impostare la data nell'evento ad un giorno passato.\n"
					+ "La data è stata impostata automaticamente al giorno " + this.eventDate.format(dateFormat));

		}

		this.bookedSeats = 0;

	}

	/**
	 * Create a new Evento instance.<br>
	 * Requires three arguments.<br>
	 * <strong>totalSeats</strong> is checked. if it's 0 or lower it's set to 100.
	 * an error message is printed.<br>
	 * <strong>eventDate</strong> is checked. if it's in the past, will be set to 90
	 * days from the current day<br>
	 * The provided String for eventDate must follow the pattern
	 * <strong>"yyyy-MM-dd"</strong><br>
	 * <strong>bookedSeats</strong> it's set to 0 on creation.<br>
	 * 
	 * @param eventName  String. title of the event
	 * @param totalSeats int. total seats available at the chosen venue.
	 *                   <strong>must be greater then 0</strong>
	 * @param eventDate  String. date of the event. <strong>must follow the pattern
	 *                   "yyyy-MM-dd"</strong>
	 */
	public Evento(String eventName, int totalSeats, String eventDate) {
		this.eventName = eventName;

		// checks if total seats in greater than 0. if is 0 or less, sets totalSeats
		// to 100 and print a message
		if (totalSeats > 0) {
			this.totalSeats = totalSeats;
		} else {
			this.totalSeats = 100;
			System.out.println("Il numero di posti deve essere maggiore di 0\n" + "É stato quindi impostato a "
					+ this.totalSeats + "\nSi prega di modificarlo manualmente");
		}

		// checks if eventDate is in the future. if it is equal to current date or in
		// the past, sets eventDate 90 days from current date and prints a message
		if (Utils.checkDate(eventDate)) {
			this.eventDate = LocalDate.parse(eventDate);
		} else {
			this.eventDate = LocalDate.now().plusDays(90);
			System.out.println("Impossiblile impostare la data nell'evento ad un giorno passato.\n"
					+ "La data è stata impostata automaticamente al giorno " + this.eventDate.format(dateFormat));

		}

		this.bookedSeats = 0;

	}

	/**
	 * Return a String representing the event name
	 * 
	 * @return
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * change eventName to a new value.
	 * 
	 * @param eventName
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * return eventDate in LocalDate type.
	 * 
	 * @return
	 */
	public LocalDate getEventDate() {
		return this.eventDate;
	}

	/**
	 * return a String with the event date, formatted in it style (dd MMMM yyyy).
	 * <br>
	 * to get date in LocalDate format (yyyy-MM-dd) use getEventDate instead
	 * 
	 * @return
	 */
	public String getFormattedEventDate() {
		return this.eventDate.format(dateFormat);
	}

	/**
	 * change event date to new one. requires three arguments for year, month and
	 * day.<br>
	 * checks if the new date it's in the future. prints a confirmation message with
	 * the new date. if the date provided it's the current day or it's in the past,
	 * prints an error message. the event date won't be changed.
	 * 
	 * @param year  int. year of the event.
	 * @param month int. month of the event.
	 * @param day   int.day of the event.
	 */
	public void setEventDate(int year, int month, int day) {

		LocalDate newDate = LocalDate.of(year, month, day);
		if (Utils.checkDate(newDate)) {
			this.eventDate = newDate;
			System.out.println(
					"La data è stata cambiata correttamente.\nLa nuova data è: " + this.eventDate.format(dateFormat));
		} else {
			System.out.println("Impossiblile impostare la data nell'evento ad un giorno passato");
		}

	}

	/**
	 * overload of setEventDate() change event date to new one. requires a string as
	 * argument.<br>
	 * checks if the new date it's in the future. prints a confirmation message with
	 * the new date. if the date provided it's the current day or it's in the past,
	 * prints an error message. the event date won't be changed.
	 * 
	 * @param eventDate date of the event. mandatory format: "yyyy-mm-dd"
	 */
	public void setEventDate(String eventDate) {

		LocalDate newDate = LocalDate.parse(eventDate);
		if (Utils.checkDate(newDate)) {
			this.eventDate = newDate;
			System.out.println(
					"La data è stata cambiata correttamente.\nLa nuova data è: " + this.eventDate.format(dateFormat));
		} else {
			System.out.println("Impossiblile impostare la data nell'evento ad un giorno passato");
		}

	}

	/**
	 * return a int of total seats
	 * 
	 * @return int. totalSeats
	 */
	public int getTotalSeats() {
		return this.totalSeats;
	}

	/**
	 * change totalSeats value to new one.<br>
	 * accepts one int as argument<br>
	 * check if the argument provided is greater than 0. prints a confirmation
	 * message with the updated value. if the provided argument is 0 or less, prints
	 * an error message. totalSeats value won't be changed.
	 * 
	 * @param totalSeats
	 */
	private void setTotalSeats(int totalSeats) {
		if (totalSeats > 0) {
			this.totalSeats = totalSeats;
			System.out
					.println("Il numero di posti è stato modificato.\nIl numero di posti totali è: " + this.totalSeats);
		} else {
			System.out.println("In numero di posti non può essere 0 o inferiore.\nIl numero di posti totali è: "
					+ this.totalSeats);
		}
	}

	/**
	 * return int of booked seats
	 * 
	 * @return int. bookedSeats
	 */
	public int getBookedSeats() {
		return this.bookedSeats;
	}

	/**
	 * Sets a new pattern for date formatting<br>
	 * the pattern must be composed of "dd" for days; "MM", "MMM" or "MMMM" for
	 * months and "yy" or "yyyy" for years.<br>
	 * a separator such as "-" or "/" can be used too.
	 * 
	 * @param dateFormat
	 */
	public void setDateFormat(String dateFormat) {
		this.dateFormat = DateTimeFormatter.ofPattern(dateFormat);
	}

	/**
	 * checks if there are available seats and if the event isn't concluded yet.<br>
	 * if eventDate it's in the past or there are no more seats available
	 * (bookedSeats == totalSeats), prints a message to inform user it's not
	 * possible to book seats <br>
	 * if all checks are passed, adds 1 to bookedSeats. prints a confirmation
	 * message and ticket number of 5 digits generated through generateRandomInt()
	 * 
	 */
	public void prenota() {
		if (this.bookedSeats + 1 > this.totalSeats) {
			System.out.println("Siamo spiacenti ma non ci sono più posti disponibili");
		} else if (LocalDate.now().plusDays(1).isAfter(this.eventDate)) {
			System.out.println("Siamo spiacenti ma l'evento si è già concluso");
		} else {
			this.bookedSeats += 1;
			int ticketNumber = Utils.generateRandomInt(99999, 11111);
			System.out.println("Posto prenotato.\nIl suo biglietto è il numero " + ticketNumber);
		}
	}

	/**
	 * checks if there are enough available seats and if the event isn't concluded
	 * yet.<br>
	 * if eventDate it's in the past or there are not enough seats available
	 * (bookedSeats+requestedSeats > totalSeats), prints a message to inform user
	 * it's not possible to book and shows remaining seats <br>
	 * if all checks are passed, adds requestedSeats to bookedSeats. prints a
	 * confirmation message and ticket number of 5 digits generated through
	 * generateRandomInt()
	 * 
	 */
	public void prenota(int requestedSeats) {

		// TODO valutare loop
		if (this.bookedSeats + requestedSeats > this.totalSeats) {
			System.out.println("Siamo spiacenti ma sono rimasti solamente " + (this.totalSeats - this.bookedSeats)
					+ " posti disponibili");
		} else if (LocalDate.now().plusDays(1).isAfter(this.eventDate)) {
			System.out.println("Siamo spiacenti ma l'evento si è già concluso");
		} else {
			this.bookedSeats += requestedSeats;
			int ticketNumber;
			System.out.println("Ecco i suoi biglietti:");
			for (int i = 0; i < requestedSeats; i++) {
				ticketNumber = Utils.generateRandomInt(99999, 11111);
				System.out.println("#" + ticketNumber);
			}

		}
	}

	/**
	 * checks if there are booked seats and event date is not in the past<br>
	 * if bookedSeats is 0 or eventDate is in the past, prints messages to inform
	 * the user it's not possible to cancel the booking<br>
	 * if all checks are passed, subtract 1 from bookedSeats and prints a
	 * confirmation message
	 */
	public void disdici() {
		if (this.bookedSeats == 0) {
			System.out.println("Non ci sono posti da disdire");
		} else if (LocalDate.now().plusDays(1).isAfter(this.eventDate)) {
			System.out.println("Siamo spiacenti, ma l'evento è già concluso.\nImpossibile disdire la prenotazione");
		} else {
			this.bookedSeats -= 1;
			System.out.println("Prenotazione annullata");
		}

	}

	/**
	 * prints eventDate formatted with dateFormat pattern and eventName
	 */
	@Override
	public String toString() {
		return this.eventDate.format(dateFormat) + " - " + this.eventName;
	}
}
