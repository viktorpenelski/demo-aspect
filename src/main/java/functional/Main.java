package functional;

import functional.business.Foo;
import functional.tracking.Timed;

public class Main {

    public static void main(String[] args) {
        Foo foo = new Foo();
        Timed.timed("some.key", (Runnable) foo::bar);
    }
}
