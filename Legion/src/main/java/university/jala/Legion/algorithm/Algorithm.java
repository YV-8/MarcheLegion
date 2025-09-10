package university.jala.Legion.algorithm;

public enum Algorithm {
    INSERTIONSORT("I","Insertion Sort"),
    BUBBLESORT("B","Bubble Sort"),
    MERGESORT("M", "Merge Sort");
    final String algorithm;
    final String name;
    Algorithm(String algorithm, String name) {
        this.algorithm = algorithm;
        this.name = name;
    }
    public String getAlgorithm() {
        return algorithm;
    }
    public String getName() {
        return name;
    }
}
