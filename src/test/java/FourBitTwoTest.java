/**
 * Tests for FourBitTwoDisclosureDeviceUnlocker
*/
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

public class FourBitTwoTest {

  static final boolean USEDEVDEVICE = false;

  static Device buildDevice(boolean[] init, int bits) {
    if (USEDEVDEVICE) {
      return new DevDevice(init, bits);
    } else {
      return new Device(init, bits);
    }
  }

  static Device buildDevice() {
    if (USEDEVDEVICE) {
      return new DevDevice();
    } else {
      return new Device();
    }
  }

  @Test public void testItUnlocksTheDeviceWithAllTrue() {
    boolean[] init = {true, true, true, true};
    Device d = FourBitTwoTest.buildDevice(init, 2);
    assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(d));
    String trace = FourBitTwoDisclosureDeviceUnlocker.showTrace();
    assertThat(trace, containsString("SUCCESS"));
    System.out.println("TRACE:\n" + trace);
  }

  @Test public void testItUnlocksTheDeviceWithAllFalse() {
    boolean[] init = {false, false, false, false};
    Device d = FourBitTwoTest.buildDevice(init, 2);
    assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(d));
    String trace = FourBitTwoDisclosureDeviceUnlocker.showTrace();
    assertThat(trace, containsString("SUCCESS"));
    System.out.println("TRACE:\n" + trace);
  }

  @Test public void testItUnlocksTheDeviceWhenSetRandomBits() {
    Device d = FourBitTwoTest.buildDevice();
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
