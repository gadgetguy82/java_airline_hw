import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PassengerTest {
  private Passenger passenger;
  private Flight flight;
  private Plane plane;

  @Before
  public void setUp() {
    passenger = new Passenger("Joe", 2);
    plane = new Plane(PlaneType.BOEING767);
    flight = new Flight(plane, "B239", AirportCode.EDI, AirportCode.GLA, new Date("July 13, 2019, 10:00:00"));
  }

  @Test
  public void canGetName() {
    assertEquals("Joe", passenger.getName());
  }

  @Test
  public void canGetNoOfBags() {
    assertEquals(2, passenger.getNoOfBags());
  }

  @Test
  public void canGetFlight() {
    flight.book(passenger);
    assertEquals(flight, passenger.getFlight());
  }
}
