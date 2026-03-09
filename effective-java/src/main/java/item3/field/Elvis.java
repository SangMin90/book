package item3.field;

public class Elvis {

    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
        if (INSTANCE != null) {
            throw new RuntimeException("Elvis is already Created");
        }
    }

    public void leaveTheBuilding() {

    }
}
