public class FlightManager {
  private Flight flight;

  public FlightManager(Flight flight) {
    this.flight = flight;
  }


  public double getBaggageAllowance() {
    Plane plane = flight.getPlane();
    return plane.getTotalWeight() / plane.getCapacity();
  }

  public double getCurrentBaggageWeight() {
    double totalWeight = 0.0;
    for (Passenger passenger : flight.getPassengers()) {
      totalWeight += passenger.getNoOfBags();
    }
    return totalWeight;
  }

  public double getRemainingReservedWeight() {
    return getBaggageAllowance() - getCurrentBaggageWeight();
  }
}
