package utilities;

public enum ReadingState {
    completed, //changes pages_read to max
    reading,
    dropped,
    plan_to_read // changes pages_read to 0
}
