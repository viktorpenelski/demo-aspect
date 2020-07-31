package proxy;

import proxy.business.Foo;
import proxy.business.FooImpl;
import proxy.tracking.TimeTracking;

public class Main {

    public static void main(String[] args) throws Exception {
//        FooImpl foo = new FooImpl();
        Foo foo = TimeTracking.wrap(new FooImpl(), FooImpl.class);
        foo.bar();
    }

}
