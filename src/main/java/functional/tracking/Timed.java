package functional.tracking;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Timed {

    public static <T> T timed(String name, ThrowingSupplier<T> r) throws Exception {
        long start = start();
        try {
            return r.get();
        } finally {
            log(name, start);
        }
    }

    public static <T> T timed(String name, Supplier<T> r) {
        long start = start();
        try {
            return r.get();
        } finally {
            log(name, start);
        }
    }

    public static void timed(String name, ThrowingRunnable r) throws Exception {
        long start = start();
        try {
            r.run();
        } finally {
            log(name, start);
        }
    }

    public static void timed(String name, Runnable r) {
        long start = start();
        try {
            r.run();
        } finally {
            log(name, start);
        }
    }

    private static long start() {
        return System.nanoTime();
    }

    private static void log(String name, long startTime) {
        long end = System.nanoTime();
        // pretend this is being sent to statsD
        System.out.println("key " + name + ": " + TimeUnit.NANOSECONDS.toMillis(end - startTime) + "ms");
    }

}
