package refl1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Application {

  public static void main1(String[] args) {
    Person jim = new Person("jim");
  }

  public static void main2(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
    String className = "refl1.Person";

    Class<?> clazz = Class.forName(className);
    Constructor<?>[] constructors = clazz.getDeclaredConstructors();
    for (Constructor<?> c: constructors) {
      int parameterCount = c.getParameterCount();
      if (parameterCount == 1) {
        Person jim = (Person) c.newInstance("Jim");
        System.out.println(jim.name);
      }
    }
  }

  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    String className = "refl1.Person";

    Class<?> clazz = Class.forName(className);
    Constructor<?> c = clazz.getDeclaredConstructor(String.class);
    Person jim = (Person) c.newInstance("Jim");
    System.out.println(jim.name);
  }

}
