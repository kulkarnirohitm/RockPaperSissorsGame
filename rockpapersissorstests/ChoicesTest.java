package rockpapersissorstests;

import rockpapersissors.Choices;
import rockpapersissors.Decisions;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ChoicesTest {

    @Test
    public void testDecideWinner(){
        Decisions decision = Choices.decideWinner(Choices.ROCK, Choices.PAPER);
        assertEquals(Decisions.LOOSE,decision);
    }

    @Test
    public void testDecideWinner2(){
        Decisions decision = Choices.decideWinner(Choices.ROCK, Choices.ROCK);
        assertEquals(Decisions.TIE,decision);
    }

    @Test
    public void testDecideWinner3(){
        Decisions decision = Choices.decideWinner(Choices.SISSOR, Choices.PAPER);
        assertEquals(Decisions.WIN,decision);
    }
}
