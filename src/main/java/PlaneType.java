public enum PlaneType {
  TEST(2, 4),
  BOEING737(60, 180),
  BOEING747(400, 800),
  BOEING767(500, 1200),
  BOEING777(600, 1200),
  AIRBUSA220(100, 300),
  AIRBUSA319(200, 400),
  AIRBUSA330(500, 800);

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
