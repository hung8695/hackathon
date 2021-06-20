package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid {
    public static boolean validate(String regex, String information){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher= pattern.matcher(information);
        return matcher.matches();
    }
}
