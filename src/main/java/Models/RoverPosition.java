package Models;

/**
 * Created by min gao on 1/9/19
 */

public class RoverPosition extends Position {
    private DirectionEnum direction;

    public RoverPosition(Position position, DirectionEnum direction) {
        super(position.getX(), position.getY());
        this.direction = direction;
    }

    public RoverPosition(int x, int y, DirectionEnum direction) {
        super(x, y);
        this.direction = direction;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }
}
