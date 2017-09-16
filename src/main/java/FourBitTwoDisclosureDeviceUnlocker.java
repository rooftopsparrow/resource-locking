
/**
 * Solution development for 4-bit/2-disclosure device.
 *
 * @version 4.1.5
 * @author Dr. Jody Paul
 * @author Heather DeMarco
 */

public class FourBitTwoDisclosureDeviceUnlocker extends DeviceUnlocker {
    public static void main(String[] args) {
        Device dev = new Device(4, 2);

        boolean f = unlock(dev);
        System.out.println(f);
    }
    /**
     *Unlocks a resource controlled by a 4-bit/2-disclosure device. Behavior is unspecified if parameter is not a reference to a valid 4-bit/2-disclosure device.
     *
     * @param  dev - the device controlling the resource to unlock; must be a 4-bit device with 2 peek/poke bits.
     * @return  true if the resource is successfully unlocked (all bits are now identical); false otherwise
     */
    public static boolean unlock(Device dev){
        boolean forSpin;
        CharSequence forPeek = "??--";
        CharSequence forPoke = "TT--";

        for(int i=0; i <= 100; i++) {
            forSpin = dev.spin();

            if (forSpin)
                return true;

            CharSequence p = dev.peek(forPeek);

            System.out.println(i + p.toString());

            dev.poke(forPoke);

        }
        return false;
    }

}
