import java.util.Scanner;
/**
 * The Toothpick Game is the the most amazing game EVER!
 * 
 * @author Sabrina Do
 */
public class TheToothpickGame
{
    public static final int EASY= 25, MEDIUM=26, HARD=27;
    
    private static boolean computerOpponent = false, randomMaximumToothpicks = false;
    
    private static String playerOne = "", playerTwo = "";
    
    private static int player1Wins = 0, player2Wins = 0, currentPlayer = 0, winsNeeded =0,toothpicksRemaining = 0, maxPerTurn = 0, compSkillLevel=0;
    public static void main (String [] args)
    {
        displayWelcomeBanner();
        getStartingInformation();           

        while (player1Wins != winsNeeded && player2Wins != winsNeeded)
            playOneGame();

        displayFinalStats();
    }

    /**
     * The displayWelcomeBanner method should be your take on a welcome message.
     * 
     * Be creative.
     */
    private static void displayWelcomeBanner()
    {
        System.out.println(".--.      .--.    .-''-.    .---.        _______      ,-----.    ,---.    ,---.    .-''-.          ,---------.    ,-----.                  ");
        System.out.println("|  |_     |  |  .'_ _   \\   | ,_|       /   __  \\   .'  .-,  '.  |    \\  /    |  .'_ _   \\         \\          \\ .'  .-,  '.               ");                             
        System.out.println("| _( )_   |  | / ( ` )   ',-./  )      | ,_/  \\__) / ,-.|  \\ _ \\ |  ,  \\/  ,  | / ( ` )   '         `--.  ,---'/ ,-.|  \\ _ \\              ");                             
        System.out.println("|(_ o _)  |  |. (_ o _)  |\\  '_ '`)  ,-./  )      ;  \\  '_ /  | :|  |\\_   /|  |. (_ o _)  |            |   \\  ;  \\  '_ /  | :              ");                            
        System.out.println("| (_,_) \\ |  ||  (_,_)___| > (_)  )  \\  '_ '`)    |  _`,/ \\ _/  ||  _( )_/ |  ||  (_,_)___|            :_ _:  |  _`,/ \\ _/  |              ");
        System.out.println("|  |/    \\|  |'  \\   .---.(  .  .-'   > (_)  )  __: (  '\\_/ \\   ;| (_ o _) |  |'  \\   .---.            (_I_)  : (  '\\_/ \\   ;               ");                           
        System.out.println("|  |/    \\|  |'  \\   .---.(  .  .-'   > (_)  )  __: (  '\\_/ \\   ;| (_ o _) |  |'  \\   .---.            (_I_)  : (  '\\_/ \\   ;                ");                          
        System.out.println("|  '  /\\  `  | \\  `-'    / `-'`-'|___(  .  .-'_/  )\\ `\"/  \\  ) / |  (_,_)  |  | \\  `-'    /           (_(=)_)  \\ `\"/  \\  ) /               ");                            
        System.out.println("|    /  \\    |  \\       /   |        \\`-'`-'     /  '. \\_/``\".'  |  |      |  |  \\       /             (_I_)    '. \\_/``\".'               ");                             
        System.out.println("`---'    `---`   `'-..-'    `--------`  `._____.'     '-----'    '--'      '--'   `'-..-'              '---'      '-----'                     ");                         
        System.out.println();
        System.out.println("                  .-'''-.    ____     _______   .-------.   .-./`) ,---.   .--.   ____      _ _    .-'''-.        ");                 
        System.out.println("                 / _     \\ .'  __ `. \\  ____  \\ |  _ _   \\  \\ .-.')|    \\  |  | .'  __ `.  ( ' )  / _     \\ ");                                                  
        System.out.println("                (`' )/`--'/   '  \\  \\| |    \\ | | ( ' )  |  / `-' \\|  ,  \\ |  |/   '  \\  \\(_{;}_)(`' )/`--'       ");                                            
        System.out.println("               (_ o _).   |___|  /  || |____/ / |(_ o _) /   `-'`\"`|  |\\_ \\|  ||___|  /  | (_,_)(_ o _).              ");                                        
        System.out.println("                (_,_). '.    _.-`   ||   _ _ '. | (_,_).' __ .---. |  _( )_\\  |   _.-`   |       (_,_). '.            ");                                        
        System.out.println("               .---.  \\  :.'   _    ||  ( ' )  \\|  |\\ \\  |  ||   | | (_ o _)  |.'   _    |      .---.  \\  :          ");           
        System.out.println("               \\    `-'  ||  _( )_  || (_{;}_) ||  | \\ `'   /|   | |  (_,_)\\  ||  _( )_  |      \\    `-'  |          ");                                         
        System.out.println("                \\       / \\ (_ o _) /|  (_,_)  /|  |  \\    / |   | |  |    |  |\\ (_ o _) /       \\       /            ");                                  
        System.out.println("                 `-...-'   '.(_,_).' /_______.' ''-'   `'-'  '---' '--'    '--' '.(_,_).'         `-...-'             ");                   
        System.out.println();
        System.out.println(",---------.    ,-----.        ,-----.  ,---------. .---.  .---. .-------. .-./`)     _______   .--.   .--.            .-_'''-.      ____    ,---.    ,---.    .-''-.   ");
        System.out.println("\\          \\ .'  .-,  '.    .'  .-,  '.\\          \\|   |  |_ _| \\  _(`)_ \\\\ .-.')   /   __  \\  |  | _/  /            '_( )_   \\   .'  __ `. |    \\  /    |  .'_ _   \\  ");
        System.out.println(" `--.  ,---'/ ,-.|  \\ _ \\  / ,-.|  \\ _ \\`--.  ,---'|   |  ( ' ) | (_ o._)|/ `-' \\  | ,_/  \\__) | (`' ) /            |(_ o _)|  ' /   '  \\  \\|  ,  \\/  ,  | / ( ` )   ' ");
        System.out.println("    |   \\  ;  \\  '_ /  | :;  \\  '_ /  | :  |   \\   |   '-(_{;}_)|  (_,_) / `-'`\"`,-./  )       |(_ ()_)              .(_,_)/___| |___|  /  ||  |\\_   /|  |. (_ o _)  | ");
        System.out.println("    :_ _:  |  _`,/ \\ _/  ||  _`,/ \\ _/  |  :_ _:   |      (_,_) |   '-.-'  .---. \\  '_ '`)     | (_,_)   __         |  |  .-----.   _.-`   ||  _( )_/ |  ||  (_,_)___| ");
        System.out.println("    (_I_)  : (  '\\_/ \\   ;: (  '\\_/ \\   ;  (_I_)   | _ _--.   | |   |      |   |  > (_)  )  __ |  |\\ \\  |  |        '  \\  '-   .'.'   _    || (_ o _) |  |'  \\   .---. ");
        System.out.println("   (_(=)_) \\ `\\\"/  \\  ) /  \\ `\"/  \\  ) /  (_(=)_)  |( ' ) |   | |   |      |   | (  .  .-'_/  )|  | \\ `'   /         \\  `-'`   | |  _( )_  ||  (_,_)  |  | \\  `-'    / ");     
        System.out.println("    (_I_)    '. \\_/``\".'    '. \\_/``\".'    (_I_)   (_{;}_)|   | /   )      |   |  `-'`-'     / |  |  \\    /           \\        / \\ (_ o _) /|  |      |  |  \\       /  ");
        System.out.println("    '---'      '-----'        '-----'      '---'   '(_,_) '---' `---'      '---'    `._____.'  `--'   `'-'              '-...-'   '.(_,_).' '--'      '--'   `'-..-'   \n\n");
    }
    
