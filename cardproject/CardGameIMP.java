package cardproject.src;
import java.io.File;

import Game.Game;

public class CardGameIMP implements Game{
    private App poker;

    @Override
    public String getGameName() {
        return("Poker");
       }

    @Override
    public void play() {
        poker = new App();
    }

    @Override
    public String getScore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getScore'");
    }

    @Override
    public void writeHighScore(File f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeHighScore'");
    }
    
}
