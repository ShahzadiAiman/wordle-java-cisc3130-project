
import java.io.*;
import java.util.*;

public class WordleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //scanner for user input
        System.out.println("Welcome to Wordle!");
        System.out.println();

        //read in dictionary
        Set<String> dictionary = new HashSet<>();
        try {
            Scanner fileScanner = new Scanner(new File("dictionary.txt")); // scanner for dictionary
            while (fileScanner.hasNextLine()) {
                String word = fileScanner.nextLine().trim().toLowerCase();
                if (word.length() == 5) {
                    dictionary.add(word);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: dictionary.txt file not found.");
            return;
        }


        // picking a random word
        List<String> wordList = new ArrayList<>(dictionary);
        String targetWord = wordList.get(new Random().nextInt(wordList.size()));


        // hw 2- array to hold all guesses from user in order (will print at end)
        ArrayList<String> guesses = new ArrayList<>();
        // hw 3- set to prevent duplicates
        Set<String> uniqueGuesses = new HashSet<>();


        int maxAttempts = 5;
        
        for (int i = 0; i < maxAttempts; i++){
            System.out.print("Enter your guess (5-letter word): ");
            String guess = scanner.nextLine().toLowerCase();
        
            //base case: user does not enter 5 letter word
            if (guess.length() != 5) {
                System.out.println("Please enter a 5-letter word.");
                System.out.println();
                i--; // doesn't count as an attempt
                continue;
            }
            //base case: word is not in dictionary
            if (!dictionary.contains(guess)) {
                System.out.println("Unable to find word in dictionary.");
                System.out.println();
                i--; 
                continue;
            }
            // base case: already guessed word
            if (uniqueGuesses.contains(guess)) {
                System.out.println("You already guessed that word.");
                System.out.println();
                i--;
                continue;
            }

            // the guess is valid
            guesses.add(guess);
            uniqueGuesses.add(guess);
            
            if (guess.equals(targetWord)) {
                System.out.println("Correct guess!");
                break;
            } else {
                System.out.println("Wrong guess. Try again!");
                System.out.println();
            }

            System.out.println("Guesses so far:");
            for (String g : guesses) {
                PrintGuess.printGuess(g, targetWord);
            }
            System.out.println();


        }
        
        System.out.println("Game Over! The correct word was: " + targetWord);
    }
}
