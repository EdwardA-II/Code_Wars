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
//            e.printStackTrace(); // May need to change to tell me which exact error it throws.
                                        // or maybe not since it should work with the simple print statement above.
//        }

        GameManager gameManager = new GameManager();

        System.out.println("******** WELCOME TO CODE COMBAT ********");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter \"START\" to Play! ");
        String userInput = sc.nextLine();

        // Check if input is valid.
        // Updated to receive new value after being validated. May need to change back to no reassignment.
        userInput = userInputValid(userInput, sc);

        // Print rules and mechanics.
//        System.out.println();
//        printRulesMechanics();

        // Print Classes and Characters.
//        System.out.println();
//        printClassesCharacters();
        // idk why but these two methods are randomly giving me issues again. smh.

        // Create Characters.
        ArrayList<Characters> allCharacters = createCharacters();

        // Player objects creation.
        Player player1 = new Player();
        Player player2 = new Player();

        // Prompt for Character Selection. Assign them to their respective variables.
        System.out.println("*PLAYER 1*");
        String player1CharacterChoice = promptForCharacter(sc);
        Characters player1Character = findCharacterSelection(allCharacters, player1CharacterChoice);
        player1.assignCharacter(player1Character);

        String player2CharacterChoice = promptForCharacter(sc);
        Characters player2Character = findCharacterSelection(allCharacters, player2CharacterChoice);
        player2.assignCharacter(player2Character);

        // Begin the match!
        playerVsPlayerMatch(player1, player2); // Update to include multi-player matches as well.

        sc.close();

    }

    /**
     * Check if input is valid by seeing if it matches all the possible correct inputs.
     *
     * @param input - What the user entered into the terminal.
     * @param sc - The scanner to read the new input from the user (repeatedly).
     *           
     * @return input - the player's choices(s) after being verified as valid input. 
     */
    public static String userInputValid(String input, Scanner sc) {
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
        while ( !menuInputs.contains(input) && !characterInputs.contains(input) && !actionInputs.contains(input)) {
            System.out.println("INVALID INPUT! Please try again: ");
            input = sc.nextLine();
        }
        
        return input;


    }

    /**
     * Plays in-game music depending on what's happening.
     *
     * @throws IOException
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     *
     */
    public static void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Make this into a CLASS? bc you need to...
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
     * @return userSelect - Character Name that the player chose.
     */
    public static String promptForCharacter(Scanner sc) {
        // Prompt for Character Selection.
        System.out.print("Choose your CHARACTER (ALL CAPS!): ");
        String userSelect = sc.nextLine();

        // Need to reassign the user's input, otherwise if user enters wrong name, userSelect is never changed.
        userSelect = userInputValid(userSelect, sc);

        System.out.println("You selected: " + "[ " + userSelect + " ]");
        System.out.println();

        return userSelect;
    }

    private static Characters findCharacterSelection(ArrayList<Characters> charactersList, String playerCharacterChoice) {
        Characters playersCharacterChoice = null;

        for (int i = 0; i < charactersList.size(); i++) {
            Characters currentCharacter = charactersList.get(i);

            if ( playerCharacterChoice.equals(currentCharacter.getName()) ) {
                playersCharacterChoice = charactersList.get(i); // Assign Character once name has been matched.
            }
        }
        return playersCharacterChoice;
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
        Characters Atlas = new Tank("ATLAS");
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
    public static void playerVsPlayerMatch(Player player1, Player player2) {
        Scanner action = new Scanner(System.in);

        Characters player1Character = player1.getPlayerCharacter();
        Characters player2Character = player2.getPlayerCharacter();

        System.out.println("* * * * * * * * * * MATCH BEGIN * * * * * * * * * *");

        String playerAction = "";

        String whoseTurn = "Player 1";

        // Create a Player object to assign whose turn it is.
        // Player 1 always goes first (for now).
        Player currentPlayer = player1;
        Player otherPlayer = player2;


        // Player 1's scenario.
        while ( !(playerAction.equals("QUIT")) ) {

            System.out.println(player1Character.getName() + " HP: " + player1Character.getHealth());
            System.out.println(player2Character.getName() + " HP: " + player2Character.getHealth());

            System.out.print(whoseTurn + " make your move: ");
            System.out.println("Your options are: ATTACK | USE ITEM | SPECIAL MOVE");
            System.out.println();

            if ( whoseTurn.equals("Player 1") ) {
                whoseTurn = "Player 2";
            }
            else if ( whoseTurn.equals("Player 2") ) {
                whoseTurn = "Player 1";
            }

            playerAction = action.nextLine();
            userInputValid(playerAction, action);
            System.out.println();

            // Player ATTACKS scenario...
            if (playerAction.equals("ATTACK")) {
                pvpAttack(currentPlayer.getPlayerCharacter(), otherPlayer.getPlayerCharacter());
                GameManager.switchTurn(currentPlayer, otherPlayer);
                currentPlayer = GameManager.PlayersArray[0];
                otherPlayer = GameManager.PlayersArray[1];
            }


            // Player USE ITEM scenario...
            if (playerAction.equals("USE ITEM")) {
                // Tell them what items they can use (for loop?).
                System.out.println("Which item would you like to use? Your inventory includes...");

                // And them use them accordingly... but how tho?
            // switchTurn goes here;
            }
        }


    }


    /**
     * If the player opts to attack, damage their opponent.
     * @param currentPlayer
     * @param otherPlayer
     */
    public static void pvpAttack(Characters currentPlayer, Characters otherPlayer) {
        System.out.println(currentPlayer.getName() + " attacks " + otherPlayer.getName() + " for "
        + currentPlayer.getAttack() + " DAMAGE!");
        System.out.println();

        int player2Health = otherPlayer.getHealth();
        int player2Defense = otherPlayer.getDefense();
        int player1Attack = currentPlayer.getAttack();

        currentPlayer.attack(player2Health, player2Defense);
        otherPlayer.takeDamage(player1Attack);
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