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
	 * Change programTitle to a new value, passed ad parameter
	 * 
	 * @param programTitle String. the new programTitle
	 */
	public void setProgramTitle(String programTitle) {
		this.programTitle = programTitle;
	}

	/**
	 * Adds a new Evento object, passed as parameter, to eventList
	 * 
	 * @param event Evento. the object to add
	 */
	public void addEvent(Evento event) {
		this.eventList.add(event);
	}

	/**
	 * Prints eventTitle of every Evento in eventList
	 */
	public void listEvents() {
		for (Evento event : this.eventList) {
			System.out.println(event.getEventTitle());
		}
	}

	/**
	 * * Prints eventTitle of every Evento in eventList whose eventDate matches the
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

}
