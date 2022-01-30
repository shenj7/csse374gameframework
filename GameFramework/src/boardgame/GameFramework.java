package boardgame;

import boardgame.model.Board;
import boardgame.model.Unit;

public interface GameFramework {

    Board createBoard();
    int takeTurn();
    void moveUnit();
    int addUnit(Unit u);
    int removeUnit(Unit u);
    void showGameResult();

}
