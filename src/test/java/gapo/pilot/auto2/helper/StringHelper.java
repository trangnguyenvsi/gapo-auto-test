package gapo.pilot.auto2.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringHelper {

   public static String removeSpecialText(String content){
       int index = content.indexOf("@");
       return content = content.substring(index + 1, content.length());
    }

    public static List<String> separateStringToList(String csv){
        // step one : converting comma separate String to array of String
        String[] elements = csv.split(",");
        // step two : convert String array to list of String
         List<String> fixedLenghtList = Arrays.asList(elements);
        ArrayList<String> listOfString = new ArrayList<String>(fixedLenghtList);

         return listOfString;
    }
}
