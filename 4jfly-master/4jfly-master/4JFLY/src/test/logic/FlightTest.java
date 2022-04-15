package test.logic;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import dkeep.logic.Flight;

class FlightTest {

	@Test
	void insertFlightDeleteFlightTestSuccess() {
		Flight.Insert_Flight(99997, "Winterfell", "King's Landing", LocalTime.of(0, 0, 0), LocalTime.of(2, 0, 0), Date.valueOf(LocalDate.of(2022, 06, 23)), 1000);
		assertEquals("99997",Flight.Query_flight_id(99997)[0][0]);
		assertEquals("99998",Flight.Query_flight_id(99998)[0][0]);
		assertEquals("99999",Flight.Query_flight_id(99999)[0][0]);
		Flight.Delete_single_flight(99997);
		Flight.Delete_single_flight(99998);
		Flight.Delete_single_flight(99999);
		assertNull(Flight.Query_flight_id(99997)[0][0]);
		assertNull(Flight.Query_flight_id(99998)[0][0]);
		assertNull(Flight.Query_flight_id(99999)[0][0]);
		
	}
	
	@Test
	void queryFlightByIDTestSuccess() {
		assertEquals("1",Flight.Query_flight_id(1)[0][0]);
		assertEquals("Zagreb",Flight.Query_flight_id(1)[0][1]);
		assertEquals("Brussels",Flight.Query_flight_id(1)[0][2]);
		assertEquals("2022-01-11",Flight.Query_flight_id(1)[0][3]);
		assertEquals("02:00:00",Flight.Query_flight_id(1)[0][4]);
		assertEquals("17:30:00",Flight.Query_flight_id(1)[0][5]);
		assertEquals("532",Flight.Query_flight_id(1)[0][6]);
		assertEquals("Easyjet",Flight.Query_flight_id(1)[0][7]);	
	}
	
	@Test
	void queryFlightByIDTestWrongTest() {
		assertNull(Flight.Query_flight_id(99999)[0][0]);
	
	}
	
	@Test
	void queryFlightOneWayTestSuccess() {
		assertEquals("74443",Flight.Query_one_way("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][0]);
		assertEquals("Zagreb",Flight.Query_one_way("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][1]);
		assertEquals("Brussels",Flight.Query_one_way("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][2]);
		assertEquals("02:00:00",Flight.Query_one_way("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][3]);
		assertEquals("19:00:00",Flight.Query_one_way("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][4]);
		assertEquals("2022-01-11",Flight.Query_one_way("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][5]);
		assertEquals("Economy",Flight.Query_one_way("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][6]);
		assertEquals("935",Flight.Query_one_way("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][7]);	
		assertEquals("Ryanair",Flight.Query_one_way("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][8]);	
		assertEquals("37",Flight.Query_one_way("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][9]);	
	}
	
	@Test
	void queryFlightOneWayTestNoFlightAvailable() {
		assertNull(Flight.Query_one_way("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2026,01,11)) ,"Economy")[0][0]);
	}
	
	@Test
	void queryFlightWayAndBackTestNoFlightAvailable() {
		assertNull(Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2026,01,11)),Date.valueOf(LocalDate.of(2026,01,11)) ,"Economy"));
	}
	
	@Test
	void queryFlightWayAndBackTestSuccess() {
		assertEquals("74443",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][0]);
		assertEquals("Zagreb",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)),"Economy")[0][1]);
		assertEquals("Brussels",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][2]);
		assertEquals("02:00:00",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][3]);
		assertEquals("19:00:00",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][4]);
		assertEquals("2022-01-11",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][5]);
		assertEquals("Economy",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][6]);
		assertEquals("935",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][7]);	
		assertEquals("Ryanair",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][8]);	
		assertEquals("37",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[0][9]);
		assertEquals("4309",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[7][0]);
		assertEquals("Brussels",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[7][1]);
		assertEquals("Zagreb",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[7][2]);
		assertEquals("16:00:00",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[7][3]);
		assertEquals("19:30:00",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[7][4]);
		assertEquals("2022-01-11",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[7][5]);
		assertEquals("Economy",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[7][6]);
		assertEquals("1001",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[7][7]);	
		assertEquals("Easyjet",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[7][8]);	
		assertEquals("0",Flight.Query_way_and_back("Zagreb", "Brussels",Date.valueOf(LocalDate.of(2022,01,11)),Date.valueOf(LocalDate.of(2022,01,11)) ,"Economy")[7][9]);
	}

}
