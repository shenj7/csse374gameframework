package boardgame;

import boardgame.model.Board;
import boardgame.model.Unit;

public interface GameFramework {

    public Board createBoard();
    public void moveUnit();
    public int addUnit(Unit u);
    public int removeUnit(Unit u);

}
