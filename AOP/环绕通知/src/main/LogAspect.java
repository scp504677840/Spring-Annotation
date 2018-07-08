package main;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 日志切面
 * 1.加入Aspect切面
 */
@Aspect
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
    @Around("execution(public double main.ArithmeticCalculator.add(double ,double ))")
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
    }

}
