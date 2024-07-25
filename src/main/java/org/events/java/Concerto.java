package org.events.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Subclass of Evento, used to create Concerto instances<br>
 * <br>
 * <strong>Fields</strong>
 * <ol>
 * <li><strong>float concertPrice</strong> Price of the concert<br>
 * Can be read with getConcertPrice or getFormattedConcertPrice.<br>
 * Can be overwritten with setConcertPrice</li>
 * <li><strong>LocalTime concertTime</strong> Time of the concert.<br>
 * Can be read with getConcertTime or getFormattedConcertTime.<br>
 * Can be overwritten with setConcertTime</li>
 * <li><strong>DateTimeFormatter timeFormat</strong> Default pattern to
 * represent a time (hh:mm am/pm)</li>
 * </ol>
 */
public class Concerto extends Evento {

	private float concertPrice;
	private LocalTime concertTime;
	private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");

	/**
	 * Constructs a new Concerto
	 * 
	 * @param eventTitle   <strong>String</strong> title of the event
	 * @param totalSeats   <strong>int</strong> total seats available at the venue.
	 *                     if it's 0 or lower, is set to a default value 100. Error
	 *                     message is printed to console.
	 * @param eventDate    <strong>LocalDate</strong> date of the event. if it's in
	 *                     the past, is set to a future date (15 days since current
	 *                     date). An error message is printed to console.
	 * @param concertTime  <strong>LocalTime</strong> time of the event
	 * @param concertPrice <strong>float</strong> price of the event
	 */
	public Concerto(String eventTitle, int totalSeats, LocalDate eventDate, LocalTime concertTime, float concertPrice) {
		super(eventTitle, totalSeats, eventDate);
		this.concertTime = concertTime;
		this.concertPrice = concertPrice;
	}

	/**
	 * Gets concertPrice field
	 * 
	 * @return float
	 */
	public float getConcertPrice() {
		return this.concertPrice;
	}

	/**
	 * Sets concertPrice to a new value, passed as parameter
	 * 
	 * @param concertPrice float. new value for concertPrice
	 */
	public void setConcertPrice(float concertPrice) {
		this.concertPrice = concertPrice;
	}

	/**
	 * Sets concertPrice to a new value, got through user input.<br>
	 * Ask a question and waits for a float greater than 0. if user input is not
	 * valid prints error message.<br>
	 * Keeps asking until a valid value is provided.<br>
	 * Requires and open Scanner instance, passed as parameter.
	 * 
	 * @param scanner an open scanner instance to get user input
	 */
	public void setConcertPrice(Scanner scanner) {
		String question = "Inserire il prezzo per il concerto";
		String errorMessage = "Il valore inserito non è valido";
		float price = ValidationUtils.isFloatGreater(scanner, 0, question, errorMessage);
		this.concertPrice = price;

	}

	/**
	 * Gets concertTime field
	 * 
	 * @return LocalTime
	 */
	public LocalTime getConcertTime() {
		return this.concertTime;
	}

	/**
	 * Sets concertTime to a new LocalTime, passed as parameter
	 * 
	 * @param concertTime LocalTime
	 */
	public void setConcertTime(LocalTime concertTime) {
		this.concertTime = concertTime;
	}

	/**
	 * Sets concertTime to a new time, passed as parameter in the form of two
	 * integers (hh; mm)<br>
	 * Before changing, check if the new time is valid (hh must be 0-23 and minutes
	 * 0-59.<br>
	 * Eventually, an error messages is printed to console.
	 * 
	 * @param hh int. must be in range 0-23
	 * @param mm int. must be in range 0-59
	 */
	public void setConcertTime(int hh, int mm) {
		if ((hh >= 0 && hh <= 23) && (mm >= 0 && mm <= 59)) {
			LocalTime concertTime = LocalTime.of(hh, mm);
			this.concertTime = concertTime;
		} else {
			System.out.println("L'orario inserito non è valido");
		}
	}

	/**
	 * Gets concertTime field, formatted like hh:mm am/pm
	 * 
	 * @return String
	 */
	public String getFormattedConcertTime() {
		return this.concertTime.format(timeFormat);
	}

	/**
	 * Gets eventDate field, formatted like dd MMMM yyyy and concertTime field,
	 * formatted like hh:mm am/pm
	 * 
	 * @return String
	 */
	public String getFormattedDateAndTime() {
		return super.getFormattedEventDate() + " " + this.concertTime.format(timeFormat);
	}

	/**
	 * Gets concertPrice with 2 decimal digits and currency symbol (€)
	 * 
	 * @return String
	 */
	public String getFormattedConcertPrice() {
		String formattedPrice = String.format("%.2f€", this.concertPrice);
		return formattedPrice;
	}

	/**
	 * Overrides Evento.toString()<br>
	 * Gets a string of formatted date and time (dd MMMM yyyy; hh:mm am/pm),
	 * eventTitle and formatted price (##.##€)
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return this.getFormattedDateAndTime() + " - " + this.getEventTitle() + " - " + this.getFormattedConcertPrice();
	}

}
