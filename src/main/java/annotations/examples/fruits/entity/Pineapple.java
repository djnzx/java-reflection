package annotations.examples.fruits.entity;

@Ripe(val = 30)
public class Pineapple implements Nameable {
  @Override
  public String name() {
    return "I'm Pineapple";
  }
}
