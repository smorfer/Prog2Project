package ID;

public class IDManager {
    private static int nextID = 0;

    public static int getNextID()
    {
        return nextID++;
    }
}
