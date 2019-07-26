import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightTest {
  private Flight flight, testFlight;
  private Plane plane, testPlane;
  private Passenger passenger1, passenger2, passenger3;

  @Before
  public void setUp() {
    plane = new Plane(PlaneType.BOEING767);
    testPlane = new Plane(PlaneType.TEST);
    flight = new Flight(plane, "B239", AirportCode.EDI, AirportCode.GLA, "10:00");
    testFlight = new Flight(testPlane, "B308", AirportCode.GLA, AirportCode.EDI, "14:00");
    passenger1 = new Passenger("Jack", 1);
    passenger2 = new Passenger("Jill", 2);
    passenger3 = new Passenger("Harry", 1);
  }

  @Test
  public void flightStartsOffEmpty() {
    assertEquals(0, flight.passengerCount());
  }

  @Test
  public void canGetPlane() {
    assertEquals(plane, flight.getPlane());
  }

  @Test
  public void canGetFlightNumber() {
    assertEquals("B239", flight.getFlightNumber());
  }

  @Test
  public void canGetDestination() {
    assertEquals(AirportCode.EDI, flight.getDestination());
  }

  @Test
  public void canGetDepartureAirport() {
    assertEquals(AirportCode.GLA, flight.getDepartureAirport());
  }

  @Test
  public void canGetDepartureTime() {
    assertEquals("10:00", flight.getDepartureTime());
  }

  @Test
  public void canGetPassengers() {
    ArrayList<Passenger> testPassengers = new ArrayList<Passenger>();
    testPassengers.add(passenger1);
    testPassengers.add(passenger2);
    flight.book(passenger1);
    flight.book(passenger2);
    assertEquals(testPassengers, flight.getPassengers());
  }

  @Test
  public void canGetNumberOfAvailableSeats() {
    assertEquals(500, flight.noOfAvailableSeats());
  }

  @Test
  public void canBookPassengerOnFlight() {
    flight.book(passenger1);
    assertEquals(1, flight.passengerCount());
  }

  @Test
  public void checkIfSeatsAreAvailable() {
    assertEquals(true, flight.availableSeats());
  }

  @Test
  public void checkIfSeatsAreNotAvailable() {
    testFlight.book(passenger1);
    testFlight.book(passenger2);
    assertEquals(false, testFlight.availableSeats());
  }

  @Test
  public void cannotOverbookFlight() {
    testFlight.book(passenger1);
    testFlight.book(passenger2);
    testFlight.book(passenger3);
    assertEquals(2, testFlight.passengerCount());
  }
}
