package university.jala.Legion.utilies;

import university.jala.Legion.Board.ManageArguments;
import java.util.ArrayList;
import java.util.List;

public class TroopValidator implements ManageArguments<List<Integer>> {
    int totalTroops;
    List<Integer> troops = new ArrayList<>();
    boolean errorFound= false;
    public TroopValidator() {
    }
    public int parseInt (String args){
        int numTroops;
        try{
             numTroops= Integer.parseInt(args);
        }catch(Exception e){
            return numTroops=-1;
        }
        return numTroops;
    }

    @Override
    public List<Integer> validate(String arg) {
        String[] values = arg.split(",");
        List<Integer> result = new ArrayList<>();
        for (String value : values) {
            result.add(parseInt(value));
        }
        if(result.size() != 5) {
            errorFound= true;
            result = null;
        }else{
            result.add(sumTroops(result));
        }
        return result;
    }

    public int sumTroops(List<Integer> troops){
        for (Integer troop : troops) {
            if (troop < 0) {
                errorFound = true;
            } else {
                totalTroops = totalTroops + troop;
            }
        }
        return  totalTroops;
    }

    @Override
    public String toString() {
        String result;
        if(!errorFound && totalTroops != 0) {
            result = "Troops:" + "[" + sumTroops(troops) + "]";
        }else{
            result = "Troops: [Invalid]";
        }
        return result;
    }
}
