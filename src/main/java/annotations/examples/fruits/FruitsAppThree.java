package annotations.examples.fruits;

import annotations.examples.fruits.entity.Bicycle;
import annotations.examples.fruits.entity.Ripe;

public class FruitsAppThree {
  public static void main(String[] args) throws NoSuchMethodException {
    Bicycle b = new Bicycle();

    Ripe a1 = b.getClass().getAnnotation(Ripe.class);
    System.out.println(a1.val());
  }
}
