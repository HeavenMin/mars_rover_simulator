package Models;

import Exceptions.CanNotReachException;
import Exceptions.DoNotExistRoverException;
import Exceptions.MapOutOfBoundaryException;
import Exceptions.NotNearbyException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by min gao on 1/9/19
 */

public class MarsRover {
    private static final Logger LOGGER = Logger.getLogger(MarsRover.class.getName());

    private RoverPosition position;
    private PlateauMap map;

    public MarsRover(PlateauMap map) {
        this.map = map;
        // init the mars rover initial position
        position = new RoverPosition(map.getTopLeftPosition(), DirectionEnum.EAST);
        setRoverInitPosition(position);
    }

    public PlateauMap getMap() {
        return map;
    }

    public RoverPosition getPosition() {
        return position;
    }

    public void moveForward() {
        moveTo(getDestinationPositionWhenMoveForward());
    }

    public void moveForwardWithAnalysis(IAnalysis analysis) {
        moveTo(getDestinationPositionWhenMoveForward(), analysis);
    }

    private Position getDestinationPositionWhenMoveForward() {
        int destinationX = position.getX();
        int destinationY = position.getY();
        DirectionEnum direction = position.getDirection();
        switch (direction) {
            case NORTH:
                destinationY += 1;
                break;
            case SOUTH:
                destinationY -= 1;
                break;
            case EAST:
                destinationX += 1;
                break;
            case WEST:
                destinationX -= 1;
                break;
        }
        return new Position(destinationX, destinationY);
    }

    public void turnRight() {
        position.setDirection(position.getDirection().turnRight());
    }

    public void turnRightWithAnalysis(IAnalysis analysis) {
        turnRight();
        analysis.analyze();
    }

    public void turnLeft() {
        position.setDirection(position.getDirection().turnLeft());
    }

    public void turnLeftWithAnalysis(IAnalysis analysis) {
        turnLeft();
        analysis.analyze();
    }

    private void setRoverInitPosition(Position position) {
        try {
            map.setMarsRoverPosition(position);
        } catch (MapOutOfBoundaryException e) {
            LOGGER.log(Level.WARNING, "Position out of map boundary.");
        } catch (CanNotReachException e) {
            LOGGER.log(Level.WARNING, "Can not reach the area.");
        }
    }

    private void moveTo(Position destination) {
        try {
            map.moveMarsRoverPosition(this.position, destination);
            position = new RoverPosition(destination, position.getDirection());
        } catch (DoNotExistRoverException e) {
            LOGGER.log(Level.WARNING, "Do not have rover in this position.");
        } catch (NotNearbyException e) {
            LOGGER.log(Level.WARNING, "Position is not nearby.");
        } catch (MapOutOfBoundaryException e) {
            LOGGER.log(Level.WARNING, "Position out of map boundary.");
        } catch (CanNotReachException e) {
            LOGGER.log(Level.WARNING, "Can not reach the area.");
        }
    }

    private void moveTo(Position destination, IAnalysis analysis) {
        try {
            map.moveMarsRoverPosition(this.position, destination);
            position = new RoverPosition(destination, position.getDirection());
        } catch (DoNotExistRoverException e) {
            LOGGER.log(Level.WARNING, "Do not have rover in this position.");
        } catch (NotNearbyException e) {
            LOGGER.log(Level.WARNING, "Position is not nearby.");
        } catch (MapOutOfBoundaryException e) {
            LOGGER.log(Level.WARNING, "Position out of map boundary.");
            analysis.analyze();
        } catch (CanNotReachException e) {
            LOGGER.log(Level.WARNING, "Can not reach the area.");
            analysis.analyze();
        }
    }

}