    /**
     * The getStartingInformation method, um, gets the starting information.
     * 
     * In the course of running, setGameParameters uses three helper
     * methods -- choosePlayers(), getWinsNeeded(), and choooseMaxToothpicksPerTurn()
     */
    private static void getStartingInformation()
    {
        choosePlayers();
        
        System.out.println();
        
        winsNeeded = getWinsNeeded();
        
        System.out.println();
        
        chooseMaxToothpicksPerTurn();
    }
    
    /**
     * The choosePlayers method gets player 1's name, determines whether the 
     * second player is human or computer.
     * 
     * If the second player is human, ask for their name and set that variable.
     * 
     * If the second player is a computer, have them choose a skill level to 
     * set that variable, and then set player 2's name variable to be the name
     * of that particular skill level for the computer.
     * 
     * Postcondition:  computerOpponent gets properly set;  
     * 
     *                 The player 1's name and player 2's name varaibles are set properly;  
     *                 
     *                 If playing against a computer then compSkillLevel is also
     *                 set properly.
     */
    private static void choosePlayers()
    {
        Scanner userInput = new Scanner(System.in);
        String answer = "";
        
        System.out.print("Player 1, please enter your name:  ");
        playerOne = userInput.nextLine();
        while (true)
        {
            System.out.print("\n" + playerOne + ", is player 2 going to be a human or computer opponent?");
            answer = userInput.nextLine();
        
            if (answer.equals("human"))
            {
                System.out.print("\nPlayer 2, please enter your name: ");
                playerTwo = userInput.nextLine();
                computerOpponent = false;
                break;
            }
            else if (answer.equals("computer"))
            {
                computerOpponent = true;
                break;
            }
            else
            {
                System.out.print("\nI'm sorry, " + playerOne + ", but that is an invalid choice.\nPlease either choose \"human\" or \"computer\".\n");
            }
        }
        if (computerOpponent == true)
        {
            System.out.print("\n************************\n");
            System.out.print("* Computer Skill Level *\n"); //extra note: all are characters from the TV show, the Good Place
            System.out.print("************************\n");
            System.out.print("* 1) Jason Mendoza     *\n"); 
            System.out.print("* 2) Chidi Anagonye    *\n");
            System.out.print("* 3) Janet             *\n");
            System.out.print("************************\n\n");
            while (true)
            {
                System.out.print(playerOne + ", which computer do you want to take on? ");
                compSkillLevel = userInput.nextInt();
                if (compSkillLevel==1)
                {
                    playerTwo = "Jason Mendoza";
                    compSkillLevel = EASY;
                    break;
                }
                else if (compSkillLevel==2)
                {
                    playerTwo = "Chidi Anagonye";
                    compSkillLevel = MEDIUM;
                    break;
                }
                else if (compSkillLevel==3)
                {
                    playerTwo = "Janet";
                    compSkillLevel = HARD;
                    break;
                }
                else
                {
                    System.out.print("\n" + playerOne + ", that was not one of the options! Pick 1, 2, or 3.\n\n");
                }
            }
        }
    }
   
