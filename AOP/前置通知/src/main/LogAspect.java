package main;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
}
