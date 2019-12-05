package annotations.examples.fruits.entity;

@Ripe(val = 80)
public class Banana implements Nameable {

  @Tasty (level = 999)
  @Override
  public String name() {
    return "I'm Banana";
  }
}
