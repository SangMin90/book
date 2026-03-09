package item3.factory;

import java.io.Serializable;

public class ElvisSerializable implements Serializable {

    private static final ElvisSerializable INSTANCE = new ElvisSerializable();

    private ElvisSerializable() {}

    public static ElvisSerializable getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {

    }

    private Object readResolve() {
        return INSTANCE;
    }
}