    /**
     * The getWinsNeeded method asks player 1 how many games they are playing
     * in their series, and returns how many wins are needed for one player
     * to win the series.
     * 
     * @return an integer representing the number of wins needed in order for
     *         one player to win the whole series
     */
    private static int getWinsNeeded()
    {
        Scanner userInput = new Scanner(System.in);
        int numberOfRounds = 0;
        
        while(true)
        {
            System.out.print(playerOne + ", will you be playing best out of 1, 3, 5, or 7? ");
            numberOfRounds = userInput.nextInt();
            if (numberOfRounds == 1)
            {
                winsNeeded = 1;
                break;
            }
            else if (numberOfRounds == 3)
            {
                winsNeeded = 2;
                break;
            }
            else if (numberOfRounds == 5)
            {
                winsNeeded = 3;
                break;
            }
            else if (numberOfRounds == 7)
            {
                winsNeeded = 4;
                break;
            }
            else
                System.out.print("\nI'm sorry, " + playerOne + ", but that is an invalid choice. Please choose 1, 3, 5, or 7.\n\n");
        }
        return winsNeeded;
    }
    
    /**
     * The chooseMaxToothpicksPerTurn method asks player 1 how many toothpicks will be
     * the maximum number that they can choose per turn, or whether they
     * want the maximum randomly determined before the start of each game.
     * 
     * Postcondition:  A global boolean variable is set showing whether or not the max 
     *                 toothpicks per turn should be randomly determined before each
     *                 game.
     *                 
     *                 A global max toothpicks per turn variable is set with the 
     *                 correct maximum, but only if it is NOT being randomly determined
     *                 before each game.
     */
    private static void chooseMaxToothpicksPerTurn()
    {
        Scanner userInput = new Scanner(System.in);
        
        while(true)
        {
            System.out.print(playerOne + ", what is the maximum number of toothpicks that a player can take per turn?\nEnter 3, 4, 5, or 6 (or 0 to have it randomly chosen before each game): ");
            maxPerTurn = userInput.nextInt();
            if (maxPerTurn==3 || maxPerTurn==4 || maxPerTurn==5 || maxPerTurn==6)
                break;
            else if (maxPerTurn==0)
            {
                randomMaximumToothpicks = true;
                break;
            }
            else
                System.out.print("\nI'm sorry, " + playerOne + ", but that is an invalid choice. Please choose 3, 4, 5, 6, or 0.\n\n");
        }
    }
    
