package annotations.examples.fruits;

import annotations.examples.fruits.entity.Bicycle;
import annotations.examples.fruits.entity.Ready;

public class FruitsAppThree {
  public static void main(String[] args) throws NoSuchMethodException {
    Bicycle b = new Bicycle();

    Ready a1 = b.getClass().getAnnotation(Ready.class);
    System.out.println(a1.val());
  }
}
