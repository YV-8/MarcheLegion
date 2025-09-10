package university.jala.Legion.troopsType;

public abstract class Troop {
    private char letter;
    private int numeric;
    private int row;
    private int col;

    public Troop(char letter, int numeric, int row, int col) {
        this.letter = letter;
        this.numeric = numeric;
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public abstract String getLetter();

    public abstract int getNumber();
}
