package util;

/**
 *
 * @author Ruan
 */
public class DateUtils {
    
    public static int dataToInt(String data) {
        String[] parts = data.split("/");
        return NumberUtils.parseInt(parts[2] + parts[1] + parts[0]);
    }
    
}