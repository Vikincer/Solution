package pers.rokin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    /*
    * 元注解是可以注解到注解上的注解，或者说元注解是一种基本注解，它能够应用到其它的注解上面。
       元标签有 @Retention、
       * 中文释义保留期的意思
            当@Retention应用到注解上的时候，它解释说明了这个注解的生命周期。
            RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。
            RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到JVM中。
            RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载到JVM中。
            *
       * @Documented、
       * 顾名思义，这个元注解肯定和文档有关。它的作用是能够将注解中的元素包含到Javadoc中去。
       *
       * @Target、
       * 标明注解运用的地方。
            ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
            ElementType.CONSTRUCTOR 可以给构造方法进行注解
            ElementType.FIELD 可以给属性进行注解
            ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
            ElementType.METHOD 可以给方法进行注解
            ElementType.PACKAGE 可以给一个包进行注解
            ElementType.PARAMETER 可以给一个方法内的参数进行注解
            ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举
       *
       * @Inherited、
       * lnherited是继承的意思。
            如果一个超类被@Inherited注解过的注解进行注解的话，那么如果它的子类没有被任何注解应用的话
            那么这个子类就继承了超类的注解。
       *
       * * @Repeatable
       * Repeatable 自然是可重复的意思。@Repeatable 是 Java 1.8 才加进来的，所以算是一个新的特性。
            什么样的注解会多次应用呢？通常是注解的值可以同时取多个。
            在生活中一个人往往是具有多种身份，如果我把每种身份当成一种注解该如何使用？？？
    * */

@Retention(RetentionPolicy.RUNTIME)//注解可以保留到程序运行时，加载到JVM中
@Target(ElementType.TYPE)//给一个类型进行注解，比如类、接口、枚举
@Inherited //子类继承父类时，注解会起作用
public @interface MyAnnotation {

    enum Color {
        White,Grayish,Yellow
    }
    // 默认颜色是白色的
    Color c() default Color.White;
}
