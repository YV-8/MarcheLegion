package university.jala.Legion.algorithm;

import university.jala.Legion.Board.ManageBoard;
import university.jala.Legion.desingPatterns.TimeSingleton;
import university.jala.Legion.troopsType.Troop;
import java.util.List;

public interface ChooseAlgorithm {
    /**
     * Sort a list depending on the type of algorithm
     *
     * @param board List of parts to order
     */
    void sort(List<Troop> board, ManageBoard manageBoard, int time, TimeSingleton timeSingleton );
}
