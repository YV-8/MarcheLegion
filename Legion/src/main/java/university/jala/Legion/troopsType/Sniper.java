package university.jala.Legion.troopsType;

public class Sniper extends Troop {
    public Sniper(char letter, int numeric,int row, int col) {
        super(letter, numeric, row, col);
    }
    @Override
    public String getLetter() {
        return "S";
    }

    @Override
    public int getNumber() {
        return 30;
    }
}
