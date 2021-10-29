package service;

public class PathsClasses {

    public static String getProjecDirectory() {
        String directoryProjectPath = System.getProperty("user.dir");
        return directoryProjectPath + "/";
    }
}
