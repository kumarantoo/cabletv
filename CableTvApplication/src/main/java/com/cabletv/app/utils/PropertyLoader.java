
package com.cabletv.app.utils;
import java.util.ResourceBundle;
/**
 *
 * @author Kumaran
 */
public class PropertyLoader {
    
    /*
    Method to call resouce Bundle Generic Resources English
    */
    public static String readEnglish(String key) {
        
        ResourceBundle rb = ResourceBundle.getBundle("res_bundles/cabletv_generic_EN");
        String res = rb.getString(key);
        return res;
    }
    
    /*
    Method to call resouce Bundle Generic Resources Tamils
    */
     public static String readTamil(String key) {
        
        ResourceBundle rb = ResourceBundle.getBundle("res_bundles/cabletv_generic_TAMIL");
        String res = rb.getString(key);
        return res;
    }
}
