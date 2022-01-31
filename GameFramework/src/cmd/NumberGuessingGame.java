package cmd;

public class NumberGuessingGame extends Game {
	private boolean end;
	private boolean win;
	
	private int high;
	private int low;
	private int mid;
	
	private int attempt;
	
	public NumberGuessingGame() {
		this.win = false;
		this.end = false;
	}

	
	@Override
	protected void welcome() {
		System.out.println("Welcome to the Number Guessing Game!");
		this.high = 100;
		this.low = 0;
		this.mid = (high - low) / 2;
		
		this.attempt = 0;
	}
	
	@Override
	protected int getNumUsers() {
		return 1;
	}
	
	@Override
	protected void provideInstructions() {
		System.out.println("Howdy, " + this.users.get(0) + "! Think of a number between 1-100 and I will guess it within 7 attempts.");
		System.out.println("Press return if you are ready!");
		scanner.nextLine();
	}
	
	@Override
	protected void doTurn() {
		System.out.format("[Attempt #%d] Is your number %d? Guess [high / low / correct] ", ++this.attempt, this.mid);
		String option = scanner.nextLine();
		option = option.toLowerCase();
		if(option.startsWith("h")) {
			low = mid;
		}
		else if(option.startsWith("l")) {
			high = mid;
		}
		else {
			this.win = true;
			this.end = true;
		}
		
		int delta = high - low;
		if(delta > 0) {
			this.mid = this.low + delta / 2;
		}
		else {
			this.win = false;
			this.end = true;
		}
	}

	@Override
	protected boolean isEnd() {
		return this.end;
	}
	
	@Override
	protected void showResult() {
		if(this.win) {
			System.out.format("Hurrah! I won, " + this.users.get(0) + "!");
		}
		else {
			System.out.format("Hey, " + this.users.get(0) + "! You won! Congratulations!");
		}
	}
}
