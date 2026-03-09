package item3.field;

import item3.factory.Elvis;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException, ExecutionException {
        item3.field.Elvis e1 = item3.field.Elvis.INSTANCE;
        Constructor<item3.field.Elvis> elvisConstructor = item3.field.Elvis.class.getDeclaredConstructor();
        elvisConstructor.setAccessible(true);
        item3.field.Elvis e2 = elvisConstructor.newInstance();

        System.out.println(e1 == e2);



        Callable<Elvis> callable1 = Elvis::getInstance;
        Callable<Elvis> callable2 = Elvis::getInstance;

        List<Callable<Elvis>> tasks = List.of(callable1, callable2);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Elvis>> futures = executorService.invokeAll(tasks);

        Elvis f1 = futures.get(0).get();
        Elvis f2 = futures.get(1).get();

        System.out.println(f1 == f2);
    }
}
