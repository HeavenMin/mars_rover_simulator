package Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by min gao on 1/9/19
 */

class DirectionEnumTest {

    @Test
    void testDirectionEnum_WhenFacingNorthTurnLeft_ThenFacingWest() {
        // given
        DirectionEnum direction = DirectionEnum.NORTH;

        // when
        DirectionEnum exp = direction.turnLeft();

        // then
        assertEquals(DirectionEnum.WEST, exp);
    }

    @Test
    void testDirectionEnum_WhenFacingNorthTurnRight_ThenFacingEast() {
        // given
        DirectionEnum direction = DirectionEnum.NORTH;

        // when
        DirectionEnum exp = direction.turnRight();

        // then
        assertEquals(DirectionEnum.EAST, exp);
    }

    @Test
    void testDirectionEnum_WhenFacingEastTurnLeft_ThenFacingNorth() {
        // given
        DirectionEnum direction = DirectionEnum.EAST;

        // when
        DirectionEnum exp = direction.turnLeft();

        // then
        assertEquals(DirectionEnum.NORTH, exp);
    }

    @Test
    void testDirectionEnum_WhenFacingEastTurnRight_ThenFacingSouth() {
        // given
        DirectionEnum direction = DirectionEnum.EAST;

        // when
        DirectionEnum exp = direction.turnRight();

        // then
        assertEquals(DirectionEnum.SOUTH, exp);
    }

    @Test
    void testDirectionEnum_WhenFacingSouthTurnLeft_ThenFacingEast() {
        // given
        DirectionEnum direction = DirectionEnum.SOUTH;

        // when
        DirectionEnum exp = direction.turnLeft();

        // then
        assertEquals(DirectionEnum.EAST, exp);
    }

    @Test
    void testDirectionEnum_WhenFacingSouthTurnRight_ThenFacingWest() {
        // given
        DirectionEnum direction = DirectionEnum.SOUTH;

        // when
        DirectionEnum exp = direction.turnRight();

        // then
        assertEquals(DirectionEnum.WEST, exp);
    }

    @Test
    void testDirectionEnum_WhenFacingWestTurnLeft_ThenFacingSouth() {
        // given
        DirectionEnum direction = DirectionEnum.WEST;

        // when
        DirectionEnum exp = direction.turnLeft();

        // then
        assertEquals(DirectionEnum.SOUTH, exp);
    }

    @Test
    void testDirectionEnum_WhenFacingWestTurnRight_ThenFacingNorth() {
        // given
        DirectionEnum direction = DirectionEnum.WEST;

        // when
        DirectionEnum exp = direction.turnRight();

        // then
        assertEquals(DirectionEnum.NORTH, exp);
    }

}