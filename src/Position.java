public class Position {
    private int _row;
    private int _column;

    public Position(int _row, int _column) {
        this._row = _row;
        this._column = _column;
    }

    // Getters and setters
    public int getRow() {
        return _row;
    }

    public void setRow(int row) {
        this._row = row;
    }

    public int getColumn() {
        return _column;
    }

    public void setColumn(int column) {
        this._column = column;
    }
}