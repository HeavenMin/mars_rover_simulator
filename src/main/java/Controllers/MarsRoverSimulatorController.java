package Controllers;

/**
 * Created by min gao on 1/9/19
 */

public class MarsRoverSimulatorController {

    private void startSimulator() {
        String projectVersion = getClass().getPackage().getImplementationVersion();
        System.out.println(String.format("Mars Rover %s running, plateau configuration is:",
                projectVersion == null ? "Beta" : projectVersion));
    }

    public static void main(String[] args) {

    }

}
