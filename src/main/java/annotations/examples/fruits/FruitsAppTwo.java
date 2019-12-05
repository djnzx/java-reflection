package annotations.examples.fruits;

import annotations.examples.fruits.entity.Banana;
import annotations.examples.fruits.entity.Rape;

public class FruitsAppTwo {
  public static void main(String[] args) {
    Banana banana = new Banana();
    if (banana.getClass().isAnnotationPresent(Rape.class)) {
      Rape ann = banana.getClass().getDeclaredAnnotation(Rape.class);
      if (ann.owner().equals("Alex")) {
        //...
      }
    }
  }
}
