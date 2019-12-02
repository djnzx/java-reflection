package annotations.examples.fruits;

import annotations.examples.fruits.entity.Nameable;
import annotations.examples.fruits.entity.Ready;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import java.util.Set;
import java.util.function.Consumer;

public class FruitsAppOne {
  public static void main(String[] args) {
    Reflections r = new Reflections(new ConfigurationBuilder()
        .setScanners(new SubTypesScanner(false), new ResourcesScanner())
        .addUrls(ClasspathHelper.forJavaClassPath())
        .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("annotations/examples/fruits/entity")))
    );

    Set<Class<?>> subTypesOf = r.getSubTypesOf(Object.class);
    subTypesOf.forEach(new Consumer<Class<?>>() {
      @Override
      public void accept(Class<?> aClass) {
        if (aClass.isAnnotationPresent(Ready.class))
          if (aClass.getAnnotation(Ready.class).val() > 40) {
            System.out.printf("%s %s\n",aClass, aClass.getAnnotation(Ready.class).val());
          }
      }
    });
    subTypesOf.forEach(new Consumer<Class<?>>() {
      @Override
      public void accept(Class<?> aClass) {
        if(aClass.isAnnotationPresent(Ready.class)) {
          Ready annotation = aClass.getAnnotation(Ready.class);
          System.out.println("OWNER:"+annotation.owner());
          if (annotation.owner().equals("Dima")) {

          }
          if (annotation.val()>50) {
            System.out.println("Ready:"+annotation.val());
            System.out.println(aClass.getName());
            try {
              Nameable o = (Nameable)aClass.newInstance();
              System.out.println(o.name());
            } catch (InstantiationException e) {
              e.printStackTrace();
            } catch (IllegalAccessException e) {
              e.printStackTrace();
            }
          }
          System.out.println("---");
        }
      }
    });
  }
}
