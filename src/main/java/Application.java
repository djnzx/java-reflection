import fruits.Banana;
import fruits.Ready;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Banana banana = new Banana();
        ArrayList<Banana> al = new ArrayList<>();
        if (banana.getClass().isAnnotationPresent(Ready.class)) {
            Ready ann = banana.getClass().getDeclaredAnnotation(Ready.class);
            if (ann.owner().equals("Alex")) {
                al.add(banana);
            }
        }
    }
}
