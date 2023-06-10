import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import javax.sound.sampled.*;


public class Game {

    public static void main(String[] args) throws FileNotFoundException
    {
        // UNCOMMENT THIS BLOCK TO PLAY MUSIC.
        // Blocked off to avoid music playing everytime I run the code.
        
        // Play the Main Menu music.
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

        // Create Characters.
        ArrayList<Character> allCharacters = createCharacters();

        // Prompt for if they're playing against CPU (single-player) or with two players.
        System.out.println("PLEASE SELECT: \"SINGLE-PLAYER\" or \"MULTI-PLAYER\"");
        userInputValid(userInput, sc);

        String gameMode = "";
        if(userInput.equals("SINGLE-PLAYER"))
        {
            gameMode = "SINGLE-PLAYER";
        }

        else if(userInput.equals("MULTI-PLAYER"))
        {
            gameMode = "MULTI-PLAYER";
        }


        // Prompt for Character Selection.
        Character player = promptForCharacter(sc, allCharacters, gameMode);

        // Begin the match!
        singlePlayerMatch(player); // Update to include multi-player matches as well.
        
        sc.close();

    }

    /**
     * Check if input is valid by seeing if it matches all the possible correct inputs.
     * 
     * @param input - What the user entered into the terminal.
     * @param sc - The scanner to read the new input from the user (repeatedly).
     */
    public static void userInputValid(String input, Scanner sc)
    {   
        // Hold all possible correct inputs to check.
        ArrayList<String> menuInputs = new ArrayList<>(); // Menu(s)
        ArrayList<String> characterInputs = new ArrayList<>(); // Characters
        ArrayList<String> actionInputs = new ArrayList<>();

        // Menu Options
        menuInputs.add("START");
        menuInputs.add("QUIT");
        menuInputs.add("SINGLE-PLAYER");
        menuInputs.add("MULTI-PLAYER");

        // TANK Options
        characterInputs.add("ATLAS");
        characterInputs.add("RONNIE COLEMAN");

        // Actions
        actionInputs.add("ATTACK");
        // ("Use" + x) item...


        // Repeatedly tell them that their entry is invalid.
        while ( !menuInputs.contains(input) && !characterInputs.contains(input) && !actionInputs.contains(input))
        {
            System.out.print("INVALID INPUT! Please try again: ");
            input = sc.nextLine();
        }
        

    }

    /**
     * Plays in-game music depending on what's happening.
     * 
     * @throws IOException
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     * 
     */
    public static void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {   // Make this into a CLASS? bc you need to...
        // Play different game music depending on the scenario.
        // Pass in a "String status" parameter that tells the method which one to play and stop.

        // Create an Audio File object and read from it.
        File mainMenu = new File("../Game Music/Nightshade - AdhesiveWombat.wav");
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
        File rulesMechs = new File("../Rules + Mechanics.txt");
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
        File characterInfo = new File("../Classes + Character Information.txt");
		Scanner fileReader = new Scanner(characterInfo);
		
		// Open the file and print each line until done.
		while (fileReader.hasNext()) 
        {
			System.out.println(fileReader.nextLine());
        }

        fileReader.close();
    }

    /**
     * Asks the user (player) which Character they want. Assign Character to the PLAYER's choice.
     * 
     * @param sc - Scanner that reads the input from the user.
     * @param charactersList - ArrayList that holds all the Characters.
     * @return player - Character that the player chose.
     */
    public static Character promptForCharacter(Scanner sc, ArrayList<Character> charactersList, String gamemode)
    {
        // Prompt for Character Selection.
        System.out.print("Choose your CHARACTER (ALL CAPS!): ");
        String userSelect = sc.nextLine();
        userInputValid(userSelect, sc);

        // Iterate through Characters and assign the corresponding one.

        Character player = charactersList.get(0); // Placeholder
        
        for (int i = 0; i < charactersList.size(); i++) 
        {   
            Character currentCharacter = charactersList.get(i);

            if ( userSelect.equals(currentCharacter.getName()) )
            {
                player = charactersList.get(i);
            }

        }

        System.out.println("You selected: " + "[ " + player.getName().toUpperCase() + " ]");
        System.out.println();

        
        return player; // Return Character.
    }


    /**
     * Method to create all of the TANK Characters from the Character Interface.
     *  
     */ 
    public static ArrayList<Character> createCharacters()
    {
        // Character ArrayList
        ArrayList<Character> allCharacters = new ArrayList<>();

        // Create the TANKS.
        Character Atlas = new Tank("Atlas");
        Character RonnieColeman = new Tank("Ronnie Coleman");
        
        allCharacters.add(Atlas);
        allCharacters.add(RonnieColeman);

        // Test methods... DELETE LATER AND MAKE INTO JUNIT TEST.
        // Atlas.takeDamage(100);
        // System.out.println(Atlas.getHealth());


        // Create the MARKSMEN.
        

        // Create the THIEVES.


        // Create the SOLDIERS.


        // Create the MAGES.



        return allCharacters;
    }

    
    /** 
     * This method displays the match between players.
     * @param player - The Character that the Player selected.
     */
    public static void singlePlayerMatch(Character player)
    {
        System.out.println("* * * * * * * * * * MATCH BEGIN * * * * * * * * * *");

        // Check whose turn it is and alternate. 
        boolean player1Turn = false;
        boolean cpuTurn = false;

        if (player1Turn == true) 
        {
            cpuTurn = false;
        }

        else if (cpuTurn == true) 
        {
            player1Turn = false;
        }

        System.out.println("PLAYER please make your move: ");
        System.out.println("Your options are: ATTACK, USE ITEM, ....");



    }




}