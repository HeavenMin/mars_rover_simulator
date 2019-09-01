import Controllers.MarsRoverSimulatorController;

/**
 * Created by min gao on 1/9/19
 */

public class MarsRoverSimulator {

    public static void main(String[] args) {

        MarsRoverSimulatorController marsRoverSimulatorController = new MarsRoverSimulatorController();

        marsRoverSimulatorController.startSimulator();
        marsRoverSimulatorController.waitingForUserCommand();

    }
}
