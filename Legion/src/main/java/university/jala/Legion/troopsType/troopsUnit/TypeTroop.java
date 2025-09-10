package university.jala.Legion.troopsType.troopsUnit;

public enum TypeTroop {
    N("N","Numeric"),
    C("C","Character");
    private final String typeWord;
    private final String name;
    private TypeTroop(String typeWord, String name) {
        this.typeWord = typeWord;
        this.name = name;
    }
    public String getTypeWord() {
        return typeWord;
    }

    public String getName() {
        return name;
    }
}
