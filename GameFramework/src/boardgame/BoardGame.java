package boardgame;

import boardgame.model.Board;
import boardgame.model.Unit;
import cmd.Game;

public class BoardGame extends Game implements GameFramework{
	Unit currentlySelectedUnit;

	@Override
	public Board createBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doTurn() {
		String move = scanner.nextLine();
		if (move.equals("move")) {
			moveUnit();
		} else if (move.equals("add")) {
			addUnit(currentlySelectedUnit);
		} else if (move.equals("remove")) {
			removeUnit(currentlySelectedUnit);
		} else {
			System.out.println("invalid move");
			doTurn();
		}
	}

	@Override
	public void moveUnit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addUnit(Unit u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeUnit(Unit u) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	protected void welcome() {
		// TODO Auto-generated method stub
		createBoard();
		
	}

	@Override
	protected int getNumUsers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void provideInstructions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void showResult() {
		// TODO Auto-generated method stub
		
	}

}
