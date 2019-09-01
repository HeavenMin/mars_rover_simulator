package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by min gao on 1/9/19
 */

public class FileHelper {
    private FileHelper() {}

    private static final Logger LOGGER = Logger.getLogger(FileHelper.class.getName());

    public static String getResourcesFileString(String resFilePath) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(resFilePath)) {
            if (inputStream == null) {
                return null;
            }
            try (Scanner scanner = new Scanner(inputStream)) {
                return scanner.useDelimiter("\\A").hasNext() ? scanner.next().trim() : "";
            }
        } catch (IOException e) {
            LOGGER.log(Level.WARNING,
                    String.format("Can not load file from path: %s", resFilePath));
            return null;
        }
    }
}
