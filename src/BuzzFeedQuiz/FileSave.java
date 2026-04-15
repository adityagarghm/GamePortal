package BuzzFeedQuiz;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class FileSave {

    String filename = "Results.csv";
    HashMap<String, int[]> userStats = new HashMap<>();
    String[] categories = {"Owl", "Dolphin", "Fox", "Lion", "Cat", "Dog"};
    public FileSave() throws IOException {
        loadFile();
    }

    public void loadFile() throws IOException {

        File file = new File(filename);
          if (!file.exists()) {
            createEmptyFile();
            return;
        }
        Scanner fileScanner = new Scanner(file);
        fileScanner.nextLine(); // skip header

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split(",");

            String username = parts[0];
            int[] counts = new int[7]; // 6 categories + most recent index

            for (int i = 0; i < 6; i++) {
                counts[i] = Integer.parseInt(parts[i + 1]);
            }

            counts[6] = getCategoryIndex(parts[7]); // most recent
            userStats.put(username, counts);
        }

        fileScanner.close();
    }

    public void savePlay(String username, int categoryIndex) throws IOException {
        int[] counts;
        if (userStats.containsKey(username)) {
            counts = userStats.get(username);
        } else {
            counts = new int[7];
        }

        counts[categoryIndex]++;   // increment category count
        counts[6] = categoryIndex; // store most recent

        userStats.put(username, counts);
        writeFile();
    }

   
    public void writeFile() throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write("Username,Owl,Dolphin,Fox,Lion,Cat,Dog,MostRecent\n");
        for (String username : userStats.keySet()) {
            int[] counts = userStats.get(username);
            writer.write(username);
            for (int i = 0; i < 6; i++) {
                writer.write("," + counts[i]);
            }

            writer.write("," + categories[counts[6]]);
            writer.write("\n");
        }
        writer.close();
    }

    public int getCategoryIndex(String categoryName) {
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].equals(categoryName)) {
                return i;
            }
        }
        return 0;
    }

    private void createEmptyFile() throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write("Username,Owl,Dolphin,Fox,Lion,Cat,Dog,MostRecent\n");
        writer.close();
    }


}
