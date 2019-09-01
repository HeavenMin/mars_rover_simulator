package Models;

import Exceptions.CanNotReachException;
import Exceptions.DoNotExistRoverException;
import Exceptions.MapOutOfBoundaryException;
import Exceptions.NotNearbyException;

/**
 * Created by min gao on 1/9/19
 */

public class PlateauMap {
    private LandEnum[][] map;

    public PlateauMap(LandEnum[][] map) {
        this.map = map;
    }

    public void setMarsRoverPosition(Position position) throws MapOutOfBoundaryException, CanNotReachException {
        if (isOutOfMapBoundary(position)) {
            throw new MapOutOfBoundaryException();
        }
        LandEnum destination = map[position.getY()][position.getX()];
        if (!destination.canPass()) {
            throw new CanNotReachException();
        }
        map[position.getY()][position.getX()] = LandEnum.MARS_ROVER;
    }

    public void moveMarsRoverPosition(Position from, Position to) throws MapOutOfBoundaryException,
            DoNotExistRoverException, NotNearbyException, CanNotReachException {
        if (isOutOfMapBoundary(from)) {
            throw new MapOutOfBoundaryException();
        }
        if (map[from.getY()][from.getX()] != LandEnum.MARS_ROVER) {
            throw new DoNotExistRoverException();
        }
        if (!isNearby(from, to)) {
            throw new NotNearbyException();
        }
        setMarsRoverPosition(to);
        map[from.getY()][from.getX()] = LandEnum.PLAIN_LAND;
    }

    public Position getTopLeftPosition() {
        return new Position(0, map.length - 1);
    }

    private boolean isOutOfMapBoundary(Position position) {
        if (position.getX() >= map[0].length ||
                position.getX() < 0 ||
                position.getY() >= map.length ||
                position.getY() < 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder mapStringBuilder = new StringBuilder();
        for (int i = map.length - 1; i >= 0; i--) {
            for (int j = 0; j < map[0].length; j++) {
                mapStringBuilder.append(map[i][j].getSymbol());
            }
            if (i > 0) {
                mapStringBuilder.append('\n');
            }
        }
        return mapStringBuilder.toString();
    }

    private boolean isNearby(Position position1, Position position2) {
        return Math.abs(position1.getX() + position1.getY() - position2.getX() - position2.getY()) == 1;
    }

}
