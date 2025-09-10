package university.jala.Legion.utilies;

import university.jala.Legion.Board.ManageArguments;

public class FieldSizeValidator implements ManageArguments<Object> {
    String field;
    int amountField;
    @Override
    public Object validate(String arg) {
        field = arg;
        int numberField = Integer.parseInt(field);
        if (numberField >4 && numberField < 1001 ) {
            amountField = numberField;
        }
        return amountField;
    }

    @Override
    public String toString() {
        String result;
        if(this.field!=null &&  this.amountField>0){
            result = "BattleFailed: [ " + this.amountField +" * "+this.amountField+ " ]";
        }else{
            result = "BattleFailed: [Invalid]";
        }
        return result;
    }
}
