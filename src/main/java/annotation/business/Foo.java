package annotation.business;

import annotation.tracking.Timed;

public class Foo {

    @Timed("nice.composite.key")
    public void bar() throws InterruptedException {
        System.out.println("starting bar");
        Thread.sleep(1000L);
        System.out.println("ending bar");
    }

    @Timed("some.other.key")
    public void baz() {
            System.out.println("hi from baz");
    }

}
