package cmd;

import java.util.Random;

public class RockPaperScissorsGame extends Game {
	private int numGames;
	private int maxGames;
	
	private int numWins;
	private int numLosses;
	
	public RockPaperScissorsGame() {
		numWins = 0;
		numLosses = 0;
		numGames = 0;
	}

	@Override
	protected void welcome() {
		System.out.println("Welcome to Rock-Paper-Scissors!");
		
	}

	@Override
	protected int getNumUsers() {
		return 1;
	}

	@Override
	protected void provideInstructions() {
		System.out.println("Hey " + users.get(0) + "!");
		System.out.println("Welcome to Rock-Paper-Scissors!");
		System.out.println("Type r for Rock, p for Paper, and s for Scissors");
		System.out.println("How many rounds?");
		maxGames = Integer.parseInt(scanner.nextLine());
	}

	@Override
	protected boolean isEnd() {
		return numGames >= maxGames;
	}

	@Override
	protected void doTurn() {
		numGames++;
		System.out.println("Enter your move:");
		scanner.nextLine();
		int win = (new Random()).nextInt(3);
		if (win == 0) {
			System.out.println("You won this round!");
			numWins++;
		} else if (win == 1) {
			System.out.println("You tied this round!");
		} else {
			System.out.println("You lost :(");
			numLosses++;
		}
		
		
	}

	@Override
	protected void showResult() {
		String result = numWins>numLosses?"You won!":"You lost :(";	
		System.out.println(result);
		
	}

}
