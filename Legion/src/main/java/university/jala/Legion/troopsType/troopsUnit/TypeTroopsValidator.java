package university.jala.Legion.troopsType.troopsUnit;

import university.jala.Legion.Board.ManageArguments;

public class TypeTroopsValidator implements ManageArguments<Object> {
    TypeTroop typeTroop = null;
    public TypeTroopsValidator() {
    }
    @Override
    public TypeTroop validate(String arg) {
        for (TypeTroop typeTroop : TypeTroop.values()) {
            if (typeTroop.getTypeWord().equalsIgnoreCase(arg)) {
                this.typeTroop = typeTroop;
                break;
            }
        }
        return typeTroop;
    }

    @Override
    public String toString() {
        String result;
        if(this.typeTroop!=null){
            result = "Type:" + typeTroop.getName();
        }else{
            result = "Type: [Invalid]";
        }
        return result;
    }
}
