public class GuessOutOfRangeException extends RuntimeException {
    public int value;
    public GuessOutOfRangeException(int badValue){
        value = badValue;
    }
}
