package amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sumon.chatterjee on 01/08/17.
 */
public class SecondMostRepeatedStringInASequence {


    class MyObj {
        int freq;
        String data;
    }

    private String getSecondMostRepeatedCharacter(String str){

        MyObj maxVal = new MyObj();
        MyObj secMaxVal = new MyObj();
        String[] splitted = str.split("\\s+");

        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<splitted.length ; i++) {
            if (map.containsKey(splitted[i])) {
                int cont = map.get(splitted[i]);
                map.put(splitted[i], cont + 1);
            } else {
                map.put(splitted[i], 1);
            }
        }


        for (String word : map.keySet()){

            int currentVal = (Integer) map.get(word);
            System.out.println(word + " " + (Integer) map.get(word));

            if(currentVal > maxVal.freq) {

                secMaxVal.freq = maxVal.freq;
                secMaxVal.data = maxVal.data;

                maxVal.freq = currentVal;
                maxVal.data = word;
            } else if (currentVal > secMaxVal.freq) {
                secMaxVal.freq = currentVal;
                secMaxVal.data = word;
            }

        }

        System.out.println("-------------------------");
        System.out.println("highest frequency is - " +  maxVal.data);
        System.out.println("second highest frequency is - " +  secMaxVal.data);





        return secMaxVal.data;
    }



public static void main(String[] args){
        SecondMostRepeatedStringInASequence sec = new SecondMostRepeatedStringInASequence();
        sec.getSecondMostRepeatedCharacter("aaa bbb aaa mmm ccc bbb aaa");
}



}
