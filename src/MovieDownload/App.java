package MovieDownload;
import java.util.Scanner;
class App {
    static String movieChoice;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // 1. Create a new MoviePosterWriter
        MoviePosterWriter mpw = new MoviePosterWriter();
        
        // Choose your own movies below and put them into this array! make a loop to repeat steps 2 and 3.
    while (true){
    getInput();
    Movie m = new Movie(movieChoice);
    try {
    mpw.setMovieString(m.getMovieNameForURL());
    String filename = m.getMovieFilename(); // e.g. The_Avengers.jpg
    mpw.write("/Users/adityagarg/intermediate_programming/GamePortal-main/outputs/movies/" + filename);
    System.out.println("Saved: " + filename + " (Year: " + mpw.movieYear + ")");
    break;
    } catch (Exception e) {
        System.out.println("Please input a valid movie name");
    }

}
    }
    public static String getInput (){
            System.out.println("Type one movie that you want the poster of.");
            movieChoice = sc.nextLine();
            if (movieChoice == null){
                System.out.println("Please enter an input.");
                return getInput();

            }
            return movieChoice;
        }
}
