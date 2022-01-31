package cmd;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Game {
	protected Scanner scanner;
	protected ArrayList<String> users;
	protected int numUsers;

	//User initialization
	public void init() {
		this.users = new ArrayList<String>();
		this.scanner = new Scanner(System.in);
		this.welcome();
		this.numUsers = getNumUsers();
		for (int i = 0; i < numUsers; i++) {
			System.out.println("Enter your name:");
			this.getUsers();
		}
		this.gameStart();
	}

	protected abstract void welcome();
	
	protected abstract int getNumUsers();

	protected void getUsers() {
		this.users.add(scanner.nextLine());
	}
	//End user init
	
	//Game logic
	protected void gameStart() {
		this.provideInstructions();
		while (!isEnd()) {
			this.doTurn();
		}
		this.showResult();
	}
	
	protected abstract void provideInstructions();
	
	protected abstract boolean isEnd();
	
	protected abstract void doTurn();
	
	protected abstract void showResult();
	//End game logic
	
	
}
