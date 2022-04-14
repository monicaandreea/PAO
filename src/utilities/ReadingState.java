package utilities;

public enum ReadingState {
    completed(1),
    reading(2),
    dropped(3),
    plan_to_read(4);

    public final int id;

    private ReadingState(int id){
        this.id = id;
    }

    public static ReadingState forInt(int id){
        return values()[id-1];
    }
}
