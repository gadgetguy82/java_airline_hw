import java.util.ArrayList;

public class Flight {
  private ArrayList<Passenger> passengers;
  private Plane plane;
  private String flightNumber;
  private AirportCode destination, departureAirport;
  private String departureTime;

  public Flight(Plane plane, String flightNumber, AirportCode destination, AirportCode departureAirport, String departureTime) {
    this.plane = plane;
    this.flightNumber = flightNumber;
    this.destination = destination;
    this.departureAirport = departureAirport;
    this.departureTime = departureTime;
    this.passengers = new ArrayList<Passenger>();
  }

  public Plane getPlane() {
    return this.plane;
  }

  public String getFlightNumber() {
    return this.flightNumber;
  }

  public AirportCode getDestination() {
    return this.destination;
  }

  public AirportCode getDepartureAirport() {
    return this.departureAirport;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public int passengerCount() {
    return this.passengers.size();
  }

  public int noOfAvailableSeats() {
    return this.plane.getCapacity() - passengerCount();
  }

  public boolean availableSeats() {
    return noOfAvailableSeats() > 0;
  }

  public void book(Passenger passenger) {
    if (availableSeats()) {
      this.passengers.add(passenger);
    }
  }
}
