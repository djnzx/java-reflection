package fruits;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Ready {
    int val() default 100;
    String owner() default "Alex";
}
