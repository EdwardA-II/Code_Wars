import java.util.Scanner;

public class Game {

    public static void main(String[] args) 
    {
        System.out.println("Welcome to Code Combat");

        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter START to Play! ");
        String userInput = sc.nextLine();

        // Check if input is valid.
        // userInputValid...

        //Print rules and mechanics.
        printRulesMechanics();
        
        sc.close();

    }

    public static void printRulesMechanics()
    {
        System.out.println("RULES AND MECHNICS: ");
        // Create a txt file called "Rules_Mechanics.txt" and print the rules to the console. 


        
    }

    public static boolean userInputValid(String input)
    {   
        boolean isValid = true;
        // Check if input is valid by seeing if it matches the specified criteria.


        return isValid;
    }

}