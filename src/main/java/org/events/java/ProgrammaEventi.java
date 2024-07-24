package org.events.java;

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

	public void addEvent(Evento event) {
		this.eventList.add(event);
	}

}
