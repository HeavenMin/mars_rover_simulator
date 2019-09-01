package Managers;

import Models.LandEnum;
import Models.MarsRover;
import Models.PlateauMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by min gao on 1/9/19
 */

class RoverCommandManagerTest {
    /**
     * sut: system under test
     */
    MarsRover mockMarsRover;
    RoverCommandManager sut;

    @BeforeEach
    void setUp() {
        /** mock map
         * oooR
         * oooo
         */
        LandEnum[][] mockMap = new LandEnum[2][4];
        for(int x = 0; x < 4; x++) {
            mockMap[0][x] = LandEnum.PLAIN_LAND;
        }
        for(int x = 0; x < 3; x++) {
            mockMap[1][x] = LandEnum.PLAIN_LAND;
        }
        mockMap[1][3] = LandEnum.LAND_WITH_ROCK;
        PlateauMap mockPlateauMap = new PlateauMap(mockMap);
        mockMarsRover = new MarsRover(mockPlateauMap);
        sut = RoverCommandManager.INSTANCE;
    }

    @Test
    void testRunCommand_WhenRunTwoValidAndReachableCommand_ExecutedCommandCountEqualTwoAndFailedCommandCountEqualZero() {
        // when
        sut.runCommand("MM", mockMarsRover);

        // then
        assertAll(() -> assertEquals(2, sut.getExecutedCommandCount()),
                () -> assertEquals(0, sut.getFailedCommandCount()));
    }

    @Test
    void testRunCommand_WhenThereHasInvalidCommand_ExecutedCommandCountEqualZeroAndFailedCommandCountEqualZero() {
        // when
        sut.runCommand("M?", mockMarsRover);

        // then
        assertAll(() -> assertEquals(0, sut.getExecutedCommandCount()),
                () -> assertEquals(0, sut.getFailedCommandCount()));
    }

    @Test
    void testRunCommand_WhenRunThreeValidCommandWithOneUnReachableCommand_ExecutedCommandCountEqualThreeAndFailedCommandCountEqualOne() {
        // when
        sut.runCommand("MMM", mockMarsRover);

        // then
        assertAll(() -> assertEquals(3, sut.getExecutedCommandCount()),
                () -> assertEquals(1, sut.getFailedCommandCount()));
    }

    @AfterEach
    void tearDown() {
        sut.clearAllCommandCount();
    }

}