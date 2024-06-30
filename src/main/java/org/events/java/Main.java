package org.events.java;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Evento evento = new Evento("concerto", 10, 2025, 12, 7);

		evento.prenota(5);

		System.out.println(evento.getBookedSeats());

		evento.prenota(5);

		System.out.println(evento.getBookedSeats());

		evento.disdici(3);

		System.out.println(evento.getBookedSeats());

		evento.prenota(2);

		System.out.println(evento.getBookedSeats());

		evento.prenota(2);

	}

}
