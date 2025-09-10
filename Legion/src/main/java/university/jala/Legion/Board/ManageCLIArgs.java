package university.jala.Legion.Board;

import java.util.*;

import university.jala.Legion.app.Legion;
import university.jala.Legion.utilies.*;
import university.jala.Legion.orientation.Orientation;
import university.jala.Legion.algorithm.*;
import university.jala.Legion.troopsType.troopsUnit.*;

public class ManageCLIArgs {
    private int field;
    private int totalTroops;
    private int validParameters;
    private int time;
    private boolean errorInTroops;
    private List<Integer> troops;
    private Orientation orientationType;
    private Algorithm algorithm;
    private TypeTroop typeTroop;
    private BoardValidator boardValidator;
    private Printer printer;
    private Legion legion;

    private final AlgorithmValidator algorithmValidator = new AlgorithmValidator();
    private final TypeTroopsValidator typeTroopsValidator = new TypeTroopsValidator();
    private final TroopValidator troopValidator = new TroopValidator();
    private final FieldSizeValidator fieldSizeValidator = new FieldSizeValidator();
    private final OrientationValidator orientationValidator = new OrientationValidator();
    private final TimeValidator timeValidator = new TimeValidator();

    /**
     * @param args derive "arg" is each argument  start with this letter and equals
     */
    public void validateArguments(String[] args) {
        boolean hasTime = false;
        int validArgs = 0;
        List<String> argsList = new ArrayList<>();
        for (String arg : args) {
            if (arg.startsWith("s=")) {
                hasTime = true;
                validArgs++;
                argsList.add(arg);
            } else if (arg.startsWith("a=") || arg.startsWith("t=") || arg.startsWith("u=") || arg.startsWith("f=") ||
                    arg.startsWith("o=")) {
                validArgs++;
                argsList.add(arg);
            }
        }
        delimitedNumberLimit(hasTime,validArgs,args);
    }
    public void delimitedNumberLimit( boolean hasTime, int validArgs,String[] args){
        int numberLimit = hasTime ? 6 : 5;
        if(validArgs >= numberLimit){
            assignValuesArgs(List.of(args));
        }else{
            printer.printInvalid();
        }
        legion.startApp(numberLimit,validArgs,time);
    }

    /**
     * @param args is pass parameter
     * algorithm is type algorithm
     * troopType is numeric or character
     * troop is troop's amount
     * orientation is orientation print the board
     * filed is size of board
     * seconds is the time to print each board
     */
    public void assignValuesArgs(List<String> args) {
        for (String arg : args) {
            String argument = arg.substring(2);
            String parameterClear =arg.substring(0, 2);
            String parameter = parameterClear.toLowerCase();
            switch (parameter) {
                case "a=":
                    algorithm = algorithmValidator.validate(argument);
                    addParameterRequeriment(algorithm);
                    break;
                case "t=":
                    typeTroop =  typeTroopsValidator.validate(argument);
                    addParameterRequeriment(typeTroop);
                    break;
                case "u=":
                    troops =  troopValidator.validate(argument);
                    checkTroop(troops);
                    break;
                case "f=":
                    argument = checkNumber(argument,parameter);
                    field = (int) fieldSizeValidator.validate(argument);
                    addParameterNumbers(field);
                    break;
                case "o=":
                    orientationType =  orientationValidator.validate(argument);
                    addParameterRequeriment(orientationType);
                case "s=":
                    argument = checkNumber(argument,parameter);
                    time = (int) timeValidator.validate(argument);
                    addParameterNumbers(field);
                    break;
                default:
                    printer.exceptionNull(parameter);
                    break;
            }

        }
        boardValidator = createBoardValidator();
        printer = createPrinter();
        legion = createLegion();
        enableBoard();
    }
    /**
     * printer.printDetails is a method that check is List troop is valid
     * if all troops' parameter is okay
     * the attribute limitExceeded  is a boolean  where troop is invalid  rest a number
     * the attribute validParameters is the number the parameters validated
     * if is the equals or mayor of main parameters print the board
     */
    public void enableBoard() {
        printer.printDetails(errorInTroops);
        if(!errorInTroops){
            boolean limitExceeded= boardValidator.validateBoardLimit();
            if(limitExceeded) {
                validParameters--;
            }
        }
    }

    /**
     * this method is sum parameters good
     * @param M is the object
     */
    public void addParameterRequeriment(Object M){
        if (M != null) {
            validParameters++;
        }
    }
    public void addParameterNumbers(int number){
        if (number != 0) {
            validParameters++;
        }
    }

    /**
     * This method is different because check that these parameter are good
     * @param argument is the objet validated
     * @param parameter is the  type parameter
     */
    public String checkNumber(String argument,String parameter){
        if(argument.equals(" ") || argument.isEmpty()){
            if(parameter.equals("f=")){
                argument = "10";
            }else if (parameter.equals("s=")){
            argument = "500";
            }
        }
        return argument;
    }
    public void checkTroop(List<Integer> troops){
        if(troops == null || troops.isEmpty()){
            errorInTroops = true;
        }else{
            validParameters++;
            totalTroops = troops.removeLast();
        }
    }

    /**
     * These methods of create is for keep clean the code and use goodPractice
     * also I use this class as a factory for legion,printer and Board validator
     */
    public Legion createLegion() {
        return new Legion(algorithm, typeTroop, troops, field, orientationType,time);
    }
    public Printer createPrinter() {
        return new Printer(algorithmValidator,typeTroopsValidator,boardValidator,timeValidator,orientationValidator,fieldSizeValidator);

    }
    public  BoardValidator createBoardValidator() {
        return new BoardValidator(totalTroops,troops,field);
    }
}