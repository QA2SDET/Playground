import java.util.Arrays;

public class Animation {
    static void runExercise() throws Exception {
        String[] animation = getAnimation();
        animateWithForLoop(animation);
        animateWithWhile(animation);
        animateWithDo(animation);
        animateWithForeach(animation);
    }

    static String[] getAnimation() {
        String animatedString = "Hello";
        String[] animation = buildAnimation(animatedString);
        animation = addToAnimation(animation, animatedString);
        return animation;
    }

    static String[] buildAnimation(String animatedString) {
        if (animatedString.isEmpty())
            return new String[0];
        String partialAnimatedString = animatedString.substring(0, animatedString.length() - 1);
        String[] partialAnimation = buildAnimation(partialAnimatedString);

        String addition = getAnimationString(animatedString);
        return addToAnimation(partialAnimation, addition);
    }

    static String[] addToAnimation(String[] partialAnimation, String addition) {
        String[] animation = new String[partialAnimation.length + 1];
        copyPartialAnimationIntoAnimation(partialAnimation, animation);
        animation[animation.length - 1] = addition;
        return animation;
    }

    static void copyPartialAnimationIntoAnimation(String[] partialAnimation, String[] animation) {
        System.arraycopy(partialAnimation, 0, animation, 0, partialAnimation.length);
    }

    static void animateWithForLoop(String[] animation) throws Exception {
        printMessage("For loop with Index:\n");
        animationForLoop(animation);
        newline();
    }

    static void animateWithWhile(String[] animation) throws Exception {
        printMessage("While loop:\n");
        animationWhileLoop(animation);
        newline();
    }

    static void animateWithDo(String[] animation) throws Exception {
        printMessage("Do loop:\n");
        animationDoLoop(animation);
        newline();
    }

    static void animateWithForeach(String[] animation) throws Exception {
        printMessage("Foreach loop:\n");
        animationForeachLoop(animation);
        newline();
    }

    static void animationForLoop(String[] animation) throws Exception {
        for (int index = 0; index < animation.length; index++) {
            printMessage(animation[index]);
        }
    }

    static void animationWhileLoop(String[] animation) throws Exception {
        int index = 0;
        while (index < animation.length) {
            printMessage(animation[index]);
            index++;
        }
    }

    static void animationDoLoop(String[] animation) throws Exception {
        int index = 0;
        do {
            printMessage(animation[index]);
            index++;
        } while (index < animation.length);
    }

    static void animationForeachLoop(String[] animation) throws Exception {
        for (String message : animation) {
            printMessage(getAnimationString(message));
        }
    }

    static String getAnimationString(String animatedString) {
        char initializationCharacter = ' ';
        int initialLength = animatedString.length() - 1;
        String line = getInitializedLine(initializationCharacter, initialLength);
        line += animatedString.charAt(animatedString.length() - 1);

        return line;
    }

    private static String getInitializedLine(char initializationCharacter, int initialLength) {
        String line = initializeWithCharArrayAndReplace(initializationCharacter, initialLength);
        return line;
    }

    private static String initializeWithCharArrayAndReplace(char initializationCharacter, int initialLength) {
        char[] characters = new char[initialLength];
        Arrays.fill(characters,initializationCharacter);
        String line = new String(characters);
     //   String line = line.replace('\0', initializationCharacter);
            return line;
    }

    private static String initializeWithForLoop(String initializationCharacter, int initialLength) {
        String line = "";
        for (int i = 0; i < initialLength; i++) {
            line += initializationCharacter;
        }
        return line;
    }

    static void printMessage(String message) throws Exception {
        System.out.print("\r" + message);
        Thread.sleep(600);
    }

    static void newline() throws Exception {
        printMessage("\n");
    }
}