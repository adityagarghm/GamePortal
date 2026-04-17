package MovieDownload;
import Game.GameWriteable;
import java.io.File;

public class MovieDownloadIMP implements GameWriteable{
    
    @Override
    public String getGameName() { return "Movie Download"; }

    @Override
    public void play() {
        try { App.main(null); } catch (Exception e) { e.printStackTrace(); }
    }

    public String getScore() { return "N/A"; }

   @Override
    public boolean isHighScore(String score, String currentHighScore) {
    return false;
    }

    @Override
    public void writeHighScore(File f) { /* no high score for this game */ }
}