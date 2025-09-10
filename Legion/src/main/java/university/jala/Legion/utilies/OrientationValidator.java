package university.jala.Legion.utilies;

import university.jala.Legion.orientation.Orientation;
import university.jala.Legion.Board.ManageArguments;

public class OrientationValidator implements ManageArguments<Orientation> {
    Orientation orientation = null;
    public OrientationValidator() {}
    @Override
    public Orientation validate(String arg) {
        for(Orientation orientation : Orientation.values()){
            if(orientation.getOrientation().equalsIgnoreCase(arg)){
                this.orientation = orientation;
                break;
            }
        }
        return orientation;
    }

    @Override
    public String toString() {
        String result;
        if(this.orientation!=null){
            result = "Orientation:" + this.orientation.getName();
        }else{
            result = "Orientation: [Invalid]";
        }
        return result;
    }
}
