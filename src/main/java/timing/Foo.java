package timing;

public class Foo {

    @Timed("nice.composite.key")
    public void bar() throws InterruptedException {
        System.out.println("starting bar");
        Thread.sleep(1000L);
        System.out.println("ending bar");
    }

    @Timed("some.other.key")
    public void baz() {
        System.out.println("starting baz");
        System.out.println("ending baz");
    }

}
