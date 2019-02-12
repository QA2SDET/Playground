public class Factorial {
    static void runExercise() throws Exception {
        int number = 5;
        int result = factorialWithForLoop(number);
        System.out.println("factorial of " + number + " is - " + result);
        result = factorialWithRecursion(number);
        System.out.println("factorial of " + number + " is - " + result);
    }

    static int factorialWithForLoop(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    static int factorialWithRecursion(int number) {
        return factorial(number);
    }

    static int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}