
/**
 * Solution development for 4-bit/2-disclosure device.
 *
 * @version 4.1.5
 * @author Dr. Jody Paul
 * @author Heather DeMarco
 */

public class FourBitTwoDisclosureDeviceUnlocker extends DeviceUnlocker {
    /**
     * Unlocks a resource controlled by a 4-bit/2-disclosure device. Behavior is
     * unspecified if parameter is not a reference to a valid 4-bit/2-disclosure device.
     *
     * @param  dev - the device controlling the resource to unlock;
     * must be a 4-bit device with 2 peek/poke bits.
     * @return  true if the resource is successfully unlocked (all bits are now identical);
     * false otherwise
     */
    public static boolean unlock(Device dev){
        //Set up variables
        boolean forSpin;
        CharSequence forPeek = "??--";
        CharSequence forPoke = "TT--";
        CharSequence fromPeek;

        // Reset the trace
        FourBitTwoDisclosureDeviceUnlocker.log(null);

        // We're staring the unlock
        FourBitTwoDisclosureDeviceUnlocker.log("Unlock start");

        //The loop is set to run 100 times before halting.
        for (int i = 0; i <= 100; i++) {
            forSpin = dev.spin();

            //If true, loop is exited
            if (forSpin) {
                FourBitTwoDisclosureDeviceUnlocker.log("Spin: unlocked");
                FourBitTwoDisclosureDeviceUnlocker.log("Unlock SUCCESS");
                return true;
            }

            FourBitTwoDisclosureDeviceUnlocker.log("Spin: locked");
            FourBitTwoDisclosureDeviceUnlocker.log("Peek pattern: " + forPeek.toString());

            fromPeek = dev.peek(forPeek);
            FourBitTwoDisclosureDeviceUnlocker.log("Peek result: " + fromPeek.toString());

            FourBitTwoDisclosureDeviceUnlocker.log("Poke: " + forPoke.toString());
            dev.poke(forPoke);

            FourBitTwoDisclosureDeviceUnlocker.log(dev.toString());

        }
        FourBitTwoDisclosureDeviceUnlocker.log("Unlock FAILED");
        return false;
    }

}
