import java.util.Objects;

public class Rover {
    private final int x;
    private final int y;
    private Direction direction;

    public Rover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Rover move() {
        if(direction == Direction.NORTH){
            return new Rover(x,y +1, this.direction);
        }
        if(direction == Direction.EAST){
            return new Rover(x +1,y, this.direction);
        }
        if(direction == Direction.SOUTH){
            return new Rover(x,y - 1, this.direction);
        }
        if(direction == Direction.WEST){
            return new Rover(x-1,y, this.direction);
        }
        return  this;
    }

    public void rotateLeft() {
        direction = direction.rotateLeft();

    }

    public void rotateRight() {
        direction = direction.rotateRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return x == rover.x &&
                y == rover.y &&
                direction == rover.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}