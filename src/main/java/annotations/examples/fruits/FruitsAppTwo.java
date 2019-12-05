package annotations.examples.fruits;

import annotations.examples.fruits.entity.Banana;
import annotations.examples.fruits.entity.Ripe;

public class FruitsAppTwo {
  public static void main(String[] args) {
    Banana banana = new Banana();
    if (banana.getClass().isAnnotationPresent(Ripe.class)) {
      Ripe ann = banana.getClass().getDeclaredAnnotation(Ripe.class);
      if (ann.owner().equals("Alex")) {
        //...
      }
    }
  }
}
