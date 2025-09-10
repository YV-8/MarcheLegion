package university.jala.Legion.troopsType;

public class Infantry extends Troop {
    public Infantry(char letter, int numeric,int row, int col) {
        super(letter, numeric, row, col);
    }
    @Override
    public String getLetter() {
        return "I";
    }

    @Override
    public int getNumber() {
        return 40;
    }
}
