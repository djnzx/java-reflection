package reflection2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {

  public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException, NoSuchFieldException {
    // =======================================
    Apple apple = new Apple();
    apple.represent1();

    // =======================================
    Class<? extends Apple> clazz = Apple.class;
    Constructor<?>[] constructors = clazz.getConstructors();
    for (Constructor c: constructors) {
      if (c.getParameterCount() == 0) {
        Apple a = (Apple) c.newInstance();
        System.out.println(a);
      }
    }
    // =======================================
    Constructor<? extends Apple> c2 = clazz.getConstructor(Integer.class, String.class);
    Apple apple2 = c2.newInstance(33, "red");
    System.out.println(apple2);

    // =======================================
    ClassLoader classLoader = Application.class.getClassLoader();
    Class<?> clazz3 = classLoader.loadClass("reflection2.Apple");
    Apple green44 = (Apple) clazz3.getConstructor(Integer.class, String.class)
      .newInstance(44, "green");
    System.out.println(green44);
    Method[] methods = green44.getClass().getDeclaredMethods();
    for (Method m: methods) {
      if (m.getName().equals("represent2")) {
        String result = (String) m.invoke(green44);
        System.out.println(result);
      }
      System.out.println(m);
    }
    Field count = green44.getClass().getDeclaredField("count");
    count.setAccessible(true);
    count.setInt(green44, 99);
    System.out.println();
    System.out.println(green44);
  }
}
