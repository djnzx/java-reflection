package reflection.entity;

public class Point2D {
  private final int x;
  private final int y;

  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public String toString() {
    return String.format("Point:[%d:%d]", x, y);
  }
}
