package rockpapersissorstests;

import rockpapersissors.Choices;
import rockpapersissors.Player;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;

public class PlayerTest {
    private Player testPlayer;

    @Before
    public void beforeTest(){
        testPlayer = new Player();
    }

    @Test
    public void getPlayerChoiceTestWrongInput(){
        Choices playerChoice = testPlayer.getPlayerChoice('z');
        assertNull(playerChoice);
    }

    @Test
    public void getPlayerChoiceTestCorrectInput(){
        Choices playerChoice = testPlayer.getPlayerChoice('s');
        assertEquals(Choices.SISSOR, playerChoice);
    }

    @Test
    public void updateAndValidateMoveRecord(){
        testPlayer.updateMoveRecord(Choices.ROCK);
        testPlayer.updateMoveRecord(Choices.ROCK);
        testPlayer.updateMoveRecord(Choices.PAPER);
        testPlayer.updateMoveRecord(Choices.ROCK);
        testPlayer.updateMoveRecord(Choices.SISSOR);
        testPlayer.updateMoveRecord(Choices.PAPER);

        assertEquals(Choices.PAPER, testPlayer.getLastMove());
        assertEquals(Choices.ROCK, testPlayer.getMostFrequentMove());
        assertEquals(Choices.SISSOR, testPlayer.getLeastFrequentMove());
    }
}