    /**
     * The playOneGame method plays a single round of the Toothpick Game from
     * start to finish.
     */
    private static void playOneGame()
    {
        initializeGame();           

        while (toothpicksRemaining > 0)
        {
            if (toothpicksRemaining == 1)
                System.out.println("\nThere is 1 toothpick remaining.");
            else
                System.out.println("\nThere are " + toothpicksRemaining + " toothpicks remaining.");        

            currentPlayerTakesTurn();

            if (toothpicksRemaining != 0)
                currentPlayer = (currentPlayer % 2) + 1; //switch current player
        }

        congratulateWinner();
    }
    
    /**
     * The initializeGame method will get a Toothpick Game ready to go.
     * 
     * A random number from 20 to 39 is generated for the number of toothpicks remaining.  
     * The result is printed to the screen.
     * 
     * A coin is flipped to see who will go first.  The result of the coin flip is 
     * output to the screen.
     * 
     * ***IF*** they have chosen to have a random amount of max toothpicks per turn, 
     * then that value needs to be generated and stored in the correct variable.
     * Only if that value was randomly generated will something be output to the screen.
     * 
     * Postcondition:  toothpicksRemaining, currentPlayer, and whatever you named the
     *                 variable holding the maximum number per turn are all properly set
     */
    private static void initializeGame()
    {
        int initialNumber = (int)(Math.random()*19)+20;
        currentPlayer = (int)(Math.random()*2)+1;
        
        System.out.print("\nThe random gnome has decided this game will be played with " + initialNumber + " toothpicks.\n");
        if (currentPlayer ==1)
            System.out.print("The random gnome has flipped a coin and... " + playerOne + " will go first.\n");
        else
            System.out.print("The random gnome has flipped a coin and... " + playerTwo + " will go first.\n");
        if (randomMaximumToothpicks==true)
        {
            maxPerTurn = (int)(Math.random()*4)+3;
            System.out.print("The random gnome had determined that each player may take up to " + maxPerTurn + " per turn.\n");
        }
        toothpicksRemaining = initialNumber;
    }
    
    /**
     * The congratulateWinner method will congratulate the winner!
     * 
     * Postcondition:  After printing to the screen a relevant congratulations,
     *                 the appropriate player's win total has been incremented.
     */
    private static void congratulateWinner()
    {
        if (currentPlayer ==1)
        {
            System.out.print("\nCongratulations " + playerOne + "! You have won this round.\n");
            player1Wins++;
        }
        else
        {
            System.out.print("\nCongratulations " + playerTwo + "! You have won this round.\n");
            player2Wins++;
        }
    }
    
    /**
     * The current player takes turn method determines who is supposed to be going
     * right now, and calls the appropriate method to make that happen.
     */
    private static void currentPlayerTakesTurn()
    {
        if (currentPlayer == 1)
            player1TakesTurn();
        else if (computerOpponent == false)
            player2TakesTurn();
        else if (compSkillLevel == EASY) 
            easyComputerTakesTurn();
        else if (compSkillLevel == MEDIUM)
            mediumComputerTakesTurn();
        else if (compSkillLevel == HARD)
            hardComputerTakesTurn();
        else
        {
            System.out.println("It should have been impossible to get here");
            System.out.println("Something is definitely wrong.");
        }
    }    
    
    /**
     * The player1TakesTurn method lets player 1, um, take a turn.
     * 
     * Postcondition:  The pile of toothpicks does not go negative.
     */
    private static void player1TakesTurn()
    {
        Scanner userInput = new Scanner(System.in);
        int num = 0;
        
        while(true)
        {
            System.out.print(playerOne + ", how many toothpicks would you like to pick?  ");
            num = userInput.nextInt();
            
            if (num>=1 && num<=maxPerTurn && num<=toothpicksRemaining)
                break;
            else
                System.out.print("\nThat is not a valid input. Please pick a number of toothpicks which is less than the maximum number of toothpicks,greater or equal to one, and less than the remaining number of toothpicks.\n\n");
        }
        toothpicksRemaining = toothpicksRemaining - num;
    }
    /**
     * The player2TakesTurn method lets player 2, well, take a turn.
     * 
     * Postcondition:  The pile of toothpicks does not go negative.
     */
    private static void player2TakesTurn()
    {
        Scanner userInput = new Scanner(System.in);
        int num = 0;
        
        while(true)
        {
            System.out.print(playerTwo + ", how many toothpicks would you like to pick?  ");
            num = userInput.nextInt();
            
            if (num>=1 && num<=maxPerTurn && num<=toothpicksRemaining)
               break;
            else
               System.out.print("\nThat is not a valid input. Please pick a number of toothpicks which is less than the maximum number of toothpicks,greater or equal to one, and less than the remaining number of toothpicks.\n\n");
        }
        toothpicksRemaining = toothpicksRemaining - num;
    }
    
