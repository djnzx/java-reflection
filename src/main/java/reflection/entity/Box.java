package reflection.entity;

public class Box {
  public int content;

  @Override
  public String toString() {
    return String.format("Box{content=%d}", content);
  }
}
