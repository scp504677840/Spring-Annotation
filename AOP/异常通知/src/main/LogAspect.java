package main;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 日志切面
 * 1.加入Aspect切面
 */
@Aspect
public class LogAspect {

    //第一处省略：修饰符 + 【返回值类型】；其中返回值类型可以单独省略，但修饰符不行。例如：public *，但不可以：* double
    //第二处省略：类名称；
    //第三处省略：方法名称；
    //第四处省略：参数类型列表；
    //@Before("execution(* main.ArithmeticCalculator.add(double ,double ))")
    //@Before("execution(* main.ArithmeticCalculator.*(double ,double ))")
    //@Before("execution(* main.ArithmeticCalculator.add(.. ))")
    //@Before("execution(* main.ArithmeticCalculator.*(double ,.. ))")
    //@Before("execution(* main.ArithmeticCalculator.*(.. ))")
    //@Before("execution(* main.*.*(.. ))")

    /**
     * 前置通知：在目标方法开始前执行。
     *
     * @param joinPoint 连接点，该参数可以省略。
     */
    @Before("execution(public double main.ArithmeticCalculator.*(double ,double ))")
    public void beforeLog(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("LogAspect beforeLog: " + name + " --- " + args);
        //LogAspect beforeLog: add --- [1.0, 2.0]
    }

    /**
     * 后置通知
     * 1.无论目标执行的方法是否发生异常，后置通知都将执行。
     * 2.在后置通知中还不能获取到目标方法执行的结果，要想获取结果可以在返回通知中获取。
     */
    @After("execution(public double main.ArithmeticCalculator.add(double ,double ))")
    public void afterLog(){
        System.out.println("LogAspect 后置通知");
    }

    /**
     * 返回通知
     * 1.可以获取方法的返回值。
     * 2.JoinPoint必须是第一个参数。
     */
    @AfterReturning(value = "execution(public double main.ArithmeticCalculator.add(double ,double ))", returning = "result")
    public void afterReturningLog(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println("LogAspect 返回通知: " + name + " --- " + result);
    }

    /**
     * 异常通知
     * 注意：
     * throwing参数可以指定异常。
     * 1.Exception：接受所有异常。
     * 2.NullPointerException：只有接受到NullPointerException才会执行。当不是NullPointerException时不执行。
     *
     * @param joinPoint 切面点
     * @param e         异常
     */
    @AfterThrowing(value = "execution(public double main.ArithmeticCalculator.add(double ,double ))", throwing = "e")
    public void afterThrowingLog(JoinPoint joinPoint, Exception e) {
        String name = joinPoint.getSignature().getName();
        System.out.println("LogAspect 异常通知： " + name + " --- " + e.getMessage());
    }
}
