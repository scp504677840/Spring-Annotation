package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    /**
     * 1.书写ArithmeticCalculator接口
     * 2.书写ArithmeticCalculatorImpl，并加上@Component注解或在配置类中注册Bean
     * 3.下载AspectJ的jar包并加入工程依赖
     * 4.书写LogAspect并加上@Aspect注解，并加上@Component注解或中配置类中注册Bean
     * 5.书写配置类加上@EnableAspectJAutoProxy注解
     *
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        //注意：我们在此故意制造异常，来验证后置通知是否不受异常干扰继续执行。
        double result = arithmeticCalculator.add(1, 2);
        System.out.println(result);

        //前置通知： add
        //java.lang.ArithmeticException: / by zero
        //异常通知： add
        //Exception in thread "main" java.lang.RuntimeException: java.lang.ArithmeticException: / by zero
        //LogAspect 异常通知： divide --- java.lang.ArithmeticException: / by zero
        //	... 15 more
    }
}
