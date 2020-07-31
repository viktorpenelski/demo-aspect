package functional.tracking;

@FunctionalInterface
public interface ThrowingSupplier<T> {

    T get() throws Exception;
}
