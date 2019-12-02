package annotations.examples.fruits;

import annotations.examples.fruits.entity.Banana;
import annotations.examples.fruits.entity.Ready;

public class FruitsAppTwo {
  public static void main(String[] args) {
    Banana banana = new Banana();
    if (banana.getClass().isAnnotationPresent(Ready.class)) {
      Ready ann = banana.getClass().getDeclaredAnnotation(Ready.class);
      if (ann.owner().equals("Alex")) {
        //...
      }
    }
  }
}
