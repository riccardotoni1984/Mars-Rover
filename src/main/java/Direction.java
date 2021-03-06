import java.util.Map;

public enum Direction {
    NORTH("N"),
    EAST("E"),
    WEST("W"),
    SOUTH("S");

    private static final Map<Direction, Direction> leftRotation = Map.of(
            Direction.EAST, Direction.NORTH,
            Direction.NORTH, Direction.WEST,
            Direction.WEST, Direction.SOUTH,
            Direction.SOUTH, Direction.EAST
    );

    private static final Map<Direction, Direction> rightRotation = Map.of(
            Direction.EAST, Direction.SOUTH,
            Direction.NORTH, Direction.EAST,
            Direction.WEST, Direction.NORTH,
            Direction.SOUTH, Direction.WEST
    );
    private String cardinalPoint;

    Direction(String cardinalPoint) {
        this.cardinalPoint = cardinalPoint;
    }

    public Direction rotateRight() {
        return rightRotation.get(this);
    }

    public Direction rotateLeft() {
        return leftRotation.get(this);
    }

   public static Direction getDirectionByCardinalPointAsAString(String cardinal){
       for (Direction direction: Direction.values()) {
           if(direction.cardinalPoint.equals(cardinal)){
               return direction;
           }
       }
       return null;
   }

}
