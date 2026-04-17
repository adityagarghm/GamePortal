package MovieDownload;
import java.util.Scanner;
class App {
    static String movieChoice;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
       getInput();
        // 1. Create a new MoviePosterWriter
        MoviePosterWriter mpw = new MoviePosterWriter();
        
        // Choose your own movies below and put them into this array! make a loop to repeat steps 2 and 3.
       String[] movies = {movieChoice};

// loop and download each poster to the current working directory (no folders, no try/catch)
for (String title : movies) {
    Movie m = new Movie(title);
    mpw.setMovieString(m.getMovieNameForURL());
    String filename = m.getMovieFilename(); // e.g. The_Avengers.jpg
    mpw.write(filename);                     // call you said you can use
    System.out.println("Saved: " + filename + " (Year: " + mpw.movieYear + ")");
}
        
    }
    public static String getInput (){
            System.out.println("Type one movie that you want the poster of.");
            movieChoice = sc.next();
            if (movieChoice == null){
                System.out.println("Please enter an input.");
                return getInput();

            }
            return movieChoice;
        }
}
