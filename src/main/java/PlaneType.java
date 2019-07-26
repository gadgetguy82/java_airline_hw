public enum PlaneType {
  BOEING747(400, 800);

  private final int capacity, totalWeight;

  PlaneType(int capacity, int totalWeight) {
    this.capacity = capacity;
    this.totalWeight = totalWeight;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public int getTotalWeight() {
    return this.totalWeight;
  }
}
