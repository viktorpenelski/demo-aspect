package proxy.business;

public class FooImpl implements Foo {

    public void bar() throws InterruptedException {
        System.out.println("starting bar");
        Thread.sleep(1000L);
        System.out.println("finished with bar");
    }

}
