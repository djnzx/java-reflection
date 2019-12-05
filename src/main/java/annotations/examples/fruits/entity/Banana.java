package annotations.examples.fruits.entity;

@Rape(val = 80)
public class Banana implements Nameable {

  @Tasty (level = 999)
  @Override
  public String name() {
    return "I'm Banana";
  }
}
