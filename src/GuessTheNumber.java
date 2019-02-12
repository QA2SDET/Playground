import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static final String EXIT = "Bye";
    public static final int MAX = 15;

    public static void runExercise() throws Exception {
        boolean play = true;
        do {
            System.out.print("Please Enter Your Guess 0.." + MAX + ", \"" + EXIT + "\" to exit: ");
            try {
                int guessedNumber = guessNumber();
                int rolledNumber = rollNumber();
                announceOutcome(guessedNumber, rolledNumber);
            } catch (ExitException e) {
                play = false;
            } catch (GuessOutOfRangeException e) {
                        System.out.println("Your guess - "+e.value+" out of range, try again");
            } catch (NumberFormatException e) {
                System.out.println("Illegal input, try again.");
            }
        } while (play);
    }

    private static void announceOutcome(int guessedNumber, int rolledNumber) {
        System.out.println("Your guess: " + guessedNumber + ", rolled number: " + rolledNumber + ".");
        boolean ifGuessIsCorrect = guessedNumber == rolledNumber;
        String result = ifGuessIsCorrect ? "correct" : "wrong";
        System.out.println("You guessed " + result);
    }

    private static int guessNumber() {
        final Scanner scanner = new Scanner(System.in);
        final String userInput = scanner.next();
        final int guess;
        try {
            guess = Integer.parseInt(userInput);
            if (guess < 0 || guess > MAX) throw new GuessOutOfRangeException(guess);
        } catch (NumberFormatException e) {
            if (userInput.equals(EXIT)) throw new ExitException();
            else throw e;
        }
        return guess;
    }

    private static Random random = new Random();

    private static int rollNumber() {
        return random.nextInt(MAX);
    }
}
