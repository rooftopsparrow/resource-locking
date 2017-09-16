/**
 * Make spin return false always
 */
class UnfairTestDevice extends Device {
  @Override
  public boolean spin() {
   return false;
  }
  @Override
  public CharSequence peek(CharSequence c) {
    return "FF--";
  }
}
