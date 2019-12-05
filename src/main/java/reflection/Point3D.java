package reflection;

public class Point3D {
  private final int x;
  private final int y;
  private final int z;

  public Point3D() {
    this(11,22,33);
  }

  public Point3D(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getZ() {
    return z;
  }

  @Override
  public String toString() {
    return String.format("[%d:%d:%d]", x, y, z);
  }

  public void printMe() {
    System.out.println(toString());
  }

}
