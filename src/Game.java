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
        // try 
        // {
        //     playMusic();
        // } 
        // catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        //     // System.out.println("Audio File NOT FOUND!");

        //     e.printStackTrace(); //Tell me which exact error it throws.
        // }
        
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
        ArrayList<Characters> allCharacters = createCharacters();

        // Prompt for Character Selection.
        System.out.println("*PLAYER 1*");
        Characters player1 = promptForCharacter(sc, allCharacters);
        System.out.println("*PLAYER 2*");
        Characters player2 = promptForCharacter(sc, allCharacters);

        // Begin the match!
        playerVersusPlayerMatch(player1, player2); // Update to include multi-player matches as well.
        
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
        actionInputs.add("SPECIAL MOVE");
        actionInputs.add("USE ITEM");

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
        File mainMenu = new File("Code_Combat/Game Music/Nightshade - AdhesiveWombat.wav"); // Only works on desktop when using Code_Combat not the dots (..).
        // System.out.println("Attempting to read from file in: "+ mainMenu.getCanonicalPath());

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

    /**
     * Asks the user (player) which Character they want. Assign Character to the PLAYER's choice.
     * 
     * @param sc - Scanner that reads the input from the user.
     * @param charactersList - ArrayList that holds all the Characters.
     * @return player - Character that the player chose.
     */
    public static Characters promptForCharacter(Scanner sc, ArrayList<Characters> charactersList)
    {
        // Prompt for Character Selection.
        System.out.print("Choose your CHARACTER (ALL CAPS!): ");
        String userSelect = sc.nextLine();
        userInputValid(userSelect, sc);

        // Iterate through Characters and assign the corresponding one.

        Characters player = charactersList.get(0); // Placeholder
        
        for (int i = 0; i < charactersList.size(); i++) 
        {   
            Characters currentCharacter = charactersList.get(i);

            if ( userSelect.equals(currentCharacter.getName()) )
            {
                player = charactersList.get(i);
            }

        }

        System.out.println("You selected: " + "[ " + player.getName() + " ]");
        System.out.println();

        
        return player; // Return Character.
    }


    /**
     * Method to create all of the TANK Characters from the Character Interface.
     *  
     */ 
    public static ArrayList<Characters> createCharacters()
    {
        // Character ArrayList
        ArrayList<Characters> allCharacters = new ArrayList<>();

        // Create the TANKS.
        Tank Atlas = new Tank("ATLAS");
        Characters RonnieColeman = new Tank("RONNIE COLEMAN");
        
        allCharacters.add(Atlas);
        allCharacters.add(RonnieColeman);

        // Create the MARKSMEN.
        

        // Create the THIEVES.


        // Create the SOLDIERS.


        // Create the MAGES.



        return allCharacters;
    }

    
    /** 
     * This method displays the match between players.
     * @param player1 - The Character that Player 1 selected.
     * @param player2 - The Character that Player 2 selected.
     * 
     */
    public static void playerVersusPlayerMatch(Characters player1, Characters player2)
    {
        System.out.println("* * * * * * * * * * MATCH BEGIN * * * * * * * * * *");

        /*
         * Probably turn this into another method that checks whose turn it is.
         * Check whose turn it is and alternate. 
         * Establish which Character is Player1 and Player2?
         * Use a queue or stack to pop off similar ot the Adventure Game where 
         * we had to keep track of the last room they were in too.
         * 
         * Whenever player1 does something, check swap the variables to false and true accordingly?
         */
        

        // Yeah, definitely break this up into smaller methods like the useItem thing. Place this
        // within the "UseItem" block?

        
        System.out.println();
        System.out.println("Your options are: ATTACK | USE ITEM | SPECIAL MOVE");
        System.out.print("PLAYER 1 make your move: ");

        
        Scanner action = new Scanner(System.in);
        String player1Action = action.nextLine();
        userInputValid(player1Action, action);
        System.out.println();

        // Player ATTACKS scenario...
        if (player1Action.equals("ATTACK")) 
        {
           pvpAttack(player1, player2);
          // player1Turn = false;
           
        }

        // Player USE ITEM scenario...
        if (player1Action.equals("USE ITEM")) 
        {
            // Tell them what items they can use (for loop?).
           System.out.println("Which item would you like to use? Your inventory includes...");

           // And them use them accordingly... but how tho?
        }



    }

    /**
     * A method to check whose turn it is during the match. 
     */
    public static void checkTurn() {
        /*
         * Probably turn this into another method that checks whose turn it is.
         * Check whose turn it is and alternate. 
         * Establish which Character is Player1 and Player2?
         * Use a queue or stack to pop off similar ot the Adventure Game where 
         * we had to keep track of the last room they were in too.
         * 
         * Whenever player1 does something, check swap the variables to false and true accordingly?
         */ 
        boolean player1Turn = false;
        boolean player2Turn = false;

        boolean globalTurn = player1Turn;

        

        if (player1Turn == true) 
        {
            player2Turn = false;
        }

        else if (player2Turn == true) 
        {
            player1Turn = false;
        }
    }
    

    /**
     * If the player opts to attack, damage their opponent.
     * @param player1
     * @param player2
     */
    public static void pvpAttack(Characters player1, Characters player2)
    {
        System.out.println(player1.getName() + " attacks " + player2.getName() + " for " 
        + player1.getAttack() + " DAMAGE!");

        int player2Health = player2.getHealth();
        int player2Defense = player2.getDefense();
        int player1Attack = player1.getAttack();

        player1.attack(player2Health, player2Defense);
        player2.takeDamage(player1Attack);
    }

    /**
     * If the player opts to use an item, use the item duh.
     * @param player1
     * @param player2
     */
    public static void pvpUseItem(Characters player1, Characters player2)
    {
        // Will come back to this after I figure out the items and Items class.
    }

}