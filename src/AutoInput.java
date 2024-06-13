import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class AutoInput {
    static File testFile = new File("Sample Input/sampleinput1.txt");
    static Scanner fileScanner;
    static boolean userInputEnabled = true;
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
            String mess = "Scanner is messing up";
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
