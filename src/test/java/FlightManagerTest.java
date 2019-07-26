import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {
  private FlightManager flightManager;
  private Flight flight;
  private Plane plane;
  private Passenger passenger1, passenger2;

  @Before
  public void setUp() {
    plane = new Plane(PlaneType.TEST);
    flight = new Flight(plane, "B239", AirportCode.EDI, AirportCode.GLA, "10:00");
    passenger1 = new Passenger("Greg", 1);
    passenger2 = new Passenger("Kat", 1);
    flight.book(passenger1);
    flight.book(passenger2);
    flightManager = new FlightManager(flight);
  }

  @Test
  public void canCalculateHowMuchBaggageWeightForEachPassenger() {
    assertEquals(2.0, flightManager.getBaggageAllowance(), 0.001);
  }

  @Test
  public void canCalculateWeightBookedByPassengersOnFlight() {
    assertEquals(2.0, flightManager.getCurrentBaggageWeight(), 0.001);
  }

  @Test
  public void canCalculateHowMuchBaggageWeightReservedRemaining() {
    assertEquals(0.0, flightManager.getRemainingReservedWeight(), 0.01);
  }
}
