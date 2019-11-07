import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsGameShould {

    private Game game;
    private Rover rover;

    @BeforeEach
    void setUp() {
        rover = new Rover(1,1, Direction.NORTH);
        game = new Game(rover, 10, 10);
    }

    @Test
    void face_west_if_rotate_left_when_facing_north() {
        game.rotateLeft();
        assertEquals(new Rover(1,1,Direction.WEST) , game.getRover());

    }

    @Test
    void face_south_if_rotate_left_two_times_when_facing_north() {
        game.rotateLeft();
        game.rotateLeft();
        assertEquals(new Rover(1,1,Direction.SOUTH) , game.getRover());

    }

    @Test
    void face_east_if_rotate_left_three_times_when_facing_north() {
        game.rotateLeft();
        game.rotateLeft();
        game.rotateLeft();
        assertEquals(new Rover(1,1,Direction.EAST) , game.getRover());
    }

    @Test
    void face_north_if_rotate_left_four_times_when_facing_north() {
        game.rotateLeft();
        game.rotateLeft();
        game.rotateLeft();
        game.rotateLeft();
        assertEquals(new Rover(1,1,Direction.NORTH) , game.getRover());

    }

    @Test
    void face_west_if_rotate_right_three_times_when_facing_north() {
        game.rotateRight();
        game.rotateRight();
        game.rotateRight();
        assertEquals(new Rover(1,1,Direction.WEST) , game.getRover());
    }

    @Test
    void move_one_position_north_when_facing_north() {
        game.move();
        assertEquals(new Rover(1,2,Direction.NORTH) , game.getRover());
    }

    @Test
    void move_two_positions_north_when_move_twice_facing_up() {
        game.move();
        game.move();
        assertEquals(new Rover(1,3,Direction.NORTH) , game.getRover());
    }

    @Test
    void move_two_positions_east_from_starting_coordinate_1_1() {
        game.rotateRight();
        game.move();
        game.move();
        assertEquals(new Rover(3,1,Direction.EAST) , game.getRover());
    }

    @Test
    void move_one_position_south_from_coordinate_5_5() {
        rover = new Rover(5,5, Direction.SOUTH);
        game = new Game(rover, 10, 10);
        game.move();
        assertEquals(new Rover(5,4,Direction.SOUTH) , game.getRover());
    }

    @Test
    void move_one_position_west_from_coordinate_5_5() {
        rover = new Rover(5,5, Direction.WEST);
        game = new Game(rover, 10, 10);
        game.move();
        assertEquals(new Rover(4,5, Direction.WEST), game.getRover());
    }

    @Test
    void wrap_around_when_it_moves_outside_west_constraints() {
        rover = new Rover(1,1, Direction.WEST);
        game = new Game(rover, 10, 10);
        game.move();
        assertEquals(new Rover(10,1, Direction.WEST), game.getRover());
    }

    @Test
    void wrap_around_when_it_moves_outside_east_constraints() {
        rover = new Rover(10,1, Direction.EAST);
        game = new Game(rover, 10, 10);
        game.move();
        assertEquals(new Rover(1,1, Direction.EAST), game.getRover());
    }

    @Test
    void wrap_around_when_it_moves_outside_north_constraints() {
        rover = new Rover(1,10, Direction.NORTH);
        game = new Game(rover, 10, 10);
        game.move();
        assertEquals(new Rover(1,1, Direction.NORTH), game.getRover());
    }

    @Test
    void wrap_around_when_it_moves_outside_south_constraints() {
        rover = new Rover(1,1, Direction.SOUTH);
        game = new Game(rover, 10, 10);
        game.move();
        assertEquals(new Rover(1,10, Direction.SOUTH), game.getRover());
    }

    

}
