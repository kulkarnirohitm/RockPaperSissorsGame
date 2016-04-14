package rockpapersissors;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This is the main controller class to play the RockPaperSissor game
 */
public class RockPaperSissor {

    private Player player;
    private RecommendationEngine engine;
    private HashMap<Decisions, Integer> statistics = new HashMap<Decisions, Integer>();

    public RockPaperSissor(Strategy strategy){
        player = new Player();
        engine = new RecommendationEngine(strategy,player);

        for(Decisions decision : Decisions.values()){
            statistics.put(decision, new Integer(0));
        }
    }

    /**
     * Runs one round of the RockPaperSissor game
     * Gets player choice and engine choice, decides winner, 
     * updates player move history and statistics 
     * @param playerInput Character entered by player as player choice for this round
     */
    private void playOneRound(char playerInput){
        Choices playerChoice = player.getPlayerChoice(playerInput);
        if(playerChoice == null){
            return;
        }

        Choices engineChoice = engine.getComputerChoice();

        Decisions gameDecision = Choices.decideWinner(playerChoice,engineChoice);

        String decisionMsg = null;
        if(gameDecision == Decisions.TIE){
            decisionMsg = "It's a Tie!";
        }else if(gameDecision == Decisions.WIN){
            decisionMsg = "You Win!";
        }else{
            decisionMsg = "I Win!";
        }

        System.out.println("I chose " + engineChoice.toString() + ". " + decisionMsg);

        player.updateMoveRecord(playerChoice);
        updateStatistics(gameDecision);
        printStatistics();
    }

    /**
     * Updates current round result to overall statistics
     * @param roundDecision current round result
     */
    private void updateStatistics(Decisions roundDecision){
        Integer count = statistics.get(roundDecision) + 1;
        statistics.put(roundDecision, count);
    }

    /**
     * Prints the statistics on screen
     */
    private void printStatistics(){
        System.out.println("You won " + statistics.get(Decisions.WIN) + " times.");
        System.out.println("You lost " + statistics.get(Decisions.LOOSE) + " times.");
        System.out.println("We tied " + statistics.get(Decisions.TIE) + " times.");
    }

    /**
     * Keeps playing the RockPaperSissor game until player asks to stop
     */
    public void play(){
        char input = 'a';
        char playerInput = 'a';
        Scanner in = new Scanner(System.in);
        while(input != 'q'){
            System.out.println("Enter your choice (options : r=rock, p=paper, s=sissor) : ");
            playerInput = in.next().toLowerCase().charAt(0);
            playOneRound(playerInput);
            System.out.println("Do you want to continue playing? Enter 'q' to quit and any other key to continue");
            input = in.next().toLowerCase().charAt(0);
        }
        in.close();
    }

}
