package Models;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by min gao on 1/9/19
 */

public enum LandEnum implements IPassable {
    PLAIN_LAND('o') {
        @Override
        public boolean canPass() {
            return true;
        }
    },
    LAND_WITH_ROCK('R') {
        @Override
        public boolean canPass() {
            return false;
        }
    },
    MARS_ROVER('X') {
        @Override
        public boolean canPass() {
            return false;
        }
    };

    private char symbol;
    LandEnum(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    private static final Logger LOGGER = Logger.getLogger(LandEnum.class.getName());
    public static LandEnum getLandEnumFrom(char symbol) {
        for (LandEnum land: LandEnum.values()) {
            if (land.getSymbol() == symbol) {
                return land;
            }
        }
        LOGGER.log(Level.WARNING, String.format("Can not find LandEnum with stringSymbol: %s ", symbol));
        return null;
    }

}
