package main;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 日志切面
 * 1.加入Aspect切面
 *
 * Order注解：指定切面的优先级。值越小，优先级越高。
 */
@Order(2)
@Aspect
@Component
public class LogAspect {

    /*try {
        //前置通知
        int result = 1 + 2;
        //返回通知
    } catch (NullPointerException e) {
        //异常通知
    }
    //后置通知*/

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
     * 切入点表达式
     * 1.该方法体中不应再有其他代码。
     * 2.使用@Pointcut注解来声明切入点表达式。
     */
    @Pointcut("execution(public double main.ArithmeticCalculator.*(double ,double ))")
    public void declareJointPointExpression(){}

    /**
     * 前置通知：在目标方法开始前执行。
     *
     * @param joinPoint 连接点，该参数可以省略。
     */
    @Before("declareJointPointExpression()")
    public void beforeLog(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("LogAspect 后置通知: " + name + " --- " + args);
        //LogAspect beforeLog: add --- [1.0, 2.0]
    }

    /**
     * 后置通知
     * 1.无论目标执行的方法是否发生异常，后置通知都将执行。
     * 2.在后置通知中还不能获取到目标方法执行的结果，要想获取结果可以在返回通知中获取。
     *
     * @param joinPoint 切面点
     */
    @After("declareJointPointExpression()")
    public void afterLog(JoinPoint joinPoint) {
        System.out.println("LogAspect 前置通知");
    }

    /**
     * 返回通知
     * 1.可以获取方法的返回值。
     *
     * @param joinPoint 切面点
     * @param result    返回值
     */
    @AfterReturning(value = "declareJointPointExpression()", returning = "result")
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
    @AfterThrowing(value = "declareJointPointExpression()", throwing = "e")
    public void afterThrowingLog(JoinPoint joinPoint, Exception e) {
        String name = joinPoint.getSignature().getName();
        System.out.println("LogAspect 异常通知： " + name + " --- " + e.getMessage());
    }

    /**
     * 环绕通知
     * 1.必须有ProceedingJoinPoint参数
     * 2.环绕通知类似于动态代理当全过程。
     * 3.ProceedingJoinPoint可以决定目标方法是否执行。（proceedingJoinPoint.proceed();）
     * 4.环绕通知必须要有返回值。
     * 5.返回值为目标的方法执行的返回值。
     *
     * @param proceedingJoinPoint 继续执行切面点
     * @return 环绕通知必须要有返回值。返回值为目标的方法执行的返回值。
     */
    /*@Around("declareJointPointExpression()")
    public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        String name = proceedingJoinPoint.getSignature().getName();
        try {
            //前置通知
            System.out.println("前置通知： " + name);
            result = proceedingJoinPoint.proceed();
            System.out.println("返回通知： " + name);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //异常通知
            System.out.println("异常通知： " + name);
            //如遇到异常，可抛。
            throw new RuntimeException(throwable);
        }
        //后置通知
        System.out.println("后置通知： " + name);
        return result;
    }*/


}