package NumberGuessGame;
import java.io.File;
import Game.GameWriteable;


public class NumberGuessGameIMP implements GameWriteable {
    private int lastScore = 0;

    @Override
    public String getGameName() { return "Number Guess Game"; }

    @Override
    public void play() {
        NumberGame g = new NumberGame();  // this is NumberGuessGame/Game.java
        lastScore = g.play();
    }

    @Override
    public String getScore() { return String.valueOf(lastScore); }

    // isHighScore: fewer guesses = better, so lower number wins
    @Override
    public boolean isHighScore(String score, String currentHighScore) {
        if (currentHighScore == null) return true;
        return Integer.parseInt(score) < Integer.parseInt(currentHighScore);
    }
}