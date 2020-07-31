package annotation.tracking;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.concurrent.TimeUnit;

@Aspect
public class TimedMethodAspect {

    // ensure pointcut is called when annotated method is about to be executed
    // if not specified, pointcut triggers twice - once for "calling" and once for "executing"
    @Pointcut("@annotation(timed) && execution(* *(..))")
    public void callAt(Timed timed) {
    }

    @Around("callAt(timed)")
    public Object around(ProceedingJoinPoint pjp,
                         Timed timed) throws Throwable {
        long start = System.nanoTime();
        try {
            return pjp.proceed();
        } finally {
            long end = System.nanoTime();
            // pretend this is being sent to statsD
            System.out.println("key " + timed.value() + ": " + TimeUnit.NANOSECONDS.toMillis(end - start) + "ms");
        }
    }
}
