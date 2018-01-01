package google;

import java.util.TreeSet;

/**
 * Created by sumon.chatterjee on 28/11/17.
 */
public class Test {

    public static void main(String[] args){

        RandomizedSetWithDuplicacy set= new RandomizedSetWithDuplicacy();
        set.insert(1);

        set.insert(3);
        set.insert(1);

        set.insert(5);
        int val =set.getRandom();
        set.remove(3);
        System.out.println("val = "+val);
        /*Test test= new Test();
        boolean check=test.isUniqueChars2("helo");
        if(check)
            System.out.println("yes");
        else
            System.out.println("no");*/

        /*StringsIterator iterator = new StringsIterator("L1e2t1C1o1d1e1");
        char c=iterator.next();
        iterator.hasNext();
        iterator.next();
        iterator.next();
        boolean check=iterator.hasNext();
*/





    }

    public static boolean isUniqueChars2(String str) {
         boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
            }
        return true;
    }
}
