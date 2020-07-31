package proxy;

public class Main {

    public static void main(String[] args) throws Exception {
        Foo foo = TimeTracking.wrap(new FooImpl());
        foo.bar();
    }

}
