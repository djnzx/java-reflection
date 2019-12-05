package annotations.explanation.step1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Good {
  String author();
  boolean interesting() default false;
}
