package university.jala.Legion.algorithm;

import university.jala.Legion.Board.ManageBoard;
import university.jala.Legion.desingPatterns.TimeSingleton;
import university.jala.Legion.troopsType.Troop;

import java.util.List;

public class InsertionSort implements ChooseAlgorithm {
    @Override
    public void sort(List<Troop> board, ManageBoard manageBoard,int time, TimeSingleton timeSingleton ) {
        timeSingleton = TimeSingleton.getInstance(time);
        for (int j = 1; j < board.size(); j++) {
            timeSingleton.startIteration();
            Troop keyTroop = board.get(j);
            if (keyTroop == null) {
                continue;
            }
            int key = keyTroop.getNumber();
            int i = j - 1;
            while (i >= 0 && ((board.get(i) == null ? Integer.MAX_VALUE : board.get(i).getNumber()) > key)) {
                board.set(i + 1, board.get(i));
                i--;
            }
            board.set(i + 1, keyTroop);
            timeSingleton.endIteration();
            manageBoard.printIntermediateBoard(board);
        }
        manageBoard.sortTroopToBoard(board);
        timeSingleton.sleepToBoard();
    }
}
