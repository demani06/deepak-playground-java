package misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumExample {

    static void main() {
        int[] numbers = {2, 4, 5,  7, 11, 15};
        int target = 9;
        var output = getTwoSumValues(numbers, target);
        System.out.println("output = " + Arrays.toString(output));
    }

    static int[] getTwoSumValues(int[] numbers, int target){
        Map<Integer, Integer> seenMap = new HashMap<>();
        //Find the indices of the two numbers whose sum equals the target.
        for (int i = 0; i < numbers.length-1 ; i++) {
            var needed = target-numbers[i];
            System.out.println("calulcated needed = " + needed);
            System.out.println("seenMap = " + seenMap);
            if(seenMap.containsKey(needed)){
                System.out.println("matched........");
                return new int[]{seenMap.get(needed), i};
            }
            System.out.println("inserting into map numbers[i] =" + numbers[i] + " and i value ="+i);
            seenMap.put(numbers[i], i );
        }
        return null;
    }



    //Find the indices of the two adjacent numbers whose sum equals the target.
        /*for (int i = 0; i < numbers.length-1 ; i++) {
            if(numbers[i]+ numbers[i+1] == target){
                System.out.println(numbers[i]);
                System.out.println(numbers[i+1]);
            }
        }*/
}
