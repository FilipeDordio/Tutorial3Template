package pt.pa.adts.queue;

public class NullNotAllowedException extends RuntimeException {
    public NullNotAllowedException() {
        throw new UnsupportedOperationException("Null elements aren't allowed");
    }

  public NullNotAllowedException(String message) {
    throw new UnsupportedOperationException(message);
  }
}
