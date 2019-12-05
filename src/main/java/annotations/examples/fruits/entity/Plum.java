package annotations.examples.fruits.entity;

@Ripe(val = 10)
public class Plum implements Nameable {
  @Override
  public String name() {
    return "I'm Plum";
  }
}
