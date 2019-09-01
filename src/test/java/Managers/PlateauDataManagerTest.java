package Managers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by min gao on 1/9/19
 */

class PlateauDataManagerTest {
    /**
     * sut: system under test
     */
    PlateauDataManager sut;

    @BeforeEach
    void setUp() {
        sut = PlateauDataManager.PLATEAU_FILE;
    }

    @Test
    void testGetPlateauConfig_whenGetPlateauConfig_isNotNull() {
        // when
        String plateauString = sut.getConfigString();

        // then
        assertNotNull(plateauString);
    }

    @Test
    void testGetPlateauConfig_whenGetPlateauConfig_eachRowHaveSameLength() {
        // when
        String[] plateauConfigStringList = sut.getConfigString().split("\n");
        int exp = plateauConfigStringList[0].length();

        // then
        for (int i = 1; i < plateauConfigStringList.length; i++) {
            assertEquals(exp, plateauConfigStringList[i].length());
        }
    }
}