package NumberGuessGame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    int guesses = 0;
    int numToGuess;
    int lowGuess; 
    int highGuess; 
    ArrayList<Integer> prevGuesses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    NumberGame() {
        Random answer = new Random();
        low();
        high();
        numToGuess = answer.nextInt(lowGuess + 1, highGuess);
        prevGuesses.add(lowGuess);
        prevGuesses.add(highGuess);
        System.out.println("Begin play! The number cannot be one of the bounds.");
    }

    int play(){
        int guess = rangeAnswers();
        guesses ++;
        System.out.println("You guessed " + guess);
        if(guess == numToGuess){
            if(guesses == 1){System.out.println("Correct, done playing! You guessed the number in " + guesses + " guess!");
        }
            else{
            System.out.println("Correct, done playing! You guessed the number in " + guesses + " guesses!");
            }
            return getNumGuesses();
        } 
        if(guess < numToGuess){
            System.out.println("My number is higher than " + guess); 
            return play();
        }
        if (guess > numToGuess){
            System.out.println("My number is lower than " + guess);
            return play();
        }
        return getNumGuesses();

    }

    int getGuess() {
        boolean answerTest = sc.hasNextInt(); 
        if (answerTest == false){
            sc.next();
            System.out.println("Please enter an integer");
            return getGuess();

        }
        int guess = sc.nextInt();
        return guess;
    }

    int getNumGuesses() {
        return guesses;
    }
    int low() {
    System.out.println("Enter the lower bound of the possible integer");
    boolean lowTest = sc.hasNextInt(); 
        if (lowTest == false){
            sc.next();
            System.out.println("Please enter an integer");
            return low();
        }
        lowGuess = sc.nextInt();
        return lowGuess;
    }
    int high() {
    System.out.println("Enter the higher bound of the possible integer");
    boolean highTest = sc.hasNextInt(); 
        if (highTest == false){
            sc.next();
            System.out.println("Please enter an integer");
            return high();
        }
        highGuess = sc.nextInt();
        if (highGuess <= (lowGuess)+2){
            System.out.println("The higher bound must be GREATER than the lowerbound by at least 3");
            return high();
        }
        return highGuess;
    }
    int rangeAnswers(){//Guess in between x and y 
        System.out.println("Please enter a number between " + lowGuess + " and " + highGuess);
        int guess = getGuess(); 
        for(int i = 0; i<prevGuesses.size(); i++){//just arraylist practice, no real use 
            if(prevGuesses.get(i) == guess){
                System.out.println("You have already guessed " + guess);
                return rangeAnswers();
            }
        }
        prevGuesses.add(guess);
        if (guess > highGuess || guess < lowGuess){
            System.out.println("Please guess in between the bounds.");
            return rangeAnswers();
        }
        if (guess > lowGuess && guess < numToGuess){
            lowGuess = guess;
        }
        if (guess < highGuess && guess > numToGuess){
            highGuess = guess;
        }
        return guess;
    }

}
