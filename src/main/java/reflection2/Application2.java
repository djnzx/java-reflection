package reflection2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Application2 {

  public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException, NoSuchFieldException {
    // =======================================
    Fruit fruit = new Fruit("apple");

    Field[] fs = fruit.getClass().getDeclaredFields();
    for (Field f : fs) {
      Annotation[] as = f.getAnnotations();
      if (f.isAnnotationPresent(Good.class)) {
        Good annotation = f.getAnnotation(Good.class);
        if (annotation.level() > 50) {
          System.out.println(annotation.level());
        }
      }


      System.out.printf("field %s has annotations: %s\n", f.getName(), Arrays.toString(as));
    }
  }
}
