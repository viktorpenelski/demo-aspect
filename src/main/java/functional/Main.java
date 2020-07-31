package functional;

import annotation.RepositoryException;

public class Main {

    public static void main(String[] args) {
        Foo foo = new Foo();
        Timed.timed("some.key", (Runnable) foo::bar);
    }
}
