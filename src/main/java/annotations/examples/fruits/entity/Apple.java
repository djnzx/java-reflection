package annotations.examples.fruits.entity;

@Ripe(owner = "Dima", val = 90)
public class Apple implements Nameable {
  @Override
  public String name() {
    return "I'm Apple";
  }

  @Tasty(level = 1)
  public String newImpl(){
    return "SuperTasty";
  }
}
