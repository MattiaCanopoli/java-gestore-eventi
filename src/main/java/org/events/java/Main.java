package org.events.java;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Evento event = new Evento("Concerto Grosso N˚3", 1, "2021-12-12");
		System.out.println(event.getTotalSeats());

		// event.setTotalSeats(1500);

		// System.out.println(event.getTotalSeats());

		// System.out.println(event.getBookedSeats());

		event.prenota();
		event.prenota();

		System.out.println(event.getBookedSeats());

		event.disdici();

		System.out.println(event.getBookedSeats());

		event.disdici();
		event.setDateFormat("yyyyMMdd");
		System.out.println(event.toString());

	}

}
