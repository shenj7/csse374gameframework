package cmd;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Game {
	public Scanner scanner;
	public ArrayList<String> users;
	public int numUsers;

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

	public abstract void welcome();
	
	public abstract int getNumUsers();

	public void getUsers() {
		this.users.add(scanner.nextLine());
	}
	//End user init
	
	//Game logic
	public void gameStart() {
		this.provideInstructions();
		while (!isEnd()) {
			this.doTurn();
		}
		this.showResult();
	}
	
	public abstract void provideInstructions();
	
	public abstract boolean isEnd();
	
	public abstract void doTurn();
	
	public abstract void showResult();
	//End game logic
	
	
}
