package annotations.examples.fruits.entity;

@Ready (val = 1)
public class Plum implements Nameable {
  @Override
  public String name() {
    return "I'm Plum";
  }
}
