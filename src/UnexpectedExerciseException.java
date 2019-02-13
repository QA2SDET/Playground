public class UnexpectedExerciseException extends RuntimeException {
    public int exercise;

    public UnexpectedExerciseException(int exercise) {
        this.exercise = exercise;
    }
}
