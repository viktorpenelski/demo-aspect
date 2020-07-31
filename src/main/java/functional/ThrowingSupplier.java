package functional;

@FunctionalInterface
public interface ThrowingSupplier<T> {

    T get() throws Exception;
}
