package university.jala.Legion.utilies;

import java.util.ArrayList;
import java.util.List;

public class BoardValidator {
    private int totalTroops;
    private List<Integer>  troops;
    private int boardSize = 1;
    private int sumLine;
    private List<Integer> filledLinesByTroops = new ArrayList<>();

    public BoardValidator(int totalTroops, List<Integer> troops, int boardSize) {
        this.totalTroops = totalTroops;
        this.troops = troops;
        this.boardSize = boardSize;
    }

    /**
     * verification if the number is mayor is false
     * @return
     */
    public boolean validateBoardLimit(){
        for(int i= 0; i < troops.size();i++){
            if (boardSize > 0 && boardSize< 1001){
                filledLinesByTroops.add((troops.get(i) + boardSize -1) /boardSize);
                sumLine += filledLinesByTroops.get(i);
            }
        }
        return sumLine > boardSize? true: false;
    }
    @Override
    public String toString() {
        String result = " ";
        if(sumLine> boardSize){
            result = "Troops: [Invalid]";
        }else{
            result = "Troops: ["+totalTroops+"]";
        }
        return result;
    }
}
