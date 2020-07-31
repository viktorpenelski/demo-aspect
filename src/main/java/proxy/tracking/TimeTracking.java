package proxy.tracking;

import java.lang.reflect.Proxy;

import proxy.Main;

public class TimeTracking {

    private TimeTracking(){}

    @SuppressWarnings("unchecked")
    public static <T> T wrap(T obj, Class<T> clazz) {
        return (T) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[]{clazz},
                new TimeTrackingInvocationHandler(obj));
    }

}
