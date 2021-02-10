package com.example.demothymeleaf.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    /*
     *这是一个切入点定义
     * *  表示  任意返回类型
     * com.example.demothymeleaf.services 表示该目录下
     * *表示任意类
     * *表示任意方法
     * (..)表示任意参数
     * */
    @Pointcut("execution(* com.example.demothymeleaf.services..*.*(..))")
    public void pc1() {
        //System.err.println("==我是切入点定义方法===");
    }

    @Before(value = "pc1()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        //System.err.println(name + "=====方法开始执行===");
    }

    @After(value = "pc1()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        //System.err.println(name + "=====方法结束执行===");
    }

    @AfterReturning(value = "pc1()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();
        //System.err.println(name + "=方法返回值为====afterReturning===result===" + result);
    }

    @AfterThrowing(value = "pc1()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        String name = jp.getSignature().getName();
        //System.err.println(name + "=方法抛出了异常=====afterThrowing=======e====" + e.getMessage());
    }

    /*
     * 表示一个环绕通知，环绕通知是所有通知里功能最强大的通知，可以实现前置通知， 后置通知，异常通知以及返回通知的功能，
     * 目标方法进入环绕通知后，通过调用proceedingJoinPoint对象的proceed方法使目标方法继续执行，开发者可以
     * 在此修改目标方法的执行参数，返回值等，并且可以在此处理目标方法的异常
     * */
    @Around(value = "pc1()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String name = pjp.getSignature().getName();
        //System.err.println(name + "=我是环绕通知=");

        long startTime = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        System.err.println(methodName + "方法执行了" + (endTime - startTime) + "ms");
        return obj;

    }
}
