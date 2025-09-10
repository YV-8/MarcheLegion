package university.jala.Legion.utilies;

import university.jala.Legion.troopsType.troopsUnit.TypeTroopsValidator;

public class Printer {
    private final AlgorithmValidator algorithm;
    private final TypeTroopsValidator typeTroop;
    private final BoardValidator  board;
    private final FieldSizeValidator fieldSize;
    private final TimeValidator time;
    private final OrientationValidator orientation;
    public Printer(AlgorithmValidator algorithm, TypeTroopsValidator typeTroop, BoardValidator board, TimeValidator time, OrientationValidator orientation, FieldSizeValidator fieldSize) {
        this.algorithm = algorithm;
        this.typeTroop = typeTroop;
        this.board = board;
        this.fieldSize = fieldSize;
        this.time = time;
        this.orientation = orientation;
    }
    public void printDetails(boolean errorInTroops) {
        System.out.println(algorithm.toString());
        System.out.println(typeTroop.toString());
        if(errorInTroops){
            System.out.println("Troops: [Invalid]");
        }else{
            System.out.println(board.toString());
        }
        System.out.println(fieldSize.toString());
        System.out.println(orientation.toString());
        System.out.println(time.toString());
    }
    public void printInvalid() {
        String invalid = "[Invalid]";
        System.out.println("Algorithm: " + invalid);
        System.out.println("Troops: " + invalid);
        System.out.println("Unit: " + invalid);
        System.out.println("BattleField: t " + invalid);
        System.out.println("Orientation: " + invalid);
        System.out.println("Time: " + invalid);
    }
    public void exceptionNull(String parameter) {
        System.out.println(parameter + "[Invalid]");
    }
}
