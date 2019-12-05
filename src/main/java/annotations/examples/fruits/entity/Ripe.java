package annotations.examples.fruits.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Ripe {
  int val();
  String owner() default "Alex";
}
