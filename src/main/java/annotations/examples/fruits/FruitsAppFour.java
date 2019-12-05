package annotations.examples.fruits;

import annotations.examples.fruits.entity.Nameable;
import annotations.examples.fruits.entity.Rape;
import annotations.examples.fruits.entity.Tasty;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class FruitsAppFour {
  public static void main(String[] args) {
    Reflections r = new Reflections(new ConfigurationBuilder()
        .setScanners(new SubTypesScanner(false), new ResourcesScanner())
        .addUrls(ClasspathHelper.forJavaClassPath())
        .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("annotations/examples/fruits/entity")))
    );
    Set<Class<?>> classes = r.getSubTypesOf(Object.class);
    classes.forEach(aClass -> {
      if (aClass.isAnnotationPresent(Rape.class)) { // 4 ....
        Rape meta = aClass.getAnnotation(Rape.class);
        if (meta.val() > 50) { // 2 : Apple , Banana
          System.out.printf("Fruit:%s, level:%d\n", aClass.getSimpleName(), meta.val());
          try {
            Method[] methods = aClass.getMethods();
            for (Method m: methods) {
              if (m.isAnnotationPresent(Tasty.class)){
                Constructor<?> c = aClass.getConstructor();
                Object o = c.newInstance();
                System.out.println("I've found it!!!");
                Object invoked = m.invoke(o);
                System.out.println(invoked.toString());
              }
            }
//            System.out.printf("name: %s\n", my_name);
          } catch (NoSuchMethodException e) {
            e.printStackTrace();
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          } catch (InstantiationException e) {
            e.printStackTrace();
          } catch (InvocationTargetException e) {
            e.printStackTrace();
          }
        }
      }
    });

  }
}
