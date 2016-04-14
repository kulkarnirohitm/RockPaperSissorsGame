package rockpapersissorstests;

import rockpapersissors.Choices;
import rockpapersissors.Player;
import rockpapersissors.RecommendationEngine;
import rockpapersissors.Strategy;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class RecommendationEngineTest {
    private RecommendationEngine testEngine;
    private Player testPlayer;

    @Before
    public void beforeTest(){
        testPlayer = new Player();
    }

    @Test
    public void testLastMoveStrategy(){
        testEngine = new RecommendationEngine(Strategy.LAST_MOVE, testPlayer);
        testPlayer.updateMoveRecord(Choices.ROCK);
        assertEquals(Choices.PAPER, testEngine.getComputerChoice());
    }

    @Test
    public void testFavoriteMoveStrategy(){
        testEngine = new RecommendationEngine(Strategy.LAST_MOVE, testPlayer);
        testPlayer.updateMoveRecord(Choices.ROCK);
        testPlayer.updateMoveRecord(Choices.PAPER);
        testPlayer.updateMoveRecord(Choices.SISSOR);
        testPlayer.updateMoveRecord(Choices.PAPER);
        assertEquals(Choices.SISSOR, testEngine.getComputerChoice());
    }
}
