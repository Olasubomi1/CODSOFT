import java.util.Scanner;

public class Main {
    static int maxNumberOfGuesses = 6;
    static int min = 1, max = 100;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("WELCOME TO NUMBER GAME.");
        System.out.println("You score 5 for a single guess, \n4 for 2 guesses,\n3 for 3 guesses,\n2 for 4 guesses,\nand 1 for 5 guesses.");
        Main.numberGame();
    }

    private static void numberGame(){
        int currentScore = 0;
        int currentNumberOfGuesses = 1;
        int value;
        boolean play = true;
        int playNewRound;
        while (play) {
            int randomValue = Main.generateRandomValue();
            currentNumberOfGuesses = 1;
            while (currentNumberOfGuesses < maxNumberOfGuesses) {
                System.out.print("Enter a number between " + min + " and " + max + " = ");
                value = scanner.nextInt();
                if (value > randomValue) System.out.println("Your guess was too high.");
                if (value < randomValue) System.out.println("Your guess was too low.");
                if (value == randomValue) {
                    currentScore = currentScore + (maxNumberOfGuesses - currentNumberOfGuesses);
                    System.out.println("Your answer is correct");
                    System.out.println("Your total score is " + currentScore + " \nThank you for playing number game.");
                    break;
                }
                if (currentNumberOfGuesses == maxNumberOfGuesses) {
                    System.out.println("You lost the game, try again later.");
                }
                ++currentNumberOfGuesses;
            }
            System.out.println("Would you like to play another round ? \nEnter 1 for yes and 2 for no.");
            playNewRound = scanner.nextInt();
            if (playNewRound == 1) continue;
            if (playNewRound == 2) play = false;
        }
    }
    private static int generateRandomValue(){
        int randomValue = (int) (Math.random() * 100);
        return randomValue;
    }
}