    /**
     * The getRandomChoice method will return a random number of toothpicks
     * between 1 and the max per turn.  It will also never pick a random
     * number which will make the pile go negative.
     * 
     * @return an integer representing a randomly selected amount of toothpicks 
     *         from 1 to the max per turn (inclusive).  The number returned must
     *         also NOT be greater than the number of toothpicks left in the pile.
     */
    private static int getRandomChoice()
    {
        int randomChoice = 0;
        if (maxPerTurn<=toothpicksRemaining)
            randomChoice = (int)(Math.random()*(maxPerTurn-1))+1;
        else
            randomChoice = (int)(Math.random()*(toothpicksRemaining-1))+1;
        return randomChoice;
    }
    
    /**
     * The getOptimalChoice method will return the number of toothpicks that
     * needs to be taken to force a win, if it exists.
     * 
     * @return an integer representing the optimal number of toothpicks to take
     *         in order to force a win, if it exists;
     *         this will return -1 if it is impossible to force a win at this time
     */
    private static int getOptimalChoice()
    {
        if ((toothpicksRemaining % (maxPerTurn + 1))==0)
            return -1;
        else
            return (toothpicksRemaining % (maxPerTurn + 1));
    }
    
    /**
     * The easyComputerTakesTurn method will always take a random number of 
     * toothpicks and then output their choice to the screen after calling
     * getEasyTurnDescription.
     */
    private static void easyComputerTakesTurn()
    {
        int num = getRandomChoice();
        toothpicksRemaining = toothpicksRemaining - num;
        System.out.println(getEasyTurnDescription(num));
    }
    
   /**
     * getEasyTurnDescription will return a randomly selected String showing
     * what the Easy Computer decided to do this turn.  The method will be 
     * randomly choosing from at least four different possible Strings.
     * 
     * The String returned will reflect the easy computer's personality. 
     * 
     * @param  num  an integer representing the number of toothpicks which
     *              is supposed to be taken this turn
     * @return a String which describes what the easy computer does this turn
     */
    private static String getEasyTurnDescription(int num)
    {
        int random = (int)(Math.random()*4)+1;
        String response = "";
        
        if (random==1)
        {
            if (num==1)
            {
                response =  "Jason looks around hurridly, trying to get Chidi to choose for him. When he refuses, Jason guesses and just picks " + num + " toothpick.";
            }
            else
            {
                response = "Jason looks around hurridly, trying to get Chidi to choose for him. When he refuses, Jason guesses and just picks " + num + " toothpicks.";
            }
        }
        else if (random==2)
        {
            if (num==1)
            {
                response = "Having not listened to the directions, Jason is confused and thinking that he is to pick turtles. Eventually he randomly chooses " + num + " toothpick.";
            }
            else
            {
                response = "Having not listened to the directions, Jason is confused and thinking that he is to pick turtles. Eventually he randomly chooses " + num + " toothpicks.";
            }
        }
        else if (random==3)
        {
            if (num==1)
            {
                response = "Too busy watching the Jaguars play, Jason chooses " + num + " toothpick because it is a dope number.";
            }
            else
            {
                response = "Too busy watching the Jaguars play, Jason chooses " + num + " toothpicks because it is a dope number.";
            }
        }
        else
        {
            if (num==1)
            {
                response = "Jason forgot what game he is playing and has no idea what is going on. He finally picks " + num + " toothpick randomly after Eleanor chatises him.";
            }
            else
            {
                response = "Jason forgot what game he is playing and has no idea what is going on. He finally picks " + num + " toothpicks randomly after Eleanor chatises him.";
            }
        }
        return response;
    }
    
