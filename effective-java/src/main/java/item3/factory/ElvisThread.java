package item3.factory;

public class ElvisThread {

    private static final ThreadLocal<ElvisThread> INSTANCE =
            ThreadLocal.withInitial(ElvisThread::new);

    private ElvisThread() {
    }

    public static ElvisThread getInstance() {
        return INSTANCE.get();
    }

    public void leaveTheBuilding() {

    }
}
