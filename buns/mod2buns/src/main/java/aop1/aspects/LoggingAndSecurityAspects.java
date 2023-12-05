package aop1.aspects;

import aop1.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspects {

    @Pointcut("execution(* aop1.UniLibrary.get*(..))")
    private void allGetMethods() {}

    @Pointcut("execution(* aop1.UniLibrary.return*(..))")
    private void allReturnMethods() {}

    @Pointcut("allGetMethods() && !allReturnMethods()")
    private void allMethodsExceptReturn() {}

//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//    @Before("allGetAndReturnMethodsFromUnitLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing log #3);
//    }

    @Before("allMethodsExceptReturn()")
    public void beforeAllMethodsExceptReturnAdvice(JoinPoint joinPoint) {
        System.out.println("beforeAllMethodsExceptReturnAdvice: Logging Get method without Return");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Absolute signature of method: " + methodSignature.getMethod());

        if (methodSignature.getName().equals("getBook")) {
            Object[] args = joinPoint.getArgs();
            for (Object obj : args) {
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: " +
                            "название - " + myBook.getName() +
                            ", автор - " + myBook.getAuthor() +
                            ", год издания - " + myBook.getYearOfPublication());
                }
            }
        }
    }

    @Around("allReturnMethods()")
    public Object aroundAllReturnMethodsLoggingAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aroundAllReturnMethodsLoggingAdvice: start method");
        Object targetMethodResult = null;
        try {
            targetMethodResult = pjp.proceed();
        } catch (Exception e) {
            System.out.println("aroundAllReturnMethodsLoggingAdvice: Logging exception " + e);
            throw e;
        }
        System.out.println("aroundAllReturnMethodsLoggingAdvice: end method");
        System.out.println("**************************************************");
        return targetMethodResult;
    }
}
