package Managers;

import Utils.FileHelper;

/**
 * Created by min gao on 1/9/19
 */

public enum  PlateauDataManager {
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
}
