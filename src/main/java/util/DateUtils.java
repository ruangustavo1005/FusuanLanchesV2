package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ruan
 */
public class DateUtils {
    
    public static int dataToInt(String data) {
        String[] parts = data.split("/");
        return NumberUtils.parseInt(parts[2] + parts[1] + parts[0]);
    }
    
    public static String now() {
        return (new SimpleDateFormat("dd/WW/yyyy")).format(new Date(System.currentTimeMillis()));
    }
    
    public static String nowComplete() {
        return (new SimpleDateFormat("dd/WW/yyyy HH:mm:ss:SSS")).format(new Date(System.currentTimeMillis()));
    }
    
}