    /**
     * The mediumComputerTakesTurn method will sometimes take a random amount
     * of toothpicks and sometimes take the optimal amount.  Once determined,
     * it will use getMediumTurnDescription in order to determine what to 
     * print to the screen.
     */
    private static void mediumComputerTakesTurn()
    {
        int variabilityInteger = (int)(Math.random()*2)+1;
        int num = 0;
        
        if (variabilityInteger == 1)
            num = getRandomChoice();
        else
        {
            if (getOptimalChoice()==-1)
                num = getRandomChoice();
            else
                num = getOptimalChoice();
        }
        toothpicksRemaining = toothpicksRemaining - num;
        System.out.println(getMediumTurnDescription(num));
    }
    
    /**
     * getMediumTurnDescription will return a randomly selected String showing
     * what the Medium Computer decided to do this turn.  The method will be 
     * randomly choosing from at least four different possible Strings.
     * 
     * The String returned will reflect the easy computer's personality. 
     * 
     * @param  num  an integer representing the number of toothpicks which
     *              is supposed to be taken this turn
     * @return a String which describes what the medium computer does this turn
     */
    private static String getMediumTurnDescription(int num)
    {
        int random = (int)(Math.random()*4)+1;
        String response = "";
        
        if (random==1)
        {
            if (num==1)
            {
                response =  "Chidi has a difficult time deciding and eventually settles on choosing " + num + " toothpick.";
            }
            else
            {
                response = "Chidi has a difficult time deciding and eventually settles on choosing " + num + " toothpicks.";
            }
        }
        else if (random==2)
        {
            if (num==1)
            {
                response = "Chidi spends an hour overanalyzing what number to choose and gets a stomachache. He finally picks " + num + " toothpick.";
            }
            else
            {
                response = "Chidi spends an hour overanalyzing what number to choose and gets a stomachache. He finally picks " + num + " toothpicks.";
            }
        }
        else if (random==3)
        {
            if (num==1)
            {
                response = "After debating with himself for an extended period of time, Chidi fears making the wrong decision and eventually decides to select " + num + " toothpick.";
            }
            else
            {
                response = "After debating with himself for an extended period of time, Chidi fears making the wrong decision and eventually decides to select " + num + " toothpicks.";
            }
        }
        else
        {
            if (num==1)
            {
                response = "Chidi first tries to consult a book for hints and ultimately chooses " + num + " toothpick.";
            }
            else
            {
                response = "Chidi first tries to consult a book for hints and ultimately chooses " + num + " toothpicks.";
            }
        }
        return response;
    }
    
    /**
     * The hardComputerTakesTurn method will always try to do the optimal choice.
     * 
     * Sometimes there is no optimal choice, so it will resort to a random
     * amount instead.  
     * 
     * Once the method determines what its choice is, it will use 
     * getHardTurnDescription in order to determine what to print to the screen.
     * Unlike the Easy Computer and the Medium Computer, this computer player will
     * know whether it is playing optimally or not, so when it calls
     * getHardTurnDescription, it will also include a boolean variable 
     * relaying whether this turn he will be forcing a win or not.
     */
    private static void hardComputerTakesTurn()
    {
        int num = 0;
        boolean happy = true;
        
        if (getOptimalChoice()==-1)
        {
            num = getRandomChoice();
            happy = false;
        }
        else
        {
            num = getOptimalChoice();
        }
        toothpicksRemaining = toothpicksRemaining - num;
        System.out.println(getHardTurnDescription(num, happy));
    }
    
