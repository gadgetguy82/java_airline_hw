import java.util.ArrayList;

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

  public void bubbleSort(ArrayList<Passenger> array) {
    Passenger tempPassenger;
    for (int i = 0; i < array.size() - 1; i++) {
      for (int j = 0; j < array.size() - i - 1; j++) {
        if (array.get(j).getSeatNumber() > array.get(j + 1).getSeatNumber()) {
          tempPassenger = array.get(j);
          array.set(j, array.get(j + 1));
          array.set(j + 1, tempPassenger);
        }
      }
    }
  }

  public Passenger binarySearch(ArrayList<Passenger> array, int seatNumber) {
    bubbleSort(array);
    if (array.size() == 0) {
      return null;
    }

    int midIndex = 0;
    if (array.size() > 1) {
      midIndex = (int) Math.ceil((double) array.size() / 2);
    }

    Passenger midPoint = array.get(midIndex);
    if (seatNumber == midPoint.getSeatNumber()) {
      return midPoint;
    }

    ArrayList<Passenger> newSearchArea;
    if (seatNumber < midPoint.getSeatNumber()) {
      newSearchArea = new ArrayList<Passenger>(array.subList(0, midIndex));
    } else {
      newSearchArea = new ArrayList<Passenger>(array.subList(midIndex + 1, array.size()));
    }
    return binarySearch(newSearchArea, seatNumber);
  }
}
