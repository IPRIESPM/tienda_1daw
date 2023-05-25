package utils;

/**
 *
 * @author Isaac Julián
 *
 */
public class utils {

    public static double round(double value) {
        return (Math.round(value * 100.0) / 100.0);
    }

    public static boolean paramIsDigit(String param) {
        return param != null && param.chars().allMatch(Character::isDigit);
    }

    public static String checkParam(String param) {
        return param == null ? " " : param;
    }

    public static int checkParamInt(String param) {

        param = param == null ? "1" : param;
        if (!paramIsDigit(param)) {
            param = "1";
        }

        return Integer.parseInt(param);
    }
}
