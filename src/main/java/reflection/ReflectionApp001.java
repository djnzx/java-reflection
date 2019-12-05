package reflection;

import annotations.explanation.step1.Good;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Good(author = "Alex")
public class ReflectionApp001 {
  @Dirty
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    // programming
    Point3D point3D = new Point3D(1, 2, 3);
    point3D.printMe();
    // nifty-gritty
    String class_name = "reflection.Point3D";
    Class<?> aClass = Class.forName(class_name);
    Constructor<?> constructor3 = aClass.getConstructor(int.class, int.class, int.class);
    Constructor<?> constructor0 = aClass.getConstructor();
    Point3D p2 = (Point3D) constructor3.newInstance(10, 20, 30);
    Point3D p3 = (Point3D) constructor0.newInstance();
    String method_name = "printMe";
    p2.printMe();
    p3.printMe();
    Method method = aClass.getMethod(method_name);
    System.out.println("call via `method.invoke`");
    method.invoke(p2);


  }
}
