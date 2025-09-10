package university.jala.Legion.utilies;

import university.jala.Legion.Board.ManageArguments;

public class TimeValidator implements ManageArguments<Object> {
    private int timeSleep = 500;
    private String time = null;
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
    public Object validate(String time) {
        this.time = time;
        int timeSleep = parseInt(this.time);
        if(timeSleep>0){
            this.timeSleep = timeSleep;
        }
        return timeSleep;
    }
    @Override
    public String toString() {
        String result = " ";
        if(this.time!=null &&  this.timeSleep>0){
            result = "Time:" + "[" + this.timeSleep + "]";
        }
        return result;
    }

}
