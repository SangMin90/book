package item3.factory;

import java.util.function.UnaryOperator;

public class Singleton {
    private static final UnaryOperator<Object> IDENTITY_FN = x -> x;

    private Singleton() {

    }

    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }
}
