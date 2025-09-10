package university.jala.Legion.troopsType;

public class Medic extends Troop {
    public Medic(char letter, int numeric,int row, int col) {
        super(letter, numeric, row, col);
    }
    @Override
    public String getLetter() {
        return "M";
    }

    @Override
    public int getNumber() {
        return 10;
    }
}
