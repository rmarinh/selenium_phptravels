package util;

public class Util {
    private static String OS = System.getProperty("os.name").toLowerCase();
    public static boolean IS_WINDOWS = (OS.indexOf("win") >= 0);
    public static boolean IS_MAC = (OS.indexOf("mac") >= 0);
    public static boolean IS_UNIX = (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

    public static String checkOS() {

        System.out.println("os.name: " + OS);

        if (IS_WINDOWS) {
            return "WINDOWS";
        } else if (IS_MAC) {
            return "MAC";
        } else if (IS_UNIX) {
            return "LINUX";
        } else {
            return "OS_NOT_SUPPORTED";
        }
    }

}
