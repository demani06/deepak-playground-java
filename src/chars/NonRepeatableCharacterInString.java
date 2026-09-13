package chars;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatableCharacterInString {

    static void main() {

        String input = "swiss";

        //find the first non-repeating character in a String

        char[] charArray = input.toCharArray();
        Map<Character, Integer> countMap = new LinkedHashMap<>();

        for (char c : charArray) {
            //System.out.println("c = " + c);
            countMap.merge(c, 1, (oldValue, newValue) -> {
                System.out.println("oldValue = " + oldValue);
                System.out.println("newValue = " + newValue);
                return newValue + oldValue;
            });
        }


        System.out.println("countMap = " + countMap);

        /*for (Map.Entry<Character, Integer> characterIntegerEntry : countMap.entrySet()) {
            if(characterIntegerEntry.getValue()==1){
                System.out.println("got the value -->"+characterIntegerEntry);
                return;
            }
        }*/
        
        //using streams
        Map.Entry<Character, Integer> firstNonRepeatingEntry = countMap.entrySet().stream()
                .filter(characterIntegerEntry -> characterIntegerEntry.getValue()== 1)
                .findFirst()
                .orElseThrow(RuntimeException::new);


        System.out.println("firstNonRepeatingEntry = " + firstNonRepeatingEntry);

    }
}
