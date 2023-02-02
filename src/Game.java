import java.util.Scanner;

public class Game {

    public static void main(String[] args) 
    {
        System.out.println("******** WELCOME TO CODE COMBAT ********");

        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter START to Play! ");
        String userInput = sc.nextLine();

        // Check if input is valid.
        // userInputValid...

        //Print rules and mechanics.
        //printRulesMechanics...
        
        sc.close();

    }

    /**
     * Prints the rules and mechnics of the game to the player via the console.
     * 
     */
    public static void printRulesMechanics()
    {
        System.out.println("RULES AND MECHNICS: ");
        
        // Open file and print each line until done.

        
    }

    /**
     * Check if input is valid by seeing if it matches the specified criteria.
     * 
     * @param - input
     * @return - isValid
     */
    public static boolean userInputValid(String input)
    {   
        boolean isValid = true;
        

        // Repeatedly tell them that their entry is invalid.
        
        // Need some way to test all potential input (character names, moves, attack, defend, etc).
        // If not, I might need methods that check each type of input.
        // OH! Or I can have a method in each character object that 


        return isValid;
    }

    // Method to create all of the Characters from the Character Interface.
    // public static Character ArrayList ()
    // {

    // } 

}