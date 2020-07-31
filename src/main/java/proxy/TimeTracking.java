package proxy;

import java.lang.reflect.Proxy;

public class TimeTracking {

    private TimeTracking(){}

    @SuppressWarnings("unchecked")
    public static <T> T wrap(T obj) {
        return (T) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[]{Foo.class},
                new TimeTrackingInvocationHandler(obj));
    }

}
