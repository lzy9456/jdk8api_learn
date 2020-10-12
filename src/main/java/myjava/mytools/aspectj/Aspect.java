package myjava.mytools.aspectj;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author _lizy
 * @version 1.0
 * @description //TODO Aspect与lombok冲突，未解决
 * @date 2020/10/12 20:15
 */
//@Slf4j
@org.aspectj.lang.annotation.Aspect
public class Aspect {


    /**
     * @Description
     *    execution(* myjava..*.*.*MT(..)) -> myjava包下所有类中，以MT为后缀的方法
     *    第一个*，返回类型
     *    myjava..*,myjava下所有包
     *    .*,所有类
     *    .*MT(..),所有MT后缀的方法
     */
    @Pointcut("execution(* myjava..*.*.*MT(..))")
    private void pointcut() {}  // signature



    /**
     * @Description
     *     切入点前后，打印方法名
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("START**********"+joinPoint.toShortString()+"**********");

        long t1 = System.currentTimeMillis();
        Object o = joinPoint.proceed();     //执行下一个切面方法,若无则执行目标方法
        long t2 = System.currentTimeMillis();

        System.out.println("END**********"+joinPoint.toShortString()+" > execute time:"+(t2-t1)+"\r\n");
        return o;
    }




//    @Before("pointcut()")
//    public void before(JoinPoint joinPoint) throws NoSuchMethodException {
//        log.info("START**********"+method.getName()+"**********");
//        System.out.println("**********"+joinPoint.toShortString()+"**********");
//        log.info("END**********"+getClassAndMethodName(method)+" > execute time:"+(t2-t1));
//    }

}
