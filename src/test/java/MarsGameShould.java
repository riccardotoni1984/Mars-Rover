import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsGameShould {

    private Game game;

    @BeforeEach
    void setUp() {
//        rover = new Rover(1,1, Direction.NORTH);
        game = new Game("10 10");
        game.setRover("1 1 N");
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
        game.setRover("5 5 S");
        game.move();
        assertEquals(new Rover(5,4,Direction.SOUTH) , game.getRover());
    }

    @Test
    void move_one_position_west_from_coordinate_5_5() {
        game.setRover("5 5 W");
        game.move();
        assertEquals(new Rover(4,5, Direction.WEST), game.getRover());
    }

    @Test
    void wrap_around_when_it_moves_outside_west_constraints() {
        game.setRover("1 1 W");
        game.move();
        assertEquals(new Rover(10,1, Direction.WEST), game.getRover());
    }

    @Test
    void wrap_around_when_it_moves_outside_east_constraints() {
        game.setRover("10 1 E");
        game.move();
        assertEquals(new Rover(1,1, Direction.EAST), game.getRover());
    }

    @Test
    void wrap_around_when_it_moves_outside_north_constraints() {
        game.setRover("1 10 N");
        game.move();
        assertEquals(new Rover(1,1, Direction.NORTH), game.getRover());
    }

    @Test
    void wrap_around_when_it_moves_outside_south_constraints() {
        game.setRover("1 1 S");
        game.move();
        assertEquals(new Rover(1,10, Direction.SOUTH), game.getRover());
    }

    @Test
    void create_a_new_game_with_given_constraints() {
        game = new Game("10 10");
        assertEquals("10 10", game.getConstraints());
    }

    @Test
    void create_a_new_rover_when_given_starting_input() {
        game = new Game("10 10");
        game.setRover("1 2 N");
        assertEquals(new Rover(1,2, Direction.NORTH), game.getRover());
    }
}
