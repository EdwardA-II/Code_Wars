import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AutoInput {
    static File testFile = new File("Code_Combat/Sample Input/sampleinput1.txt");
    // Laptop makes me use "Code_Combat/Sample Input/sampleinput1.txt" while desktop is fine with just "Sample Input/sampleinput1.txt"
    // idk why...
    static Scanner fileScanner;
    static boolean userInputEnabled = false;
    static {
        try {
            if (!userInputEnabled) {
                fileScanner = new Scanner(testFile);
            }
            else {
                fileScanner = new Scanner(System.in);
            }
        }
        catch (FileNotFoundException e) {
            String mess = "Scanner is messing up!";
            System.out.println(mess);
        }
    }


    public static String readFromFile() {
        String fileLine = fileScanner.nextLine();

        if (!userInputEnabled) {
            System.out.println(fileLine);
        }

        return fileLine;
    }

}
