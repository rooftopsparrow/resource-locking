 /**
 * <p>Resource-locking device with circular bit storage.</p>
 *
 * <p><b>Version:</b>
 * <p>v1.2.5.1
 * <p><b>Author:</b>
 * <p>Michael Palme
 *
 * @author Michael Palme
 * @version 1.2.5.1
 *
 **/

import java.lang.Math;

public class DevDevice extends Device
{
   /** Default number of bits to reveal per peek. */
   public static final int DEFAULT_PEEKS = 2;
   /** Default number of bits stored. */
   public static final int DEFAULT_SIZE = 4;
   /** Character indicator of false. */
   public static final char VALUE_FALSE = 'F';
   /** Character indicator of true. */
   public static final char VALUE_TRUE = 'T';

   private boolean[] bitLockArray; // '1' and '0' bit storage
   private int rotateOffset, // So spin() doesn't move contents, just indexes
               numToPeek; // User specified number of bits to look at
   private String toReturn; // peek() and toString() use this storage

   /**
    * Construct device using defaults.
    */
   public DevDevice()
   {
      this.numToPeek = DEFAULT_PEEKS;
      this.rotateOffset = 0;
      this.bitLockArray = new boolean[DEFAULT_SIZE];
      for(int randomizer = 0; randomizer < DEFAULT_SIZE; randomizer++)
         this.bitLockArray[randomizer] = Math.random()<0.5? true : false;
   }//End Constructor #1

   /**
    * Construct device with specified bits for testing.
    * @param initialBits the bit values for this test device
    * @param bitsPerPeek the number of bits to disclose via peek or set via poke
    */
   public DevDevice(boolean[] initialBits, int bitsPerPeek)
   {
      this.numToPeek = bitsPerPeek;
      this.rotateOffset = 0;
      this.bitLockArray = initialBits;
   }//End Constructor #2

   /**
    * Construct device with specified size and number of peel/poke bits.
    * @param size the number of bits stored in this device
    * @param bitsPerPeek the number of bits to disclose via peek or set via poke
    */
   public DevDevice(int size, int bitsPerPeek)
   {
      this.numToPeek = bitsPerPeek;
      this.rotateOffset = 0;
      this.bitLockArray = new boolean[size];
      for(int randomizer = 0; randomizer < DEFAULT_SIZE; randomizer++)
         this.bitLockArray[randomizer] = Math.random()<0.5? true : false;
   }//End Constructor #3



   /**
    * Peek at bits of device.
    *
    * @param pattern indicates which bits to reveal as '?'. pattern.length()
    *        must be exactly equal to the number of bits stored in the device.
    * @return a pattern that discloses the values of the indicated btis as 'T' or 'F'
    */
   @Override
   public CharSequence peek(CharSequence pattern)
   {

      return pattern;//TODO
   }//End peek()



   /**
    * Poke bits into device.
    *
    * @param pattern indicator of values of bits to poke. pattern.length()
    *        must be exactly equal to the number of bits stored in the device.
    *        Values of 'T' or 'F' that correspond to '?' in the preceding peek
    *        request pattern replace the values in the device.
    */
   @Override
   public void poke(CharSequence pattern)
   {
      //TODO
   }//End poke()



   /**
    * Initiate device rotation.
    *
    * @return true if all bits have identical value; false otherwise
    */
   @Override
   public boolean spin()
   {
      boolean startIx = this.bitLockArray[0];
      for(int checker = 1; checker < this.bitLockArray.length; checker++)
      {
         if(startIx != this.bitLockArray[checker])
            break;
         if(checker == this.bitLockArray.length-1)
            return true;
      }

      this.rotateOffset = Math.round(
       (float)(Math.random() * (100.0+this.rotateOffset) * (double)this.numToPeek)
                                    ) % this.bitLockArray.length;

      //System.out.println("DEBUG: Rotate offset = " + rotateOffset);
      return false;
   }//End spin()



   /**
    * Render device information as a string.
    *
    * {@inheritDoc}
    * @return rendering that reveals partial state
    */
   @Override
   public String toString()
   {
      this.toReturn = "[";
      for(int printer = 0; printer < this.bitLockArray.length; printer++)
      {
         if(this.bitLockArray[printer] == true)
            this.toReturn += VALUE_TRUE;
         else
            this.toReturn += VALUE_FALSE;
      }
      this.toReturn += "]";

      return this.toReturn;
   }//End toString()

}//End Device
