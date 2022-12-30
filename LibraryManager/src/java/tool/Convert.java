package tool;

import java.time.LocalDate;

public class Convert {

    public static LocalDate convertDate(String date) {

        String[] items = date.split("-");

        return LocalDate.of(Integer.parseInt(items[0]),
                Integer.parseInt(items[1]),
                Integer.parseInt(items[2]));
    }
    
    public static String ConvertPattern(String text, boolean percent){
        return "\"%" + text + "%\"";
    }
    
    public static String ConvertPattern(String text){
        return "\"" + text + "\"";
    }
    
}
