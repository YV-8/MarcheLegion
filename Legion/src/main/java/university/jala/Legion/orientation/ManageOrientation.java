package university.jala.Legion.orientation;

import university.jala.Legion.troopsType.Troop;
import university.jala.Legion.troopsType.troopsUnit.TypeTroop;

import java.util.List;

public class ManageOrientation  {
    protected Orientation orientation;
    protected int boardSize;
    BoardStructure boardStructure;
    protected TypeTroop typeTroop;
    protected List<List<Troop>> boardToPrint;

    public ManageOrientation(Orientation orientation, int boardSize, TypeTroop typeTroop, List<List<Troop>> boardToPrint) {
        this.orientation = orientation;
        this.boardSize = boardSize;
        this.typeTroop = typeTroop;
        this.boardToPrint = boardToPrint;
    }

    /**
     * In chooseOrientation selection the row and col
     * startRow  is the number start the row
     * startCol  is the number start the col
     * endRow  is the number end the row
     * endCol  is the number end the col
     * startRowOrCol  is for start j or i
     */
    public void chooseOrientation(){
        boardStructure = new BoardStructure(boardSize,typeTroop,boardToPrint, orientation.getStartRow(boardSize),
                orientation.getStartColumn(boardSize), orientation.getEndRow(boardSize),
                orientation.getEndColumn(boardSize), orientation.isRowFirst());
        boardStructure.printStructureBoard();
    }
}
