public class Plane {
  private PlaneType type;

  public Plane(PlaneType type) {
    this.type = type;
  }

  public PlaneType getType() {
    return this.type;
  }

  public int getCapacity() {
    return getType().getCapacity();
  }

  public int getTotalWeight() {
    return getType().getTotalWeight();
  }
}
