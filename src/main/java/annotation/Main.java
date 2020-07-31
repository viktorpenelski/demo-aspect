package annotation;

import annotation.business.Foo;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        foo.bar();
        foo.baz();
    }
}