import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class APersonTest {
    public static void main1(String[] args) {
        for (java.lang.reflect.Field f : APerson.class.getDeclaredFields()) {
            Class type = f.getType(); // int
            String name = f.getName(); // id
            Annotation[] annotations = f.getDeclaredAnnotations();
            System.out.println("field:"+f);
            System.out.println("type:"+type);
            System.out.println("name:"+name);
            for (Annotation a : annotations) {
                Class<? extends Annotation> c = a.annotationType();
                System.out.println("c.getSimpleName():"+c.getSimpleName());
                java.lang.reflect.Field[] declaredFields = c.getDeclaredFields();
                System.out.println("DF:"+declaredFields);
                System.out.println(" a:"+a);
            }
            if (f.isAnnotationPresent(AnnField.class)) {
                AnnField ta = f.getAnnotation(AnnField.class);
                System.out.println("_key value:"+ta.key());
            }
        }
    }

    public static void main0(String[] args) {
        APerson p = new APerson(1, "Alex");
        p.print1();
        p.print2();
    }

    // method traverse and check whether annotation value set.
    public static void main2(String[] args) {
        APerson p = new APerson(1, "Alex");
        Method[] methods = p.getClass().getDeclaredMethods();
        for (Method m : methods) {
            System.out.printf("M: method name: %s\n",m);
            Annotation[] annotations = m.getDeclaredAnnotations();
            System.out.printf("M: annotations, attached to the method: %s\n", Arrays.toString(annotations));
            for (Annotation a : annotations) {
                System.out.printf(" A: annotation full name  : %s\n", a.annotationType().getName());
                System.out.printf(" A: annotation simple name: %s\n", a.annotationType().getSimpleName());
                System.out.printf(" A: method name           : %s\n", m.getName());
                // check if the method annotated by annotation "reflection.AnnMethod"
                if (m.isAnnotationPresent(AnnMethod.class)) {
                    System.out.println("  X1: found target annotation (AnnMethod)");
                    // checking annotation value
                    AnnMethod ta = m.getAnnotation(AnnMethod.class);
                    if (ta.smart()) {
                        System.out.printf("  X2: found target annotation (AnnMethod) with value `smart=true`: %s\n",ta.toString());
                        try {
                            Method method = p.getClass().getMethod(m.getName());
                            method.invoke(p);
                        }
                        catch (SecurityException ex1) {  }
                        catch (NoSuchMethodException ex2) {  }
                        catch (IllegalAccessException ex3) { }
                        catch (InvocationTargetException ex4) { }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        APerson p = new APerson(1, "Alex");
        try {
            Method met1 = p.getClass().getMethod("toString");
            Object invoked = met1.invoke(p);
            System.out.println(invoked);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) { }
    }

}
