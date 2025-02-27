package org.events.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

	private String programTitle;
	private List<Evento> eventList;

	/**
	 * Constructor for a new ProgrammaEventi.<br>
	 * programTitle is passed as parameter.<br>
	 * A new empty ArrayList is declared on construction.
	 * 
	 * @param programTitle String. title of the ProgrammaEventi
	 */
	public ProgrammaEventi(String programTitle) {
		this.programTitle = programTitle;
		this.eventList = new ArrayList<Evento>();
	}

	/**
	 * Gets programTitle field
	 * 
	 * @return String
	 */
	public String getProgramTitle() {
		return this.programTitle;
	}

	/**
	 * Change Title to a new value, passed ad parameter
	 * 
	 * @param programTitle String. the title
	 */
	public void setProgramTitle(String programTitle) {
		this.programTitle = programTitle;
	}

	/**
	 * Adds a new Evento object, passed as parameter, to ProgrammaEventi
	 * 
	 * @param event Evento. the object to add
	 */
	public void addEvent(Evento event) {
		this.eventList.add(event);
	}

	/**
	 * Prints Title of every Evento in ProgrammaEventi
	 */
	public void listEvents() {
		for (Evento event : this.eventList) {
			System.out.println(event.getEventTitle());
		}
	}

	/**
	 * * Prints title of every Evento in ProgrammaEventi whose date matches the
	 * LocalDate passed as parameter
	 * 
	 * @param eventDate LocalDate.
	 */
	public void listEvents(LocalDate eventDate) {
		for (Evento event : this.eventList) {
			if (event.getEventDate().equals(eventDate))
				System.out.println(event.getEventTitle());
		}
	}

	/**
	 * Gets the number of Evento instances in ProgrammaEventi
	 * 
	 * @return int
	 */
	public int eventsCount() {
		return this.eventList.size();
	}

	/**
	 * removes all the Evento instances in ProgrammaEventi
	 */
	public void clearEventList() {
		this.eventList.clear();
	}

	// Sorts ProgrammaEventi by date
	public void sortProgram() {
		boolean swap = false;
		do {
			swap = false;
			for (int i = 1; i < this.eventList.size(); i++) {

				Evento currentElement = this.eventList.get(i);
				Evento previousElement = this.eventList.get(i - 1);
				LocalDate currentElementDate = currentElement.getEventDate();
				LocalDate previousElementDate = previousElement.getEventDate();

				if (currentElementDate.isBefore(previousElementDate)) {
					this.eventList.set(i - 1, currentElement);
					this.eventList.set(i, previousElement);
					swap = true;
				}
			}
		} while (swap);
	}

	/**
	 * Sorts every Evento in ProgrammaEventi by date.<br>
	 * Return a string representing a list of all the Evento instances (date and
	 * title) in ProgrammaEventi
	 * 
	 * @return String. a list of all the Evento instances in ProgrammaEventi
	 */
	public String showProgram() {
		this.sortProgram();
		String fullProgram = this.programTitle.toUpperCase() + "\n";
		for (Evento event : this.eventList) {
			fullProgram += event.getFormattedEventDate() + " - " + event.getEventTitle() + "\n";
		}
		return fullProgram;
	}

}
