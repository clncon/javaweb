package cn.itcast.java.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBInfo {
      String driver() default "com.mysql.jdbc.Driver" ;
      String url() default "jdbc:mysql://127.0.0.1/bbs";
      String user() default "root";
      String password() default "root";
}
