package annotations.examples.person;

import annotations.examples.fruits.entity.Nameable;
import annotations.examples.fruits.entity.Ready;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Consumer;

public class APersonTest {
    // classic
    public static void main0(String[] args) {
        APerson p = new APerson(1, "Alex");
        p.print1();
        p.print2();
    }

    // running method by name
    public static void main1(String[] args) {
        APerson p = new APerson(1, "Alex");
        try {
            Method met1 = p.getClass().getMethod("toString");
            Object invoked = met1.invoke(p);
            System.out.println(invoked);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) { }
    }

    // method traverse and check whether annotation value set.
    public static void main(String[] args) {
        //annotations.examples.person.APerson p = new annotations.examples.person.APerson(1, "Alex");
        //Method[] methods = p.getClass().getDeclaredMethods();
        Method[] methods = APerson.class.getDeclaredMethods();
        for (Method m : methods) {
            System.out.printf("M: method name: %s\n",m);
            Annotation[] annotations = m.getDeclaredAnnotations();
            System.out.printf("M: annotations, attached to the method: %s\n", Arrays.toString(annotations));
            for (Annotation a : annotations) {
                System.out.printf(" A: annotation full name  : %s\n", a.annotationType().getName());
                System.out.printf(" A: annotation simple name: %s\n", a.annotationType().getSimpleName());
                System.out.printf(" A: method name           : %s\n", m.getName());
                // check if the method annotated by annotation "reflection.annotations.examples.person.AnnMethod"
                if (m.isAnnotationPresent(AnnMethod.class)) {
                    System.out.println("  X1: found target annotation (annotations.examples.person.AnnMethod)");
                    // checking annotation value
                    AnnMethod ta = m.getAnnotation(AnnMethod.class);
                    if (ta.smart()) {
                        System.out.printf("  X2: found target annotation (annotations.examples.person.AnnMethod) with value `smart=true`: %s\n",ta.toString());
                        try {
                            Constructor<APerson> constructor = APerson.class.getConstructor(Integer.class, String.class);
                            APerson p = constructor.newInstance(111, "Smart Alex");
                            Method method = p.getClass().getMethod(m.getName());
                            method.invoke(p);
                        }
                        catch (SecurityException ex1) {
                            ex1.printStackTrace();
                        }
                        catch (NoSuchMethodException ex2) {
                            ex2.printStackTrace();
                        }
                        catch (IllegalAccessException ex3) {
                            ex3.printStackTrace();
                        }
                        catch (InvocationTargetException ex4) {
                            ex4.printStackTrace();
                        }
                        catch (InstantiationException ex5) {
                            ex5.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main3(String[] args) {
        Reflections r = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
                .addUrls(ClasspathHelper.forJavaClassPath())
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("annotations/examples/fruits/entity")))
        );

        Set<Class<?>> subTypesOf = r.getSubTypesOf(Object.class);
        subTypesOf.forEach(new Consumer<Class<?>>() {
            @Override
            public void accept(Class<?> aClass) {
                if(aClass.isAnnotationPresent(Ready.class)) {
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
            }
        });
    }
}
