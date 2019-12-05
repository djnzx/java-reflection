package annotations.examples.fruits;

import annotations.examples.fruits.entity.Bicycle;
import annotations.examples.fruits.entity.Rape;

public class FruitsAppThree {
  public static void main(String[] args) throws NoSuchMethodException {
    Bicycle b = new Bicycle();

    Rape a1 = b.getClass().getAnnotation(Rape.class);
    System.out.println(a1.val());
  }
}
