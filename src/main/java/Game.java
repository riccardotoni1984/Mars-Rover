public class Game {

    private Rover rover;
    private int constraintX;
    private int constraintY;

    public Game(Rover rover, int constraintX, int constraintY) {
        this.rover = rover;
        this.constraintX = constraintX;
        this.constraintY = constraintY;
    }

    public void rotateLeft() {
        rover.rotateLeft();
    }

    public void rotateRight() {
        rover.rotateRight();
    }

    public void move() {
       rover = rover.move();
        if (rover.getX() > constraintX)
            rover = new Rover(1, rover.getY(), rover.getDirection());
        if (rover.getX() < 1)
            rover = new Rover(constraintX, rover.getY(), rover.getDirection());
        if (rover.getY() > constraintY)
            rover = new Rover(rover.getX(), 1, rover.getDirection());
        if (rover.getY() < 1)
            rover = new Rover(rover.getX(), constraintY, rover.getDirection());
    }

    public Rover getRover(){
        return this.rover;
    }

}























