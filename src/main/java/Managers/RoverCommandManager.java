package Managers;

import Exceptions.InvalidCommandException;
import Models.IAnalysis;
import Models.MarsRover;
import Models.RoverCommandEnum;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by min gao on 1/9/19
 */

public enum RoverCommandManager {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(RoverCommandManager.class.getName());
    private int executedCommandCount;
    private int failedCommandCount;
    private HashMap<String, RoverCommandEnum> symbolCommandMap;

    RoverCommandManager() {
        executedCommandCount = 0;
        failedCommandCount = 0;
        initSymbolCommandMap();
    }

    public int getExecutedCommandCount() {
        return executedCommandCount;
    }

    public int getFailedCommandCount() {
        return failedCommandCount;
    }

    public void clearAllCommandCount() {
        executedCommandCount = 0;
        failedCommandCount = 0;
    }

    private void initSymbolCommandMap() {
        symbolCommandMap = new HashMap<>();
        for (RoverCommandEnum command: RoverCommandEnum.values()) {
            symbolCommandMap.put(command.getKey(), command);
        }
    }

    public void runCommand(String command, MarsRover marsRover) {
        try {
            for (RoverCommandEnum c: getRoverCommandListFrom(command)) {
                if (c.isUsingAnalysis()) {
                    c.performWithAnalysis(marsRover, new IAnalysis() {
                        @Override
                        public void analyze() {
                            failedCommandCount++;
                        }
                    });
                } else {
                    c.perform(marsRover);
                }
                executedCommandCount++;
            }
        } catch (InvalidCommandException e) {
            LOGGER.log(Level.WARNING,
                    String.format("Command %s is invalid", command));
        }
    }

    private RoverCommandEnum[] getRoverCommandListFrom(String commandString) throws InvalidCommandException {
        String[] stringCommandList = commandString.split("");
        RoverCommandEnum[] roverCommandList = new RoverCommandEnum[stringCommandList.length];
        int i = 0;
        for (String command: stringCommandList) {
            if (!symbolCommandMap.containsKey(command)) {
                throw new InvalidCommandException();
            }
            roverCommandList[i++] = symbolCommandMap.get(command);
        }
        return roverCommandList;
    }

}
