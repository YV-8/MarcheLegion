package university.jala.Legion.orientation;

public enum Orientation {
    NORTH("N","North"),
    SOUTH("S","South"),
    EAST("E","East"),
    WEST("W","West");
    final String orientation;
    final String name;
    Orientation(String orientation, String name) {
        this.name = name;
        this.orientation = orientation;
    }
    public String getName() {
        return name;
    }
    public String getOrientation() {
        return orientation;
    }
    /**
     * This four methods are who determine:
     * where start row if 0 or board's size -1
     * where start col if 0 or board's size -1
     * @param boardSize is the size where get row and column
     */
    public int getStartRow(int boardSize) {
        return switch (this) {
            case NORTH, EAST, WEST -> boardSize - 1;
            case SOUTH -> 0;
        };
    }
    public int getEndRow(int boardSize) {
        return switch (this) {
            case NORTH, EAST, WEST -> 0;
            case SOUTH -> boardSize - 1;
        };
    }
    public int getStartColumn(int boardSize) {
        return switch (this) {
            case NORTH, SOUTH, EAST -> 0;
            case WEST -> boardSize - 1;
        };
    }
    public int getEndColumn(int boardSize) {
        return switch (this) {
            case NORTH, SOUTH, EAST -> boardSize - 1;
            case WEST -> 0;
        };
    }

    /**
     * This method decide which is first if  rol or col
     * (this) is all this enum
     */
    public boolean isRowFirst() {
        return switch (this) {
            case NORTH, SOUTH -> true;
            case EAST, WEST -> false;
        };
    }

}
