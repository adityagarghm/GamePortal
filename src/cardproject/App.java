package cardproject;
import java.util.concurrent.CountDownLatch;
import processing.core.PApplet;

public class App extends PApplet {

    private CountDownLatch latch;
    CardGame gamePlaying;

    public static void main(String[] args) {
        launchAndWait();
    }

    public static App launchAndWait() {
        App app = new App();
        app.latch = new CountDownLatch(1);
        PApplet.runSketch(new String[] { "Poker" }, app);
        try {
            app.latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return app;
    }

    public void settings() {
        size(900, 650);
    }

    public void setup() {
       gamePlaying = new PokerGame(this);
        textFont(createFont("Arial", 16));
    }

    public void draw() {
        background(0, 120, 0);

        gamePlaying.update();
        gamePlaying.draw(this);
    }

    public void mousePressed() {
        gamePlaying.handleDrawButtonClick(mouseX, mouseY);
        gamePlaying.handleCardClick(mouseX, mouseY);
    }

    public void keyPressed() {
        gamePlaying.handleKey(key, keyCode);
    }

    public void finishGame() {
        if (latch != null) {
            latch.countDown();
        }
        exit();
    }
}
