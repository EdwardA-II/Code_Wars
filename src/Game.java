import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import javax.sound.sampled.*;


public class Game {

    public static void main(String[] args) throws FileNotFoundException
    {
        //Play the Main Menu music.
        try 
        {
            playMusic();
        } 
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // System.out.println("Audio File NOT FOUND!");

            e.printStackTrace(); //Tell me which exact error it throws.
        }
        
        System.out.println("******** WELCOME TO CODE COMBAT ********");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter \"START\" to Play! ");
        String userInput = sc.nextLine();

        // Check if input is valid.
        userInputValid(userInput, sc);

        // Print rules and mechanics.
        System.out.println();
        printRulesMechanics();

        // Print Classes and Characters.
        System.out.println();
        printClassesCharacters();

        // Prompt for Character Selection.
        System.out.print("Choose your CHARACTER: ");
        userInput = sc.nextLine();
        userInputValid(userInput, sc);
        System.out.println("You selected: " + userInput);
        
        
        sc.close();

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

    /**
     * @throws IOException
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     * 
     * 
     */
    public static void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {   // Make this into a CLASS? bc you need to...
        // Play different game music depending on the scenario.

        // Create an Audio File object and read from it.
        File mainMenu = new File("Code_Combat/Game Music/Nightshade - AdhesiveWombat.wav");
        Scanner musicScanner = new Scanner(System.in);

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(mainMenu);
        Clip song = AudioSystem.getClip();
        song.open(audioStream);
        song.start();




        // musicScanner.close();
    }

    /**
     * Prints the rules and mechnics of the game to the player via the console.
     * 
     */
    public static void printRulesMechanics() throws FileNotFoundException
    {
        // Create a File object to hold the Rules + Mechanics file. 
        File rulesMechs = new File("Code_Combat/Rules + Mechanics.txt");
		Scanner textReader = new Scanner(rulesMechs);
		
		// Open the file and print each line until done.
		while (textReader.hasNext()) 
        {
			System.out.println(textReader.nextLine());
        }

        textReader.close();
    }

    /**
     * Prints the Classes and Characters of the game to the player via the console.
     * 
     */
    public static void printClassesCharacters() throws FileNotFoundException
    {
        // Create a File object to hold the Rules + Mechanics file. 
        File characterInfo = new File("Code_Combat/Classes + Character Information.txt");
		Scanner fileReader = new Scanner(characterInfo);
		
		// Open the file and print each line until done.
		while (fileReader.hasNext()) 
        {
			System.out.println(fileReader.nextLine());
        }

        fileReader.close();
    }


    // Method to create all of the Characters from the Character Interface.
    // public static Character ArrayList ()
    // {

    // } 

}