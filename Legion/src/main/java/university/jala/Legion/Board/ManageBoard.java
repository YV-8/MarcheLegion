package university.jala.Legion.Board;

import university.jala.Legion.desingPatterns.TimeSingleton;
import university.jala.Legion.orientation.*;
import university.jala.Legion.algorithm.*;
import university.jala.Legion.desingPatterns.AlgorithmFactory;
import university.jala.Legion.troopsType.*;
import university.jala.Legion.troopsType.troopsUnit.TypeTroop;
import java.util.*;

public class ManageBoard {
    private final TypeTroop typeTroop;
    private final Orientation orientation;
    private final List<Integer> troops;
    private final List<Troop> board;
    private final List<int []> unusedPositions= new ArrayList<>();
    private final int boardSize;
    private TimeSingleton timeSingleton;
    private final ChooseAlgorithm algorithm;
    private final int time;
    public ManageBoard(Algorithm typeAlgorithm, TypeTroop typeTroop, List<Integer> troops, int boardSize,Orientation orientation,int time) {
        this.typeTroop = typeTroop;
        this.troops = troops;
        board = new ArrayList<>();
        this.boardSize = boardSize;
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                unusedPositions.add(new int[]{i,j});
                board.add(null);
            }
        }
        this.orientation = orientation;
        this.algorithm = AlgorithmFactory.createAlgorithm(typeAlgorithm);
        this.time = time;
    }

    /**
     * row is row enter between each row
     * col is column each  col between this row
     * In the switch can choose which row and take that type troop
     * boardPosition  is the random coordinate multiplicate for an atribute
     * board is the size  assign
     * boardSize the Size that it had calculate
     * then sum this position un row + position in col
     * last change de position and the type troop
     */
    public void setTroops(){

        for(int row = 0; row < troops.size(); row++){
            for(int col = 0; col < troops.get(row); col++){
                Troop troop = null;
                int [] randomCoordinate = getRandomPosition();
                switch (row) {//troops.get(i)
                    case 0:
                        troop = new Commander('C',10,randomCoordinate[0],randomCoordinate[1]);
                        break;
                    case 1:
                        troop= new Medic('M',20,randomCoordinate[0],randomCoordinate[1]);
                        break;
                    case 2:
                        troop= new Tank('T',30,randomCoordinate[0],randomCoordinate[1]);
                        break;
                    case 3:
                        troop = new Sniper('S',40,randomCoordinate[0],randomCoordinate[1]);
                        break;
                    case 4:
                        troop = new Infantry('I',50,randomCoordinate[0],randomCoordinate[1]);
                        break;
                    default:
                        break;
                }
                int boardPosition = (randomCoordinate[0]* (board.size()/ boardSize ))+ randomCoordinate[1];
                board.set(boardPosition,troop);
            }
        }
    }
    public int [] getRandomPosition (){
        int positionIndex = (int)(Math.random() *unusedPositions.size());
        return unusedPositions.remove(positionIndex);
    }
    /**
     *  boardToPrint is the troops that will be print
     * boardSize is square root of the board's size
     * i is the counter row
     *  j is the counter columm
     * This for get of i -> j the first and print until finished the counter column
     * Then Troop remove the first indice to print
     */
    public void printBoardRandom() {
        List<Troop> boardToPrint = new ArrayList<>(board);
        System.out.println();
        printDetailsDecored();
        for (int i = 0; i < boardSize; i++) {
            System.out.print("|");
            for (int j = 0; j < boardSize; j++) {
                Troop t = boardToPrint.removeFirst();
                String content = (t != null) ? String.valueOf(typeTroop == TypeTroop.C ? t.getLetter(): t.getNumber()) : " ";
                System.out.printf(" %s |", content);
            }
            System.out.println();
            printDetailsDecored();
        }
        algorithm.sort(board,this,time,timeSingleton);

    }
    public  void sortBoard(){
        algorithm.sort(board,this,time,timeSingleton);
    }
    public void printDetailsDecored(){
        System.out.print("+");
        for (int counter = 0; counter < boardSize; counter++) {
            System.out.print("---+");
        }
        System.out.println();
    }

    /**
     *  apply the same logic to actual state
     * typeCounts is who count type of troop  that use
     * This only copy the list of troops
     * the type is counter for type troop
     * type 0 is Commander...
     */
    public void printIntermediateBoard(List<Troop> currentBoardState) {
        List<List<Troop>> tempSortedBoard = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            tempSortedBoard.add(new ArrayList<>(Collections.nCopies(boardSize, null)));
        }

        int size = currentBoardState.size();
        for (int type = 0; type < boardSize * boardSize; type++) {
            int row = type / boardSize;
            int col = type % boardSize;
            Troop troop = (type<size)? currentBoardState.get(type):null;
            tempSortedBoard.get(row).set(col,troop);
        }
        printFormattedBoard(tempSortedBoard);
    }
    /**
     * this method order the space between  the troop
     * they're order first and then the free spaces
     * @param board is the troop sorted
     * type is the type troop
     * currentIndex is de actual index means where is the List
     * pos is position
     * "for" nested verification that pos is minor that count is it's not change de row
     * typeCounts will be minor that board size
     */
    public void sortTroopToBoard(List<Troop> board) {
        List<List<Troop>> sortedBoard = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            sortedBoard.add(new ArrayList<>(Collections.nCopies(boardSize, null)));
        }
        int typeCounts =0 ;
        int [] currentIndex = new int[troops.size()];
        for(int j = 0; j < troops.size(); j++){
            currentIndex[j] = troops.get(j);
        }
        for (int type = 0; type < currentIndex.length; type++) {
            int count = currentIndex[type];
            for (int pos = 0; pos < count && typeCounts < board.size(); pos++) {
                int row = type + pos / boardSize;
                int col = pos % boardSize;
                if (row < boardSize) {
                    sortedBoard.get(row).set(col, board.get(typeCounts++));
                    //sortedBoard.get(row).set(col, board.get(typeCounts++));

                }
            }
        }
        printFormattedBoard(sortedBoard);
    }
    /**
     * This method print the formatted with a space and manage the orientation
     * @param boardToPrint is the list of list to print
     */
    public void printFormattedBoard(List<List<Troop>> boardToPrint) {
        System.out.println();
        printDetailsDecored();
        ManageOrientation manageOrientation = new ManageOrientation(orientation, boardSize, typeTroop, boardToPrint);
        manageOrientation.chooseOrientation();
    }

}