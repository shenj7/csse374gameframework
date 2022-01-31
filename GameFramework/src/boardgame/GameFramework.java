package boardgame;

import java.util.ArrayList;
import java.util.Scanner;

import boardgame.model.Board;
import boardgame.model.Unit;

public abstract class GameFramework {
	
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
		this.createBoard();
		this.gameStart();
	}

	protected abstract void welcome();
	
	protected abstract int getNumUsers();

	protected void getUsers() {
		this.users.add(scanner.nextLine());
	}
	
    protected abstract Board createBoard();
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
	
	protected void doTurn(Unit u) {
		String move = scanner.nextLine();
		if (move.equals("move")) {
			moveUnit(u);
		} else if (move.equals("add")) {
			addUnit(u);
		} else if (move.equals("remove")) {
			removeUnit(u);
		} else {
			System.out.println("invalid move");
			doTurn(u);
		}

	}
	
    abstract int moveUnit(Unit u);
    abstract int addUnit(Unit u);
    abstract int removeUnit(Unit u);
    
	protected abstract void showResult();
	//End game logic


}
