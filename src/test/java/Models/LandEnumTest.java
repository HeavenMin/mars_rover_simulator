package Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by min gao on 1/9/19
 */

class LandEnumTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetLandEnumFrom_Symbol_o_isPlainLand() {
        // given
        char landSymbol = 'o';

        // when
        LandEnum plainLand = LandEnum.getLandEnumFrom(landSymbol);

        // then
        assertEquals(LandEnum.PLAIN_LAND, plainLand);
    }

    @Test
    void testGetLandEnumFrom_Symbol_R_isLandWithRock() {
        // given
        char landSymbol = 'R';

        // when
        LandEnum landWithRock = LandEnum.getLandEnumFrom(landSymbol);

        // then
        assertEquals(LandEnum.LAND_WITH_ROCK, landWithRock);
    }

    @Test
    void testGetLandEnumFrom_Symbol_X_isMarsRover() {
        // given
        char landSymbol = 'X';

        // when
        LandEnum landWithRock = LandEnum.getLandEnumFrom(landSymbol);

        // then
        assertEquals(LandEnum.MARS_ROVER, landWithRock);
    }

}