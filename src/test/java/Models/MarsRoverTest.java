package Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by min gao on 1/9/19
 *
 * This test class can have more test cases to achieve more test coverage,
 * I haven't wrote them all to save time
 */

class MarsRoverTest {
    LandEnum[][] mockMap;
    PlateauMap mockPlateauMap;
    /**
     * sut: system under test
     */
    MarsRover sut;

    @BeforeEach
    void setUp() {
        /** mock map
         * oooR
         * oooo
         */
        mockMap = new LandEnum[2][4];
        for(int x = 0; x < 4; x++) {
            mockMap[0][x] = LandEnum.PLAIN_LAND;
        }
        for(int x = 0; x < 3; x++) {
            mockMap[1][x] = LandEnum.PLAIN_LAND;
        }
        mockMap[1][3] = LandEnum.LAND_WITH_ROCK;
        mockPlateauMap = new PlateauMap(mockMap);
        sut = new MarsRover(mockPlateauMap);
    }

    @Test
    void testGetMap_WhenInit_RoverIsOnMapTopLeft() {
        // when
        String MapString = sut.getMap().toString();

        // then
        assertEquals("XooR\noooo", MapString);
    }

    @Test
    void testMarsRover_WhenInit_RoverIsFacingEast() {
        // when
        DirectionEnum initRoverDirection = sut.getPosition().getDirection();

        // then
        assertEquals(DirectionEnum.EAST, initRoverDirection);
    }

    @Test
    void testTurnRight_WhenFaceingEast_WillFacingSouth() {
        // when
        sut.turnRight();
        DirectionEnum directionAfterTurnRight = sut.getPosition().getDirection();

        // then
        assertEquals(DirectionEnum.SOUTH, directionAfterTurnRight);
    }

    @Test
    void testTurnLeft_WhenFaceingEast_WillFacingNorth() {
        // when
        sut.turnLeft();
        DirectionEnum directionAfterTurnRight = sut.getPosition().getDirection();

        // then
        assertEquals(DirectionEnum.NORTH, directionAfterTurnRight);
    }

    @Test
    void testMoveForWard_WhenAtTopLeftAndFacingEast_WillMoveSuccessAndFacingSameDirection() {
        // when
        sut.moveForward();
        RoverPosition position = sut.getPosition();

        // then
        assertAll(() -> assertEquals(1, position.getX()),
                () -> assertEquals(1, position.getY()),
                () -> assertEquals(DirectionEnum.EAST, position.getDirection()));
    }

    // TODO (min): more test cases

}