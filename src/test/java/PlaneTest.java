import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
  private Plane plane;

  @Before
  public void setUp() {
    plane = new Plane(PlaneType.BOEING747);
  }

  @Test
  public void canGetPlaneType() {
    assertEquals(PlaneType.BOEING747, plane.getType());
  }

  @Test
  public void canGetCapacity() {
    assertEquals(400, plane.getCapacity());
  }

  @Test
  public void canGetTotalWeight() {
    assertEquals(800, plane.getTotalWeight());
  }
}
