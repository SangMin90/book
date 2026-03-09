package item3.factory;

public class Elvis {

    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
        if (INSTANCE != null) {
            throw new RuntimeException("FatsDomino is already created");
        }
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {

    }
}
