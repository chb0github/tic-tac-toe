package games.tictactoe;


public class Square {
    private Mark mark;
    private Square nextRow;
    private Square nextColumn;
    private Square nextDiagonal;

    public Square getNextRow() {
        return nextRow;
    }

    public void setNextRow(Square nextRow) {
        this.nextRow = nextRow;
    }

    public Square getNextColumn() {
        return nextColumn;
    }

    public void setNextColumn(Square nextColumn) {
        this.nextColumn = nextColumn;
    }

    public Square getNextDiagonal() {
        return nextDiagonal;
    }

    public void setNextDiagonal(Square nextDiagonal) {
        this.nextDiagonal = nextDiagonal;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "" + mark;
    }
}
