package rockpapersissors;

import java.util.Random;

/**
 * This class implements multiple strategies to play against the player
 * Given the player choice history and the strategy, 
 * this class decides the move to beat the player's choice
 */
public class RecommendationEngine {

    private final Strategy engineStrategy;
    private Player player;
    private Random selector;

    public RecommendationEngine(Strategy strategy, Player player){
        this.engineStrategy = strategy;
        this.player = player;
        this.selector = new Random();
    }

    /**
     * Returns the comuter's choice for the current round
     * depending on the strategy and player choice history
     * @return
     */
    public Choices getComputerChoice(){

        switch(engineStrategy){
        case LAST_MOVE :
            return beatPlayerChoice(player.getLastMove());
        case FAVORITE_MOVE :
            return beatPlayerChoice(player.getMostFrequentMove());
        case UNKNOWN :
            return beatPlayerWithRandomStrategy();
        default :
            return beatPlayerChoice(player.getMostFrequentMove());
        }
    }

    /**
     * Returns the Comuter's Choice for current round to beat the player using random strategy
     * @return
     */
    private Choices beatPlayerWithRandomStrategy(){
        int randomSelection = selector.nextInt(3);
        switch(randomSelection){
        case 0 :
            return beatPlayerChoice(player.getLastMove());
        case 1 :
            return beatPlayerChoice(player.getMostFrequentMove());
        case 2 :
            return beatPlayerChoice(player.getLeastFrequentMove());
        default :
            return beatPlayerChoice(player.getMostFrequentMove());
        }
    }

    /**
     * Returns the Choice that will beat the given Choice
     * @param playerChoice Choice to beat
     * @return
     */
    private Choices beatPlayerChoice(Choices playerChoice){
        switch(playerChoice){
        case ROCK :
            return Choices.PAPER;
        case PAPER :
            return Choices.SISSOR;
        case SISSOR :
            return Choices.ROCK;
        default :
            return null;
        }
    }



}
