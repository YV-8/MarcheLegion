package university.jala.Legion.utilies;

import university.jala.Legion.algorithm.Algorithm;
import university.jala.Legion.Board.ManageArguments;

public class AlgorithmValidator implements ManageArguments<Algorithm> {
    Algorithm algorithm = null;
    @Override
    public Algorithm validate(String arg) {
        for (Algorithm algorithm : Algorithm.values()) {
            if (algorithm.getAlgorithm().equalsIgnoreCase(arg)) {
                this.algorithm = algorithm;
                break;
            }
        }
        return algorithm;
    }

    @Override
    public String toString() {
        String result;
        if(this.algorithm!=null){
            result = "Algorithm:" + this.algorithm.getName();
        }else{
            result = "Algorithm: [Invalid]";
        }
        return result;
    }

}
