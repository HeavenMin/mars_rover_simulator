package Models;

/**
 * Created by min gao on 1/9/19
 */

public enum DirectionEnum implements ITurnable<DirectionEnum> {
    NORTH {
        @Override
        public DirectionEnum turnRight() {
            return EAST;
        }

        @Override
        public DirectionEnum turnLeft() {
            return WEST;
        }
    },
    SOUTH {
        @Override
        public DirectionEnum turnRight() {
            return WEST;
        }

        @Override
        public DirectionEnum turnLeft() {
            return EAST;
        }
    },
    EAST {
        @Override
        public DirectionEnum turnRight() {
            return SOUTH;
        }

        @Override
        public DirectionEnum turnLeft() {
            return NORTH;
        }
    },
    WEST {
        @Override
        public DirectionEnum turnRight() {
            return NORTH;
        }

        @Override
        public DirectionEnum turnLeft() {
            return SOUTH;
        }
    }
}
