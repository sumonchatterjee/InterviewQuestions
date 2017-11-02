package amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sumon.chatterjee on 28/07/17.
 */
public class Anagrams {

    //1st approach
    private boolean findNoOfCharactersToBeDeletedToBeAnagram(String first, String second){

            Map<Character, Integer> map = new HashMap<>();
            for(char c: first.toCharArray())
                if(map.containsKey(c))
                    map.put(c, map.get(c) + 1);

                else
                    map.put(c, 1);


            for(char c: second.toCharArray())
                if(!map.containsKey(c)) {
                    return false;
                }

                else
                {
                    map.put(c, map.get(c) - 1);

                    if(map.get(c) == 0)
                        map.remove(c);
                }


       return map.isEmpty();

    }


    private int findNoOfCharactersToDeletedToBeAnagram(String first, String second){

        int count=0;

        Map<Character, Integer> map = new HashMap<>();
        for(char c: first.toCharArray())
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);

            else
                map.put(c, 1);


            for(char c: second.toCharArray())
            if(map.containsKey(c)) {
                count++;

            }


        return count;

    }

    //second approach to find anagrams
    private static boolean areAnagrams(String one, String two)
    {
        int[] array = new int[256];

        for(char c: one.toCharArray())
            array[c] ++;

        for(char c: two.toCharArray())
            array[c] --;

        for(int i = 0; i < 256; ++ i)
            if(array[i] != 0) {
                return false;
            }

        return true;
    }

    public static void main(String[]args){

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter 1st string ");
        String a=sc.nextLine();

        System.out.println("Enter 1st string ");
        String b=sc.nextLine();


        Anagrams an =new Anagrams();
        boolean c= an.areAnagrams(a,b);

            System.out.println(""+c);
    }
}
