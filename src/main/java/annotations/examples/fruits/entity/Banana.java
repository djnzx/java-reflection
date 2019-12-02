package annotations.examples.fruits.entity;

@Ready (val = 45)
@Tasty (level = 500)
public class Banana implements Nameable {
  @Override
  public String name() {
    return "I'm Banana";
  }
}
