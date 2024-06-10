import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AutoInput {
    static File testFile = new File("Sample Input/sampleinput1.txt");
    static Scanner fileScanner;
    static {
        try {
            fileScanner = new Scanner(testFile);
        }
        catch (FileNotFoundException e) {
            String mess = "Scanner is messing up";
        }
    }


    public static String readFromFile() {
        String fileLine = "";

        fileLine = fileScanner.nextLine();
        System.out.println(fileLine);

        return fileLine;
    }

}
