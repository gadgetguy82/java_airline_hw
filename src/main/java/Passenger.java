public class Passenger {
  private String name;
  private int noOfBags, seatNumber;
  private Flight flight;

  public Passenger(String name, int noOfBags) {
    this.name = name;
    this.noOfBags = noOfBags;
  }

  public String getName() {
    return this.name;
  }

  public int getNoOfBags() {
    return this.noOfBags;
  }

  public Flight getFlight() {
    return this.flight;
  }

  public int getSeatNumber() {
    return this.seatNumber;
  }

  public void addFlight(Flight flight) {
    this.flight = flight;
    this.seatNumber = this.flight.assignSeat();
  }

  public void bookSeat(int seatNumber) {
    this.seatNumber = seatNumber;
//    System.out.println(this.seatNumber);
  }
}
