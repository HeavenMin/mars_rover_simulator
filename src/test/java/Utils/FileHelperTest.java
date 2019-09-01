package Utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by min gao on 1/9/19
 */

class FileHelperTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetResourceFileString_whenGetFromNotExistFile_isNull() {
        // given
        String filepath = "not_exist";

        // when
        String notExistFileString = FileHelper.getResourcesFileString(filepath);

        assertNull(notExistFileString);
    }

    @Test
    void testGetResourceFileString_whenGetfromEmptyFile_isNotNull() {
        // given
        String filePath = "config/empty.txt";

        // when
        String emptyFileString = FileHelper.getResourcesFileString(filePath);

        // then
        assertNotNull(emptyFileString);
    }

    @Test
    void testGetResourcesFileString_whenGetfromEmptyFile_isEmptyString() {
        // given
        String filePath = "config/empty.txt";

        // when
        String emptyFileString = FileHelper.getResourcesFileString(filePath);

        // then
        assertEquals("", emptyFileString);
    }

    @Test
    void testGetResourcesFileString_whenGetfromPlateauFile_isNotEmpty() {
        // given
        String filePath = "config/plateau.txt";

        // when
        String plateauFileString = FileHelper.getResourcesFileString(filePath);

        // then
        assertNotEquals("", plateauFileString);
    }

}