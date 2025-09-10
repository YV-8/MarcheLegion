package university.jala.Legion.troopsType;

public class Commander extends Troop {
    public Commander(char letter, int numeric,int row, int col) {
        super(letter, numeric, row, col);
    }

    @Override
    public String getLetter() {
        return "C";
    }

    @Override
    public int getNumber() {
        return 0;
    }
}
