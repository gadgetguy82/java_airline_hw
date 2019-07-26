import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {
  private FlightManager flightManager, flightManager2;
  private Flight flight, flight2;
  private Plane plane, plane2;
  private Passenger passenger1, passenger2, passenger3, passenger4;

  @Before
  public void setUp() {
    plane = new Plane(PlaneType.TEST);
    flight = new Flight(plane, "B239", AirportCode.EDI, AirportCode.GLA, new Date("July 13, 2019, 10:00:00"));
    passenger1 = new Passenger("Greg", 1);
    passenger2 = new Passenger("Katy", 1);
    flight.book(passenger1);
    flight.book(passenger2);
    flightManager = new FlightManager(flight);

    plane2 = new Plane(PlaneType.AIRBUSA220);
    flight2 = new Flight(plane2, "B239", AirportCode.EDI, AirportCode.GLA, new Date("July 13, 2019, 10:00:00"));
    passenger3 = new Passenger("Harry", 1);
    passenger4 = new Passenger("Perry", 1);
    flight2.book(passenger1);
    flight2.book(passenger2);
    flight2.book(passenger3);
    flight2.book(passenger4);
    flightManager2 = new FlightManager(flight2);
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

  @Test
  public void canSortPassengersBySeatNumbers() {
    flightManager2.bubbleSort(flight2.getPassengers());
    for (int i = 0; i < flight2.passengerCount(); i++) {
      System.out.println(flight2.getPassenger(i).getSeatNumber());
    }
  }

  @Test
  public void canSearchPassengerBySeatNumber() {
    Passenger passengerFound = flightManager2.binarySearch(flight2.getPassengers(), passenger3.getSeatNumber());
    System.out.println(passengerFound.getName());
  }
}
