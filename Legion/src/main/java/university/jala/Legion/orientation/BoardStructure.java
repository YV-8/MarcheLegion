package university.jala.Legion.orientation;

import university.jala.Legion.troopsType.Troop;
import university.jala.Legion.troopsType.troopsUnit.TypeTroop;
import java.util.List;

public class BoardStructure {
    protected int boardSize;
    protected int startRow;
    protected int startColumn;
    protected int endRow;
    protected int endColumn;
    protected TypeTroop typeTroop;
    protected List<List<Troop>> boardToPrint;
    protected boolean isIJ;
    protected int countRow;
    protected int countColumn;
    protected Troop troop;
    BoardStructure(int boardSize, TypeTroop typeTroop, List<List<Troop>> boardToPrint, int startRow, int startColumn, int endRow, int endColumn, boolean isIJ) {
        this.boardSize = boardSize;
        this.typeTroop = typeTroop;
        this.boardToPrint = boardToPrint;
        this.startRow = startRow;
        this.startColumn = startColumn;
        this.endRow = endRow;
        this.endColumn = endColumn;
        this.isIJ = isIJ;
    }
    public void printStructureBoard(){
        countRow = (startRow > endRow) ? -1 : 1;
        countColumn = (startColumn > endColumn) ? -1 : 1;
        for (int i =  startRow; shouldContinue(i,countRow,endRow); i += countRow) {
            System.out.print("| ");
            for (int j = startColumn;shouldContinue(j,countColumn,endColumn); j += countColumn) {
                if (isIJ) {
                    troop = boardToPrint.get(i).get(j);
                } else {
                    troop = boardToPrint.get(j).get(i);
                }
                String unitRepresentation = (troop != null) ?
                        String.valueOf(typeTroop == TypeTroop.C ? this.troop.getLetter(): this.troop.getNumber()) : " ";
                System.out.printf("%s | ", unitRepresentation);
            }
            System.out.println();
            System.out.print("+");
            for (int counter = 0; counter < boardSize; counter++) {
                System.out.print("---+");
            }
            System.out.println();
        }
    }
    private boolean shouldContinue(int currentCell, int cellStep, int endCell) {
        return(cellStep == -1)? currentCell >= endCell: currentCell <= endCell;
    }
}
