/**
 * Tests for FourBitTwoDisclosureDeviceUnlocker
*/
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;



public class FourBitTwoTest {

  @Test public void testItUnlocksTheDeviceWithAllTrue() {
    boolean[] init = {true, true, true, true};
    Device d = new Device(init, 2);
    assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(d));
    String trace = FourBitTwoDisclosureDeviceUnlocker.showTrace();
    assertThat(trace, containsString("SUCCESS"));
    System.out.println("TRACE:\n" + trace);
  }

  @Test public void testItUnlocksTheDeviceWithAllFalse() {
    boolean[] init = {false, false, false, false};
    Device d = new Device(init, 2);
    assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(d));
    String trace = FourBitTwoDisclosureDeviceUnlocker.showTrace();
    assertThat(trace, containsString("SUCCESS"));
    System.out.println("TRACE:\n" + trace);
  }

  @Test public void testItUnlocksTheDeviceWhenSetRandomBits() {
    Device d = new Device();
    assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(d));
    String trace = FourBitTwoDisclosureDeviceUnlocker.showTrace();
    assertThat(trace, containsString("SUCCESS"));
    System.out.println("TRACE:\n" + trace);
  }

  @Test public void testItFailsToUnlockWhenItsUnfair() {
    UnfairTestDevice d = new UnfairTestDevice();
    assertFalse(FourBitTwoDisclosureDeviceUnlocker.unlock(d));
    String trace = FourBitTwoDisclosureDeviceUnlocker.showTrace();
    assertThat(trace, containsString("FAILED"));
    System.out.println("TRACE:\n" + trace);
  }

}