    /**
     * getHardTurnDescription will return a randomly selected String showing
     * what the Hard Computer decided to do this turn.
     * 
     * You are supposed to be giving each of your computer skill levels personality,
     * and that will continue here.
     * 
     * Unlike the Easy and Medium computers, however, we are building in a little 
     * extra here because the Hard computer knows whether or not it is forcing a
     * win.  
     * 
     * The computer will have four random Strings to choose from if he is happy, 
     * and four random Strings to choose from if happy is false.
     * 
     * You get to have creative license for what being happy means for your hard
     * computer.  Will it gloat?  Trash talk?  Be smug?  Brush you off like you
     * are a peon?  Be nice about it?  It is up to you.
     * 
     * Similarly, you can decide how frustrated, indifferent, angry, etc. you want
     * your Hard computer to be if he is having to choose randomly.
     * 
     * @param  num  an integer representing the number of toothpicks which
     *              is supposed to be taken this turn
     * @param  happy  a boolean representing whether the computer is happy with its
     *                selection this turn (it is forcing a win) or not (it had to 
     *                pick randomly).
     * @return a String which describes what the hard computer does this turn
     */
    private static String getHardTurnDescription(int num, boolean happy)
    {
        int random = (int)(Math.random()*4)+1;
        String response = "";
        
        if (happy)
        {
            if (random==1)
            {
                if (num==1)
                {
                    response =  "Janet immediately chooses " + num + " toothpick, which, fun fact, is the most effective move.";
                }   
                else
                {
                    response =  "Janet immediately chooses " + num + " toothpicks, which, fun fact, is the most effective move.";
                }
            }
            else if (random==2)
            {
                if (num==1)
                {
                    response = "Janet gasps with a smile and chooses " + num + " toothpick.";
                }
                else
                {
                    response ="Janet gasps with a smile and chooses " + num + " toothpicks.";
                }
            }   
            else if (random==3)
            {   
                if (num==1)
                {
                    response = "Janet happily chooses " + num + " toothpick when she realizes she is beating you.";
                }
                else
                {
                    response = "Janet happily chooses " + num + " toothpicks when she realizes she is beating you.";
                }
            }
            else
            {
                if (num==1)
                {
                    response =  "In case you were wondering, Janet chose the best choice, " + num + " toothpick, with a bright smile.";
                }
                else
                {
                   response =  "In case you were wondering, Janet chose the best choice, " + num + " toothpicks, with a bright smile.";
                }
            }
        }
        else
        {
            if (random==1)
            {
                if (num==1)
                {
                    response = "Janet is unused to the anxiety she is experiencing from choosing " + num + " toothpick.";
                }
                else
                {
                    response = "Janet is unused to the anxiety she is experiencing from choosing " + num + " toothpicks.";
                }  
             }
            else if (random==2)
            {
                if (num==1)
                {
                    response = "Because Janet can't feel sad, she screams \"BAAA\" in her approximation of human crying to show her disapproval in choosing  " + num + " toothpick.";
                }
                else
                {
                    response = "Because Janet can't feel sad, she screams \"BAAA\" in her approximation of human crying to show her disapproval in choosing  " + num + " toothpicks.";
                }
            }
            else if (random==3)
            {   
                if (num==1)
                {
                    response = "Because she is an informational delivery system, Janet is disappointed that she cannot know the optimal choice, as she selects " + num + " toothpick.";
                }
                else
                {
                    response = "Because she is an informational delivery system, Janet is disappointed that she cannot know the optimal choice, as she selects " + num + " toothpicks.";
                }
            }
            else
            {
                if (num==1)
                {
                    response = "Fun fact: Janet is destroying you in this game. She takes " + num + " toothpick.";
                }
                else
                {
                    response = "Fun fact: Janet is destroying you in this game. She takes " + num + " toothpicks.";
                }
            }
        }
        return response;
    }
     
