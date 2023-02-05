import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("******** WELCOME TO CODE COMBAT ********");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter \"START\" to Play! ");
        String userInput = sc.nextLine();

        // Check if input is valid.
        userInputValid(userInput, sc);

        //Print rules and mechanics.
        System.out.println();
        printRulesMechanics();
        
        sc.close();

    }

    /**
     * Prints the rules and mechnics of the game to the player via the console.
     * 
     */
    public static void printRulesMechanics() throws FileNotFoundException
    {
        // Create a File object to hold the Rules + Mechanics file. 
        File text = new File("Code_Wars/Rules + Mechanics.txt");
		Scanner textReader = new Scanner(text);
		
		// Open the file and print each line until done.
		while (textReader.hasNext()) 
        {
			System.out.println(textReader.nextLine());
            
        }

        textReader.close();
    }

    /**
     * Check if input is valid by seeing if it matches the specified criteria.
     * 
     * @param input - What the user entered into the terminal.
     * @param sc - The scanner to read the new input from the user (repeatedly).
     */
    public static void userInputValid(String input, Scanner sc)
    {   
        // Repeatedly tell them that their entry is invalid.
        while ( !input.equals("START") )
        {
            System.out.print("INVALID INPUT! Please enter \"START\"!: ");
            input = sc.nextLine();

        }
        
        // Need some way to test all potential input (character names, moves, attack, defend, etc).
        // If not, I might need methods that check each type of input.

    }

    // Method to create all of the Characters from the Character Interface.
    // public static Character ArrayList ()
    // {

    // } 

}