package rockpapersissors;

public enum Choices {
	ROCK,
	PAPER,
	SISSOR;
	
	/**
	 * Decides winner given the player's Choice and Computer's choice
	 * @param playerChoice
	 * @param engineChoice
	 * @return Decision of the current round
	 */
	public static Decisions decideWinner(Choices playerChoice, Choices engineChoice){
		if(playerChoice == engineChoice){
			return Decisions.TIE;
		}
		
		switch(playerChoice){
		
		case ROCK:
			return engineChoice == Choices.PAPER ? Decisions.LOOSE : Decisions.WIN;
		
		case PAPER:
			return engineChoice == Choices.SISSOR ? Decisions.LOOSE : Decisions.WIN;
			
		case SISSOR:
			return engineChoice == Choices.ROCK ? Decisions.LOOSE : Decisions.WIN;
		
		default:
			return Decisions.TIE;
		}
		
	}
}
