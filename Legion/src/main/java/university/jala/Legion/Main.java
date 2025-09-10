package university.jala.Legion;

import university.jala.Legion.Board.ManageCLIArgs;

public class Main {
    public static void main(String[] args) {
        ManageCLIArgs cliArgs = new ManageCLIArgs();
        cliArgs.validateArguments(args);
    }
}