    /**
     * The displayFinalStats method shows the results of the series of games.
     */
    private static void displayFinalStats()
    {
        String winner = "";
        String loser = "";
   
        displayFinalStatsBanner();
        if (player1Wins>player2Wins)
        {
            winner = playerOne;
            loser = playerTwo;
        }
        else
        {
            winner = playerTwo;
            loser = playerOne;
        }
        if (winner.equals(playerOne))
        {
            if (player1Wins>1)
                System.out.print(playerOne + " won " + player1Wins + " games.\n");
            else
                System.out.print(playerOne + " won " + player1Wins + " game.\n");
            if (player2Wins>1)
                System.out.print(playerTwo + " won " + player2Wins + " games.\n\n");
            else if (player2Wins == 0)
                System.out.print(playerTwo + " won no games.\n\n");
            else
                System.out.print(playerTwo + " won " + player2Wins + " game.\n\n");
        }
        else
        {
            if (player2Wins>1)
                System.out.print(playerTwo + " won " + player2Wins + " games.\n");
            else
                System.out.print(playerTwo + " won " + player2Wins + " game.\n");
            if (player1Wins>1)
                System.out.print(playerOne + " won " + player1Wins + " games.\n\n");
            else if (player1Wins==0)
                System.out.print(playerOne + " won no games.\n\n");
            else
                System.out.print(playerOne + " won " + player1Wins + " game.\n\n");
        }
        System.out.print(winner + " is the overall winner! Congratulations on destroying " + loser + " like a little human. Guess what " + loser + "? Ya basic!");
        //The above sentence is a reference to Eleanor Shellstrop in the Good Place, who says "Ya basic!" as an insult/in a condescending manner. 
        //The human part is in reference to how the demons in the Bad Place would torture humans. 
    }
    
    
    /**
     * The displayFinalStatsBanner method displays a nice-looking banner to be used at the top
     * of the output for displayFinalStats.
     * 
     * That's all.
     * 
     * Be creative.
     */
    private static void displayFinalStatsBanner()
    {
        System.out.println();
        System.out.println("    ,-----.    ,---.  ,---.   .-''-.  .-------.       ____      .---.     .---.                .-'''-.     .-''-.  .-------.   .-./`)     .-''-.     .-'''-.  ");
        System.out.println("  .'  .-,  '.  |   /  |   | .'_ _   \\ |  _ _   \\    .'  __ `.   | ,_|     | ,_|               / _     \\  .'_ _   \\ |  _ _   \\  \\ .-.')  .'_ _   \\   / _     \\ ");
        System.out.println(" / ,-.|  \\ _ \\ |  |   |  .'/ ( ` )   '| ( ' )  |   /   '  \\  \\,-./  )   ,-./  )              (`' )/`--' / ( ` )   '| ( ' )  |  / `-' \\ / ( ` )   ' (`' )/`--' ");
        System.out.println(";  \\  '_ /  | :|  | _ |  |. (_ o _)  ||(_ o _) /   |___|  /  |\\  '_ '`) \\  '_ '`)           (_ o _).   . (_ o _)  ||(_ o _) /   `-'`\"`. (_ o _)  |(_ o _).    ");
        System.out.println("|  _`,/ \\ _/  ||  _( )_  ||  (_,_)___|| (_,_).' __    _.-`   | > (_)  )  > (_)  )            (_,_). '. |  (_,_)___|| (_,_).' __ .---. |  (_,_)___| (_,_). '.  ");
        System.out.println(": (  '\\_/ \\   ;\\ (_ o._) /'  \\   .---.|  |\\ \\  |  |.'   _    |(  .  .-' (  .  .-'           .---.  \\  :'  \\   .---.|  |\\ \\  |  ||   | '  \\   .---..---.  \\  : ");
        System.out.println(" \\ `\"/  \\  ) /  \\ (_,_) /  \\  `-'    /|  | \\ `'   /|  _( )_  | `-'`-'|___`-'`-'|___         \\    `-'  | \\  `-'    /|  | \\ `'   /|   |  \\  `-'    /\\    `-'  | ");
        System.out.println("  '. \\_/``\".'    \\     /    \\       / |  |  \\    / \\ (_ o _) /  |        \\|        \\         \\       /   \\       / |  |  \\    / |   |   \\       /  \\       /  ");
        System.out.println("    '-----'       `---`      `'-..-'  ''-'   `'-'   '.(_,_).'   `--------``--------`          `-...-'     `'-..-'  ''-'   `'-'  '---'    `'-..-'    `-...-'   ");
        System.out.println();
        System.out.println("                                        .-------.        .-''-.     .-'''-.   ___    _   .---. ,---------.   .-'''-.   ");
        System.out.println("                                        |  _ _   \\     .'_ _   \\   / _     \\.'   |  | |  | ,_| \\          \\ / _     \\   ");
        System.out.println("                                        | ( ' )  |    / ( ` )   ' (`' )/`--'|   .'  | |,-./  )  `--.  ,---'(`' )/`--' ");                 
        System.out.println("                                        |(_ o _) /   . (_ o _)  |(_ o _).   .'  '_  | |\\  '_ '`)   |   \\  (_ o _).  ");
        System.out.println("                                        | (_,_).' __ |  (_,_)___| (_,_). '. '   ( \\.-.| > (_)  )   :_ _:   (_,_). '.  ");
        System.out.println("                                        |  |\\ \\  |  |'  \\   .---..---.  \\  :' (`. _` /|(  .  .-'   (_I_)  .---.  \\  :");
        System.out.println("                                        |  | \\ `'   / \\  `-'    /\\    `-'  || (_ (_) _) `-'`-'|___(_(=)_) \\    `-'  |  ");                                                  
        System.out.println("                                        |  |  \\    /   \\       /  \\       /  \\ /  . \\ /  |        \\(_I_)   \\       /  ");
        System.out.println("                                        ''-'   `'-'     `'-..-'    `-...-'    ``-'`-''   `--------`'---'    `-...-'");                                   

    }
}
