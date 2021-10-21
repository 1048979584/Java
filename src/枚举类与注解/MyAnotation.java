package 枚举类与注解;


import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;


@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
@interface MyAnnotation {

    String value() default "hello";

}
