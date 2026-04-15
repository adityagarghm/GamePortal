package cardproject;
import Game.GameWriteable;
public class CardGameIMP implements GameWriteable {
    private App poker;
 
    @Override
    public String getGameName() {
        return "Poker";
    }
 
    @Override
    public void play() {
        poker = App.launchAndWait();
    }
 
    @Override
    public String getScore() {
        if (poker == null) return "0";
        return String.valueOf(poker.gamePlaying.getScore());
    }
 
    // higher chips = better
    @Override
    public boolean isHighScore(String score, String currentHighScore) {
        if (currentHighScore == null) return true;
        return Integer.parseInt(score) > Integer.parseInt(currentHighScore);
    }
    
}
 
