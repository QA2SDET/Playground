import org.omg.CORBA.portable.UnknownException;

import javax.management.BadAttributeValueExpException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final int NUMBERofEXERCISES = 3;
    public static final int UNKNOWN_EXERCISE = 0;
    private static final int INVALID_INPUT = -1;

    public static void main(String[] args) throws Exception, UnexpectedExerciseException {
        int exercise = ReadUserSelection();
        switch (exercise) {
            case 1:
                Factorial.runExercise();
                break;
            case 2:
                Animation.runExercise();
                break;
            case 3:
                GuessTheNumber.runExercise();
                break;
            case UNKNOWN_EXERCISE:
                UnknownExercise.runExercise();
                break;
            case INVALID_INPUT:
                InvalidInput.runExercise();
                break;
                default:throw new UnexpectedExerciseException(exercise);
        }
    }

    private static int ReadUserSelection() {
        int selectedExercise;
        System.out.println("Select exercise in the range 1.." + NUMBERofEXERCISES + ", any other number to quit");
        final Scanner scanner = new Scanner(System.in);

        try {
            selectedExercise = scanner.nextInt();
            final boolean unknownExercise = selectedExercise < 1 || selectedExercise > NUMBERofEXERCISES;
            if (unknownExercise) selectedExercise = UNKNOWN_EXERCISE;
        } catch (InputMismatchException e) {
            selectedExercise = INVALID_INPUT;
        }
        return selectedExercise;
    }


}

