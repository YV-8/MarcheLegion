package university.jala.Legion.algorithm;

import university.jala.Legion.Board.ManageBoard;
import university.jala.Legion.desingPatterns.TimeSingleton;
import university.jala.Legion.troopsType.Troop;

import java.util.List;

public class BubbleSort implements ChooseAlgorithm {

    @Override
    public void sort(List<Troop> board, ManageBoard manageBoard,int time, TimeSingleton timeSingleton ) {
        timeSingleton = TimeSingleton.getInstance(time);
        int n = board.size();
        Troop temp;
        for (int i = 0; i < (n - 1); i++) {
            timeSingleton.startIteration();
            for(int j = 0; j < n - i - 1; j++) {
                int currentVal = board.get(j) != null ? board.get(j).getNumber() : Integer.MAX_VALUE;
                int nextVal = board.get(j + 1) != null ? board.get(j + 1).getNumber() : Integer.MAX_VALUE;
                if(currentVal > nextVal) {
                    temp = board.get(j);
                    board.set(j, board.get(j + 1));
                    board.set(j + 1, temp);
                }
            }
            timeSingleton.endIteration();
            manageBoard.printIntermediateBoard(board);
            manageBoard.sortTroopToBoard(board);
            timeSingleton.sleepToBoard();
        }
    }

}
