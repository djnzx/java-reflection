package fruits;

public class App {
  public static void main(String[] args) throws ClassNotFoundException {
    Class<?> class1 = Class.forName("fruits.Apple");
    boolean is1 = class1.isAnnotationPresent(Ready.class);
    System.out.println(is1);
    Ready ready1 = class1.getDeclaredAnnotation(Ready.class);
    System.out.println(ready1.value());

    Class<?> class2 = Class.forName("fruits.Plum");
    boolean is2 = class2.isAnnotationPresent(Ready.class);
    System.out.println(is2);
    Ready ready2 = class2.getDeclaredAnnotation(Ready.class);
    System.out.println(ready2.value());
  }
}
