package Managers;

import Models.LandEnum;
import Utils.FileHelper;

/**
 * Created by min gao on 1/9/19
 */

public enum PlateauDataManager {
    PLATEAU_FILE("config/plateau.txt");

    private String path;
    private String configString;

    PlateauDataManager(String path) {
        this.path = path;
        this.configString = getPlateauConfig();
    }

    private String getPath() {
        return path;
    }

    public String getConfigString() {
        return configString;
    }

    private String getPlateauConfig() {
        return FileHelper.getResourcesFileString(getPath());
    }

    public LandEnum[][] getPlateauMapWithConfig() {
        LandEnum[][] map;
        String[] plateauConfigStringList = configString.split("\n");
        int columnLength = plateauConfigStringList.length;
        int rowLength = plateauConfigStringList[0].length();

        map = new LandEnum[columnLength][];
        for (int i = 0; i < columnLength; i++) {
            map[i] = new LandEnum[rowLength];
            for (int j = 0; j < rowLength; j ++) {
                map[i][j] = LandEnum.getLandEnumFrom(plateauConfigStringList[columnLength - i - 1].toCharArray()[j]);
            }

        }
        return map;
    }
}
