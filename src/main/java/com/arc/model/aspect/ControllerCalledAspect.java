package com.arc.model.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerCalledAspect {

    @Before("execution(* com.arc.controller.BaseController.*(..)) || execution(* com.arc.controller.*.*Controller.*(..))")
    public void showControllerAndMethodName(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getDeclaringType().getSimpleName() + " called, method " + joinPoint.getSignature().getName());
    }

    @Pointcut("@within(org.springframework.web.bind.annotation.RequestMapping)")
    public void getRequestMappedMethods() {

    }

    @Around("getRequestMappedMethods()")
    public Object handle(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(pjp.getSignature().getDeclaringType().getSimpleName() + " was handled, method name " + pjp.getSignature().getName());
        return pjp.proceed();
    }
}
