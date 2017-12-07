package google;

/**
 * Created by sumon.chatterjee on 28/11/17.
 */
public class Test {

    public static void main(String[] args){
        Test test= new Test();
        boolean check=test.isUniqueChars2("helo");
        if(check)
            System.out.println("yes");
        else
            System.out.println("no");
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
