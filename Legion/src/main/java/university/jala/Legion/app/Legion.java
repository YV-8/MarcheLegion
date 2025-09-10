package university.jala.Legion.app;
import university.jala.Legion.Board.ManageBoard;
import university.jala.Legion.algorithm.Algorithm;
import university.jala.Legion.orientation.Orientation;
import university.jala.Legion.troopsType.troopsUnit.TypeTroop;
import java.util.List;

public class Legion {
    private final ManageBoard manageBoard;
    public Legion (Algorithm algorithm, TypeTroop typeTroop, List<Integer> troops, int fieldSize, Orientation orientation, int time) {
        this.manageBoard= new ManageBoard(algorithm, typeTroop,troops,fieldSize,orientation,time);
    }
    public void startApp(int limitParameter, int validParameters, int time){
        if(validParameters ==limitParameter){
            long totalStartTime = System.currentTimeMillis();
            manageBoard.setTroops();
            manageBoard.printBoardRandom();
            countTime();
            System.out.println();

            long totalEndTime = System.currentTimeMillis();
            long totalElapsedTime = totalEndTime - totalStartTime;
            System.out.println("total time: "+ totalElapsedTime + "miliseconds");
        }
    }
    public void countTime(){
        manageBoard.sortBoard();
    }
}
