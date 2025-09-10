package university.jala.Legion.algorithm;

import university.jala.Legion.Board.ManageBoard;
import university.jala.Legion.desingPatterns.TimeSingleton;
import university.jala.Legion.troopsType.Troop;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements ChooseAlgorithm{
    @Override
    public void sort(List<Troop> board, ManageBoard manageBoard,int time, TimeSingleton timeSingleton ) {
        timeSingleton = TimeSingleton.getInstance(time);
        if (board == null || board.size() <= 1) return;
        List<Troop> temp = new ArrayList<>(board);
        int n = board.size();
        for (int size = 1; size < n; size *= 2) {
            timeSingleton.startIteration();
            for (int left = 0; left < n - size; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);

                mergeSections(left, mid, right, temp,board);
            }
            timeSingleton.endIteration();
            manageBoard.printIntermediateBoard(board);
            manageBoard.sortTroopToBoard(board);
            timeSingleton.sleepToBoard();
        }
    }
    private void mergeSections(int left, int mid, int right, List<Troop> temp, List<Troop> board) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            int leftVal = board.get(i) != null ? board.get(i).getNumber() : Integer.MAX_VALUE;
            int rightVal = board.get(j) != null ? board.get(j).getNumber() : Integer.MAX_VALUE;

            if (leftVal <= rightVal) {
                temp.set(k++, board.get(i++));
            } else {
                temp.set(k++, board.get(j++));
            }
        }
        while (i <= mid) {
            temp.set(k++, board.get(i++));
        }

        while (j <= right) {
            temp.set(k++, board.get(j++));
        }

        // Copiar de vuelta
        for (k = left; k <= right; k++) {
            board.set(k, temp.get(k));
        }
    }
}
