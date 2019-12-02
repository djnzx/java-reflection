package reflection;

import reflection.entity.Box;
import reflection.entity.Point2D;
import reflection.entity.StringHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * calling methods via reflection comprises the following steps:
 * 1. obtaining Class<T> variable                      via `Class.forName(className)`
 * 2. looking / picking up for appropriate constructor via `class.getConstructor(String.class)`
 * 3. creating an instance by the chosen constructor   via `constructor.newInstance("Hell")`
 * 4. looking / picking up for appropriate method      via `instance.getMethod("getX")`
 * 5. running a chosen method                          via `method.invoke(instance)`
 * 6. repeat steps 4 - 5
 * 7. enjoy handling exceptions :)
 *
 * https://habr.com/ru/post/318418/
 * https://www.tutorialspoint.com/javareflect/javareflect_method_invoke.htm
 */
public class ReflectionBasics {
  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
      InstantiationException, NoSuchMethodException, InvocationTargetException {
    // normal way
    Point2D p1 = new Point2D(10, 20);
    System.out.println(p1);
    System.out.println(p1.getX());

    // via reflection
    String classNameBox = "reflection.entity.Box";
    Class<?> boxClazz = Class.forName(classNameBox);
    Box box = (Box) boxClazz.newInstance();
    box.content = 33;
    System.out.println(box.content);
    System.out.println(box);

    String sh_name = "reflection.entity.StringHolder";
    Class<?> sh_class = Class.forName(sh_name);
    Constructor<?> sh_constructor = sh_class.getConstructor(String.class);
    StringHolder sh = (StringHolder) sh_constructor.newInstance("Hell");
    System.out.println(sh.content);

    String p2d_name = "reflection.entity.Point2D";
    Class<?> p2d_class = Class.forName(p2d_name);
    // accessing to constructors
    Constructor<?>[] constructors = p2d_class.getConstructors(); // getDeclaredConstructors();
    // declared vs all - declared in that class, all - also returns inherited constructors
    Constructor<?> p2d_constructor = p2d_class.getConstructor(int.class, int.class);
    Point2D p2 = (Point2D) p2d_constructor.newInstance(22, 33);
    System.out.println(p2);

    // accessing to methods
    Method[] methods = p2d_class.getMethods();
    Method m_getX = p2d_class.getMethod("getX");
    Integer x = (Integer) m_getX.invoke(p2); // 22
    System.out.println(x);
  }
}
