package cn.itcast.java.annotation;

public @interface youAnnotation {
     String name() default "marry";
     int age() default 20;
     String gender() default "female";
}
