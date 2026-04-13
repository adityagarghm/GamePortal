package Game;

import java.util.Scanner;

public class ErrorCheck {

    public static int getInt(Scanner sc) {
    while (!sc.hasNextInt()) {
        System.out.println("Please enter a whole number.");
        sc.next(); // discard the bad input
    }
    return sc.nextInt();
}
}