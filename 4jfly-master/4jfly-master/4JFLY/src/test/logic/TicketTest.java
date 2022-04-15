package test.logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dkeep.logic.Ticket;

class TicketTest {

	@Test
	void insertTicketDeleteTicketTestSuccess() {
		Ticket.Insert_Ticket(99999, 1, "abel");
		assertEquals(99999,Ticket.Query_tickets("abel")[2]);
		Ticket.Delete_single_ticket(99999);
		assertEquals(0,Ticket.Query_tickets("abel")[2]);
	}

	@Test
	void queryTicketTestSuccess() {
		assertEquals(2,Ticket.Query_tickets("abel")[0]);
	}
	
	@Test
	void queryTicketTestWrongUser() {
		assertNull(Ticket.Query_tickets("abelo"));
	}

	@Test
	void queryFlightTestSuccess() {
		assertEquals(2,Ticket.Query_flights("abel")[0][0]);
		assertEquals(28621,Ticket.Query_flights("abel")[0][1]);
	}
	
	@Test
	void queryFlightTestWrongUser() {
		assertNull(Ticket.Query_flights("abelo"));
	}
}
