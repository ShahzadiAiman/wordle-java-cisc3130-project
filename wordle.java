import java.util.ArrayList;
import java.util.Scanner;

public class WordleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String targetWord = "apple";
        
        //store guesses
        ArrayList<String> guesses = new ArrayList<>();
        System.out.print("Enter your guess (5-letter word): ");
        String guess = scanner.nextLine(); 
        guesses.add(guess);
        
        if (guess.equals(targetWord)) {
            System.out.println("Correct guess!");
        } else {
            System.out.println("Wrong guess. Try again!");
        }

        System.out.println("\nGuesses made so far:");
        for (String g : guesses) {
            System.out.println(g);
        }
        
        scanner.close();
    }
}
