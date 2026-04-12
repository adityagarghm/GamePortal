import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the Number Guess Game!");
        // See Game for pseudocode you need to fill out
        // Create a new Game that sets a number within the user's specified number range
        ArrayList<Game> games = new ArrayList<>();
        HashMap<Integer, Integer> hg = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("To play a game, press 'y'. If you want to stop playing, type anything other than 'y'.");
        while (sc.hasNext() && sc.next().equals("y")) {
            Game g = new Game();
            g.play();
            games.add(g);
            System.out.println("press 'y' to play another game.");
            if(hg.containsKey(g.getNumGuesses())){
                hg.put(g.getNumGuesses(),hg.get(g.getNumGuesses())+1);
            }else{hg.put(g.getNumGuesses(), 1);}
        }
        if(games.isEmpty()){
            System.out.println("Goodbye");
        }else if (games.size() == 1){
            Game y = games.get(0);
            System.out.println("Your minimum amount of guesses was " + y.getNumGuesses() + ", which you got 1 time.");
        }else{getBestGame(games,hg);}
    }

    public static void getBestGame(ArrayList<Game> games,HashMap<Integer,Integer> hg) {
        // best game
        Game y = games.get(0);
        int minGame = y.getNumGuesses();
        for (Game g : games) {
            if (g.getNumGuesses() < minGame) {
                minGame = g.getNumGuesses();
            }
        }
        System.out.println("Your minimum amount of guesses was: " + (minGame));
        System.out.println("Here is how many times you got each value");
        for (int key : hg.keySet()){
            System.out.println(key + " guess(es): " + hg.get(key));
        }
    }
}
