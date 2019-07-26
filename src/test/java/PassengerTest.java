import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {
  private Passenger passenger;

  @Before
  public void setUp() {
    passenger = new Passenger("Joe", 2);
  }

  @Test
  public void canGetName() {
    assertEquals("Joe", passenger.getName());
  }

  @Test
  public void canGetNoOfBags() {
    assertEquals(2, passenger.getNoOfBags());
  }
}
