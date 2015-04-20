package org.bongiorno.algorithms.tictactoe;


public class TickTackToe {

    private int gridSize;
    private Square[][] grid;

    public TickTackToe(int gridSize) {
        this.gridSize = gridSize;
        this.grid = new Square[gridSize][gridSize];
        init();
    }

    private void init() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = new Square();
            }
        }
        createGraph();
    }

    private void createGraph() {

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length; y++) {
                Square square = grid[x][y];
                if (x < grid.length) {
                    square.setNextRow(grid[x][y]);
                    if (y < grid.length) {
                        if (x == y)
                            square.setNextDiagonal(grid[x][y]);

                        square.setNextColumn(grid[x][y]);

                    }
                }
            }

        }
    }

    public void putMark(Mark m, int x, int y) {
        Square square = grid[x][y];
        if (square.getMark() != null)
            throw new IllegalArgumentException();

        square.setMark(m);


    }

    public Mark getWinningMark() {
        Mark m = checkColumn();
        if(m == null)
            m = checkRow();
        if(m == null)
            m = checkDiagonal();
        return m;
    }

    private Mark checkRow() {
        Square last = grid[0][0];
        Square current = last;
        while(current.getMark() == last.getMark()) {
            current = current.getNextRow();

        }

        return (current == grid[gridSize -1 ][0] ? current.getMark() : null);
    }
    private Mark checkDiagonal() {
        Square last = grid[0][0];

        Square current = last;
        while(current.getMark() == last.getMark()) {
            current = current.getNextDiagonal();

        }

        return (current == grid[gridSize -1 ][gridSize -1] ? current.getMark() : null);
    }
    
    private Mark checkColumn() {
        Square last = grid[0][0];

        Square current = last;
        while(current.getMark() == last.getMark()) {
            current = current.getNextColumn();
            if(current.getMark() != last.getMark())
                break;
            last = current;
        }
            
        return (current == grid[0][gridSize -1] ? current.getMark() : null);
    }


}
