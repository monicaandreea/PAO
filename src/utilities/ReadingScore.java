package utilities;

public enum ReadingScore {
    masterpiece(1),
    good(2),
    average(3),
    bad(4),
    horrible(5);

    public final int id;

    private ReadingScore(int id){
        this.id = id;
    }

    public static ReadingScore forInt(int id){
        return values()[id-1];
    }
}
