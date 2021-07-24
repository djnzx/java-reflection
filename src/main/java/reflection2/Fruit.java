package reflection2;

public class Fruit {

  @Good(level = 70)
  String name;

  @Ugly
  Integer size;

  @Bad
  @Ugly
  String owner;

  public Fruit(String name) {
    this.name = name;
  }

}
