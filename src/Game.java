import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import javax.sound.sampled.*;


public class Game {

    public static void main(String[] args) throws FileNotFoundException {
        // UNCOMMENT THIS BLOCK TO PLAY MUSIC.
        // Blocked off to avoid music playing everytime I run the code.
        // Move this into another method?
        
        // Play the Main Menu music.
//        try
//        {
//            playMusic();
//        }
//        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//            // System.out.println("Audio File NOT FOUND!");
//
//            e.printStackTrace(); //Tell me which exact error it throws.

        GameManager gameManager = new GameManager();
//        }

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

        // Prompt for Character Selection. Assign them to their respective variables.
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
    public static void userInputValid(String input, Scanner sc) {
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
            System.out.println("INVALID INPUT! Please try again: ");
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
    public static void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {   // Make this into a CLASS? bc you need to...
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
    public static void printRulesMechanics() throws FileNotFoundException {
        // Create a File object to hold the Rules + Mechanics file. 
        File rulesMechs = new File("Rules + Mechanics.txt");
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
    public static void printClassesCharacters() throws FileNotFoundException {
        // Create a File object to hold the Rules + Mechanics file. 
        File characterInfo = new File("Classes + Character Information.txt");
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
    public static Characters promptForCharacter(Scanner sc, ArrayList<Characters> charactersList) {
        // Prompt for Character Selection.
        System.out.print("Choose your CHARACTER (ALL CAPS!): ");
        String userSelect = sc.nextLine();
        userInputValid(userSelect, sc);

        // Iterate through Characters and assign the corresponding one.

        // Create "PlaceHolder' objects to be used within the for loop.
        Characters playersCharacterChoice = new Tank("Placeholder");
        Player thisPlayer = new Player();
        
        for (int i = 0; i < charactersList.size(); i++) {
            Characters currentCharacter = charactersList.get(i);

            if ( userSelect.equals(currentCharacter.getName()) ) {
                playersCharacterChoice = charactersList.get(i); // Assign Character once name has been matched.
                thisPlayer.assignCharacter(playersCharacterChoice); // Assign Character to Player once name has been matched.
                GameManager.setPlayers(thisPlayer); // Add the Player object to the GameManager.
            }
            /* TODO: Looks like if you enter the name wrong, it says "You selected: [ Placeholder ]" as if it didn't recognize
                to go back through the characterslist and check again.
                Might need to make this a separate method to check through the characters list. Or use .contains()?

                TODO: Oooo...maybe use Map for Player-Character pairs instead of different lists?

                TODO: Also I wanna use indexOf to avoid a for loop. This might solve my first problem as well.
             */

        }

        System.out.println("You selected: " + "[ " + playersCharacterChoice.getName() + " ]");
        System.out.println();

        
        return playersCharacterChoice; // Return Character.
    }


    /**
     * Method to create all of the Characters from the Character Interface.
     * 
     * @return allCharacters - An array of all Character objects in the game.
     */ 
    public static ArrayList<Characters> createCharacters() {
        // Character ArrayList
        ArrayList<Characters> allCharacters = new ArrayList<>();

        // Create the TANKS.
        Tank Atlas = new Tank("ATLAS");
        Characters RonnieColeman = new Tank("RONNIE COLEMAN");
        // CharacterS not Character to avoid it confusing the class for the Character wrapper class.

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
    public static void playerVersusPlayerMatch(Characters player1, Characters player2) {

        Scanner action = new Scanner(System.in);

        System.out.println("* * * * * * * * * * MATCH BEGIN * * * * * * * * * *");

        // Will need to rename this to be something more general since it will not be specific to Player.
        String player1Action = "";

        String p1p2 = "Player 1"; //TODO: Rename this variable later?


        // Player 1's scenario.
        while ( !(player1Action.equals("QUIT")) ) {

            System.out.print(p1p2 + " make your move: ");
            System.out.println("Your options are: ATTACK | USE ITEM | SPECIAL MOVE");

            if ( p1p2.equals("Player 1") ) {
                p1p2 = "Player 2";
            }
            else if ( p1p2.equals("Player 2") ) {
                p1p2 = "Player 1";

            }

            System.out.println();



            
            player1Action = action.nextLine();
            userInputValid(player1Action, action);
            System.out.println();


            // Player ATTACKS scenario...
            if (player1Action.equals("ATTACK")) {
                pvpAttack(player1, player2);
                GameManager.switchTurn();
            }


            // Player USE ITEM scenario...
            if (player1Action.equals("USE ITEM")) {
                // Tell them what items they can use (for loop?).
            System.out.println("Which item would you like to use? Your inventory includes...");

            // And them use them accordingly... but how tho?
            // checkTurn method goes here;
            }
        }

        
    }


    /**
     * If the player opts to attack, damage their opponent.
     * @param player1
     * @param player2
     */
    public static void pvpAttack(Characters player1, Characters player2) {
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
    public static void pvpUseItem(Characters player1, Characters player2) {
        // Will come back to this after I figure out the items and Items class.
    }

}