import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Flight {
  private ArrayList<Passenger> passengers;
  private Plane plane;
  private String flightNumber;
  private AirportCode destination, departureAirport;
  private Date departureTime;
  private ArrayList<Integer> seatsBooked;

  public Flight(Plane plane, String flightNumber, AirportCode destination, AirportCode departureAirport, Date departureTime) {
    this.plane = plane;
    this.flightNumber = flightNumber;
    this.destination = destination;
    this.departureAirport = departureAirport;
    this.departureTime = departureTime;
    this.passengers = new ArrayList<Passenger>();
    this.seatsBooked = new ArrayList<Integer>();
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

  public Date getDepartureTime() {
    return this.departureTime;
  }

  public ArrayList<Passenger> getPassengers() {
    return this.passengers;
  }

  public Passenger getPassenger(int index) {
    return this.passengers.get(index);
  }

  public void setPassenger(int index, Passenger passenger) {
    this.passengers.add(index, passenger);
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
      passenger.addFlight(this);
      passenger.bookSeat(assignSeat());
    }
  }

  public int assignSeat() {
    if (seatsBooked.size() < plane.getCapacity()) {
      Random number = new Random();
      int seatNo = number.nextInt(plane.getCapacity());
      seatNo += 1;
      if (!seatsBooked.contains(seatNo)) {
        seatsBooked.add(seatNo);
//        System.out.println(seatNo);
        return seatNo;
      } else {
        return assignSeat();
      }
    } else {
      return 0;
    }
  }
}
