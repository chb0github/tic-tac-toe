package org.bongiorno.games.tictactoe;

/**
 * Created by cbongiorno on 1/21/16.
 */
public enum Adjacency {
    N(-1,0),
    NE(-1,1),
    E(0,1),
    SE(1,1),
    S(1,0),
    SW(1,-1),
    W(0,-1),
    NW(-1,-1),;

    private final int xDelta;
    private final int yDelta;

    Adjacency(int xDelta, int yDelta) {
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }

    public boolean areAdjacent(Square one, Square two) {
        return one.getX() - two.getX() == this.xDelta;
    }
}
