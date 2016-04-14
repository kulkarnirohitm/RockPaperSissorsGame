package rockpapersissors;

import java.util.HashMap;
import java.util.Random;

/**
 * This class contains all the player related data and methods
 * This class saves the player's last move and move frequency information
 */
public class Player {

    private Choices lastMove;
    private HashMap<Choices, Integer> choiceFrequency = new HashMap<Choices, Integer>();

    public Player(){
        //randomly assign a last move
        int random = new Random().nextInt(3);
        switch(random){
        case 0 :
            this.lastMove = Choices.ROCK;
            break;
        case 1 :
            this.lastMove = Choices.PAPER;
            break;
        case 2 : 
            this.lastMove = Choices.SISSOR;
            break;
        default :
            this.lastMove = Choices.ROCK;
            break;
        }

        for(Choices choice : Choices.values()){
            choiceFrequency.put(choice, new Integer(0));
        }
    }

    /**
     * Return player's choice
     * @param playerInput Character entered by player 
     * @return player's choice
     */
    public Choices getPlayerChoice(char playerInput){

        switch(playerInput){
        case 'r':
            return Choices.ROCK;
        case 'p':
            return Choices.PAPER;
        case 's':
            return Choices.SISSOR;
        default :
            System.out.println("Wrong input!");
            return null;
        }
    }

    /**
     * Returns player's last move
     * @return
     */
    public Choices getLastMove(){
        return this.lastMove;
    }

    /**
     * Returns the most frequent choice selected by player
     * @return
     */
    public Choices getMostFrequentMove(){
        Choices mostFrequentChoice = null;
        int maxFrequency = Integer.MIN_VALUE;
        for(Choices choice : choiceFrequency.keySet()){
            if(maxFrequency <= choiceFrequency.get(choice)){
                mostFrequentChoice = choice;
                maxFrequency = choiceFrequency.get(choice);
            }
        }
        return mostFrequentChoice;
    }

    /**
     * Returns the least frequent choice selected by player
     * @return
     */
    public Choices getLeastFrequentMove(){
        Choices leastFrequentChoice = null;
        int minFrequency = Integer.MAX_VALUE;
        for(Choices choice : choiceFrequency.keySet()){
            if(minFrequency >= choiceFrequency.get(choice)){
                leastFrequentChoice = choice;
                minFrequency = choiceFrequency.get(choice);
            }
        }
        return leastFrequentChoice;
    }

    /**
     * Updates the last move and move frequency with current round's player choice
     * @param playerMove player choice in current round
     */
    public void updateMoveRecord(Choices playerMove){
        lastMove = playerMove;
        Integer frequency = choiceFrequency.get(playerMove) + 1;
        choiceFrequency.put(playerMove, frequency);
    }


}
