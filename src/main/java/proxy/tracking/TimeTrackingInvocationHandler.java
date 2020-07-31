package proxy.tracking;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TimeTrackingInvocationHandler implements InvocationHandler {

    private final Map<String, Method> methods = new HashMap<>();

    private final Object target;

    public TimeTrackingInvocationHandler(Object target) {
        this.target = target;

        for (Method method : target.getClass().getDeclaredMethods()) {
            this.methods.put(method.getName(), method);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();
        try {
            return methods.get(method.getName()).invoke(target, args);
        } finally {
            long timeMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
            System.out.println(method.getName() + " took " + timeMs + "ms to run");
        }
    }
}