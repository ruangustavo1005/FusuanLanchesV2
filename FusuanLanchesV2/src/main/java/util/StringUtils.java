package util;

/**
 *
 * @author Ruan
 */
public class StringUtils {
    
    public static String ucfirst(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    
}