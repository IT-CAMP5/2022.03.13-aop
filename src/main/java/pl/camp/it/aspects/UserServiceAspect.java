package pl.camp.it.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import pl.camp.it.model.User;

@Aspect
@Component
public class UserServiceAspect {

    @Pointcut("execution(pl.camp.it.model.User pl.camp.it.services.impl.UserServiceImpl.getUser1())")
    public void getUser1Pointcut() {}

    @Pointcut("execution(* pl.camp.it.services.impl.UserServiceImpl.*(..))")
    public void getAllUsersPointcut() {}

    @Pointcut("within(pl.camp.it.services.impl.UserServiceImpl)")
    public void getAllUsers2Pointcut() {}

    @Pointcut("target(pl.camp.it.services.IUserService)")
    public void getAllUsersInterfacePointcut() {}

    @Pointcut("within(pl.camp.it.services.impl.*)")
    public void usersPackage() {}

    /*@Before("getAllUsersInterfacePointcut()")
    public void printAdditionalData() {
        System.out.println("Dodatkowe informacje");
    }*/

    /*@After("getUser1Pointcut()")
    public void printAdditionalDataAfter() {
        System.out.println("Dodatkowe informacje po !!");
    }*/

    /*@AfterReturning(value = "getUser1Pointcut()", returning = "value")
    public void afterReturning(User value) {
        System.out.println("Zakończono wykonywanie metody getUser1()");
        System.out.println("Wartkość zwrócona przez metodę:");
        System.out.println(value);
    }*/

    @Around("getAllUsersPointcut()")
    public User duringMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Wykryto wykonywanie metody z UserServiceImpl");
        System.out.println("Wykonuję jakieś operacje przed !!");
        User user = null;
        Object proceedResult = joinPoint.proceed();
        if(proceedResult instanceof User) {
            user = (User) proceedResult;
            if(user.getLogin().equals("mateusz")) {
                user.setId(100);
            }
        }
        System.out.println("Coś się dzieje po wykonaniu punktu złączenia");
        return user;
    }
}
