package com.uyghur.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    @Before("execution(public void add*())")
    @Pointcut("execution(* com.uyghur.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){

    }

    @Pointcut("execution(* com.uyghur.aopdemo.dao.*.get*(..))")
    private void getter(){

    }


    @Pointcut("execution(* com.uyghur.aopdemo.dao.*.set*(..))")
    private void setter(){

    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){

    }




    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n===========>>> Executing @Before advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n==========>>> Performing API analytics");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void logToCloudAsync(){
        System.out.println("\n==========>>> Logging to cloud in async fashion");
    }
}
