public class GuessOutOfRangeException extends RuntimeException {
    public int value;
    public GuessOutOfRangeException(int value){
        this.value = value;
    }
}
