package university.jala.Legion.desingPatterns;

import university.jala.Legion.algorithm.*;

public class AlgorithmFactory {
    public static Algorithm algorithm;
    private AlgorithmFactory() {
    }

    /**
     * method in charge of creating and returning an instance of a SortingAlgorithm
     *
     * @param algorithmType type of algorithm to return
     */

    public static ChooseAlgorithm createAlgorithm(Algorithm algorithmType) {
        return switch (algorithmType) {
            case BUBBLESORT -> new BubbleSort();
            case INSERTIONSORT -> new InsertionSort();
            case MERGESORT -> new MergeSort();
        };
    }
}
