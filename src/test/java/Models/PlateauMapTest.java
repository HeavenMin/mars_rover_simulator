package Models;

import Exceptions.CanNotReachException;
import Exceptions.DoNotExistRoverException;
import Exceptions.MapOutOfBoundaryException;
import Exceptions.NotNearbyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by min gao on 1/9/19
 */

class PlateauMapTest {

    LandEnum[][] mockMap;
    PlateauMap mockSut;

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
        mockSut = new PlateauMap(mockMap);
    }

    @Test
    void testToString_whenInit_isSameToPlateauConfigString() {
        // when
        String plateauMapToString = mockSut.toString();

        // then
        assertEquals("oooR\noooo", plateauMapToString);
    }

    @Test
    void testGetTopLeftPositionWith_MockMap_isCorrect() {
        // when
        Position topLeftPosition = mockSut.getTopLeftPosition();
        Position exp = new Position(0, 1);
        // then
        assertAll(() -> assertEquals(exp.getX(), topLeftPosition.getX()),
                  () -> assertEquals(exp.getY(), topLeftPosition.getY()));
    }

    @Test
    void testSetMarsRoverPosition_WhenSetToPassableLand_CanSuccess() throws Exception {
        // given
        Position plainLandPosition = new Position(0, 1);

        // when
        mockSut.setMarsRoverPosition(plainLandPosition);

        // then
        assertEquals(LandEnum.MARS_ROVER, mockMap[1][0]);
    }

    @Test
    void testSetMarsRoverPosition_WhenSetToUnPassableLand_willThrowCanNotReachException() {
        // given
        Position landWithRockPosition = new Position(3, 1);

        // then
        assertThrows(CanNotReachException.class,
                () -> mockSut.setMarsRoverPosition(landWithRockPosition));
    }

    @Test
    void testSetMarsRoverPosition_WhenSetOutOfBoundary_willThrowMapOutOfBoundaryException() {
        // given
        Position landWithRockPosition = new Position(4, 1);

        // then
        assertThrows(MapOutOfBoundaryException.class,
                () -> mockSut.setMarsRoverPosition(landWithRockPosition));
    }

    @Test
    void testMoveMarsRoverPosition_WhenMoveFromOutOfBoundaryPlace_willThrowMapOutOfBoundaryException() {
        // given
        Position from = new Position(0, 2);
        Position to = new Position(0, 1);

        // when
        assertThrows(MapOutOfBoundaryException.class,
                () -> mockSut.moveMarsRoverPosition(from, to));
    }

    @Test
    void testMoveMarsRoverPosition_WhenMoveFromPlaceWithOutRover_willThrowMapOutOfBoundaryException() {
        // given
        Position from = new Position(0, 0);
        Position to = new Position(1, 0);

        // when
        assertThrows(DoNotExistRoverException.class,
                () -> mockSut.moveMarsRoverPosition(from, to));
    }

    @Test
    void testMoveMarsRoverPosition_WhenMoveTooFar_willThrowNotNearbyException() {
        // given
        mockMap[0][0] = LandEnum.MARS_ROVER;
        Position from = new Position(0, 0);
        Position to = new Position(2, 0);

        // when
        assertThrows(NotNearbyException.class,
                () -> mockSut.moveMarsRoverPosition(from, to));
    }

    @Test
    void testMoveMarsRoverPosition_WhenMoveToValidPlace_canSuccess() throws Exception {
        // given
        mockMap[0][0] = LandEnum.MARS_ROVER;
        Position from = new Position(0, 0);
        Position to = new Position(1, 0);

        // when
        mockSut.moveMarsRoverPosition(from, to);

        // then
        assertAll(() -> assertEquals(LandEnum.PLAIN_LAND, mockMap[0][0]),
                () -> assertEquals(LandEnum.MARS_ROVER, mockMap[0][1]));
    }

}