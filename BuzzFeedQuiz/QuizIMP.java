package BuzzFeedQuiz;
import java.io.File;
import Game.GameWriteable;

public class QuizIMP implements GameWriteable {
    @Override
    public String getGameName() { return "Which Animal Are You?"; }

    @Override
    public void play() {
        try { Quiz.main(null); } catch (Exception e) { e.printStackTrace(); }
    }

        public String getScore() { return "N/A"; }

   @Override
public boolean isHighScore(String score, String currentHighScore) {
    return false;
}

    @Override
    public void writeHighScore(File f) { /* no high score for this game */ }
}