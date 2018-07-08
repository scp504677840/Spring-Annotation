package main;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 验证切面
 *
 * Order注解：指定切面的优先级。值越小，优先级越高。
 */
@Order(1)
@Aspect
@Component
public class VerificationAspect {

    /**
     * 前置通知
     * 当有切入点表达式时，尽量使用切入点表达式。
     *
     * @param joinPoint 切面点
     */
    @Before("main.LogAspect.declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("VerificationAspect 前置通知: " + name);
    }

}