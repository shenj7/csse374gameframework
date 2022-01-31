package cmd;

import java.util.Scanner;

public class GamingApp {

	public static void main(String[] args) throws Exception {
		System.out.println("Type in the game you would like to play [numberguessing, wordguessing]: ");
		Scanner scanner = new Scanner(System.in);
		Game game = null;
		String gameType = scanner.nextLine();
		if(gameType.equals("numberguessing")) {
			game = new NumberGuessingGame();
		}
		else if(gameType.equals("wordguessing")) {
			game = new WordGuessingGame();
		}
		else {
			System.err.println("Undefined game type.");
			scanner.close();
			return;
		}
		game.init();
		scanner.close();
	}
}
