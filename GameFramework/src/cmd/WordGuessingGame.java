package cmd;

import com.mashape.unirest.http.Unirest;

import java.util.Random;

public class WordGuessingGame extends Game {
	private boolean active;
	private String winner;
	
	private int currAttempt;
	private int maxAttempts;
	
	private String plainTextWord;
	private String maskedWord;
	
	
	public WordGuessingGame() {
		this.currAttempt = 1;
		this.winner = "";
		this.active = true;
	}
	
	private void retrieveWordOnline() throws Exception {
		String apiEndPoint = "http://watchout4snakes.com/wo4snakes/Random/RandomWord";
		this.plainTextWord = Unirest.post(apiEndPoint)
									.asString()
									.getBody();
	}
	
	private void codify() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.plainTextWord.charAt(0));
		Random random = new Random();
		for(int i = 1; i < this.plainTextWord.length(); ++i) {
			if(random.nextBoolean()) 
				buffer.append(this.plainTextWord.charAt(i));
			else
				buffer.append('_');
		}
		this.maskedWord = buffer.toString();
	}

	protected boolean isActive() {
		return this.active;
	}
	
	@Override
	protected void welcome() {
		System.out.println("Welcome to the Word Guessing game!");

	}

	@Override
	protected int getNumUsers() {
		System.out.println("How many users?");
		return Integer.parseInt(scanner.nextLine());
	}

	@Override
	protected void provideInstructions() {
		System.out.println("How many attempts?");
		maxAttempts = Integer.parseInt(scanner.nextLine());
		try {
			this.retrieveWordOnline();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.codify();
		
	}

	@Override
	protected boolean isEnd() {
		return !(this.isActive() && currAttempt <= maxAttempts);
	}

	@Override
	protected void doTurn() {
		for (String user: users) {
			System.out.println("Here is the partly completed word: " + this.maskedWord);
			System.out.format("[User %s, Guess %d of %d]%nWhat is the word? ", user, currAttempt, this.maxAttempts);
			String option = scanner.nextLine();
			option = option.toLowerCase();

			if(option.equals(this.plainTextWord)) {
				this.active = false;
				this.winner = user;
			}
			else {
				System.out.println("Not quite right!");
			}

			System.out.println();
		}

		++currAttempt;
	}

	@Override
	protected void showResult() {
		if(!this.winner.equals("")) {
			System.out.println("Well done, " + this.winner + "!");
		}
		else {
			System.out.println("Oops, nobody won! The correct answer is: " + this.plainTextWord);
		}
	}
}
