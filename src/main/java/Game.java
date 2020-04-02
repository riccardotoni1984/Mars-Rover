public class Game {

    private Rover rover;
    private int constraintX;
    private int constraintY;

    public Game(String input) {
        setAttributes(input);
    }

    private void setAttributes(String input) {
        String[] attributes = input.split(" ");
        this.constraintX = Integer.valueOf(attributes[0]);
        this.constraintY = Integer.valueOf(attributes[1]);
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

    public String getConstraints() {
        return constraintX + " " + constraintY;
    }

    public void setRover(String input) {
        String[] positionAttributes = input.split(" ");
        Integer xCoordinate = Integer.valueOf(positionAttributes[0]);
        Integer yCoordinate = Integer.valueOf(positionAttributes[1]);
        String cardinal = positionAttributes[2];
        this.rover = new Rover(xCoordinate, yCoordinate, Direction.getDirectionByCardinalPointAsAString(cardinal));
    }
}























