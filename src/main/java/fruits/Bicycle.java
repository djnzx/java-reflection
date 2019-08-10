package fruits;

import java.lang.reflect.Method;

@Ready(val = 50)
public class Bicycle {

    @Ready(val = 1)
    int wheel_count;

    @Ready(val = 30)
    void print() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Bicycle b = new Bicycle();

        Ready a1 = b.getClass().getAnnotation(Ready.class);
        System.out.println(a1.val());

//        Method print = b.getClass().getMethod("print");
//        Ready a2 = print.getAnnotation(Ready.class);
//        System.out.println(a2.val());
    }
}
