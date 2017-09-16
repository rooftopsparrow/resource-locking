/**
 * Make spin return false always
 */
class UnfairTestDevice extends Device {
  public boolean spin() {
   return false;
  }
  public CharSequence peek(CharSequence c) {
    return "FF--";
  }
}
