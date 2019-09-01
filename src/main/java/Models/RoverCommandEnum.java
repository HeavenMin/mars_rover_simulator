package Models;

/**
 * Created by min gao on 1/9/19
 */

public enum RoverCommandEnum implements ICommand<MarsRover> {
    MOVE("M", true) {
        @Override
        public void perform(MarsRover item) {
            item.moveForward();
        }

        public void performWithAnalysis(MarsRover item, IAnalysis analysis) {
            item.moveForwardWithAnalysis(analysis);
        }
    },
    TURN_LEFT("L", false) {
        @Override
        public void perform(MarsRover item) {
            item.turnLeft();
        }

        @Override
        public void performWithAnalysis(MarsRover item, IAnalysis analysis) {
            item.turnLeftWithAnalysis(analysis);
        }
    },
    TURN_RIGHT("R", false) {
        @Override
        public void perform(MarsRover item) {
            item.turnRight();
        }

        @Override
        public void performWithAnalysis(MarsRover item, IAnalysis analysis) {
            item.turnRightWithAnalysis(analysis);
        }
    };

    private String key;
    private boolean usingAnalysis;
    RoverCommandEnum(String key, boolean usingAnalysis) {
        this.key = key;
        this.usingAnalysis = usingAnalysis;
    }

    public String getKey() {
        return key;
    }

    public boolean isUsingAnalysis() {
        return usingAnalysis;
    }

    public abstract void performWithAnalysis(MarsRover item, IAnalysis analysis);
}
