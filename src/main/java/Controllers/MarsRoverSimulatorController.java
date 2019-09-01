package Controllers;

import Managers.PlateauDataManager;
import Managers.RoverCommandManager;
import Models.MarsRover;
import Models.NormalCommandEnum;
import Models.PlateauMap;

import java.util.Scanner;

/**
 * Created by min gao on 1/9/19
 */

public class MarsRoverSimulatorController {
    private static boolean RUNNING = true;

    private MarsRover marsRover;
    private RoverCommandManager roverCommandManager;

    public MarsRoverSimulatorController() {
        marsRover = new MarsRover(new PlateauMap(
                PlateauDataManager.PLATEAU_FILE.getPlateauMapWithConfig()));
        roverCommandManager = RoverCommandManager.INSTANCE;
    }

    public void startSimulator() {
        String projectVersion = getClass().getPackage().getImplementationVersion();
        System.out.println(String.format("Mars Rover %s running, plateau configuration is:",
                projectVersion == null ? "Beta" : projectVersion));
    }

    public void waitingForUserCommand() {
        showCurrentMapStatusAndWaitingPrompt(marsRover);
        while (RUNNING) {
            Scanner sc = new Scanner(System.in);
            String inputCommands = sc.nextLine();
            if (inputCommands.length() == 1 &&
                    inputCommands.toLowerCase().equals(NormalCommandEnum.CLOSE_SIMULATOR.getKey())) {
                System.out.println();
                NormalCommandEnum.CLOSE_SIMULATOR.perform(roverCommandManager);
                break;
            } else {
                roverCommandManager.runCommand(inputCommands, marsRover);
                showCurrentMapStatusAndWaitingPrompt(marsRover);
            }
        }
    }

    private void showCurrentMapStatusAndWaitingPrompt(MarsRover marsRover) {
        System.out.println();
        System.out.println(marsRover.getMap());
        System.out.print("Waiting for commands.\n>");
    }

}
