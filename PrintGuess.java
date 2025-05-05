public class PrintGuess {
    
    public static void printGuess(String guess, String target) {
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (c == target.charAt(i)) {
                // Green for correct position
                System.out.print("\u001B[32m" + c + "\u001B[0m");
            } else if (target.indexOf(c) != -1) {
                // Yellow for wrong position
                System.out.print("\u001B[33m" + c + "\u001B[0m");
            } else {
                // Gray or default for wrong letter
                System.out.print(c);
            }
        }
        System.out.println();
    }
}
