package cmd;

public class GameFramework {
	public void play(String gameType) throws Exception {
		if(gameType.equals("numberguessing")) {
			NumberGuessingGame game = new NumberGuessingGame();
			game.playGuess();
		}
		else if(gameType.equals("wordguessing")) {
			WordGuessingGame game = new WordGuessingGame();
			game.launch(3);
		}
		else {
			System.err.println("Undefined game type.");
		}
	}
}
