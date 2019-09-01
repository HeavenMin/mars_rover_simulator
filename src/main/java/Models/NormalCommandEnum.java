package Models;

import Managers.RoverCommandManager;

/**
 * Created by min gao on 1/9/19
 */

public enum NormalCommandEnum implements ICommand<RoverCommandManager> {
    CLOSE_SIMULATOR("x") {
        @Override
        public void perform(RoverCommandManager item) {
            System.out.println(String.format("Sent %d command(s) / %d failed.\n",
                                             item.getExecutedCommandCount(),
                                             item.getFailedCommandCount()));
            String projectVersion = getClass().getPackage().getImplementationVersion();
            System.out.println(String.format("Mars Rover %s closed.",
                    projectVersion == null ? "Beta" : projectVersion));
        }
    };
    private String key;
    NormalCommandEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
