package university.jala.Legion.troopsType;

public class Tank extends Troop {
    public Tank(char letter, int numeric,int row, int col) {
        super(letter, numeric, row, col);
    }
    @Override
    public String getLetter() {
        return "T";
    }

    @Override
    public int getNumber() {
        return 20;
    }
}
