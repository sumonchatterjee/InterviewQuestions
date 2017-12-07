package google;

/**
 * Created by sumon.chatterjee on 28/11/17.
 */
public class IdenticalCount {


    public static void main(String[] args) {
        IdenticalCount count= new IdenticalCount();
        count.testing("f b n mk");
    /*    boolean check=count.anagram("ffff","ffff");
        if(check)
            System.out.println("yes");
        else
            System.out.println("no");*/
    }

    private boolean anagram(String s1,String s2){

        int num_unique_chars = 0;
        int num_completed_t = 0;

        if(s1.length()!=s2.length())
            return false;

         char[] s_array = s1.toCharArray();
         int[] letters= new int[256];

         for(char s:s_array)
             if(letters[s]==0){
                 num_unique_chars++;
                 ++letters[s];
             }

        for (int i = 0; i < s2.length(); ++i) {
            int c = (int) s2.charAt(i);
            if (letters[c] == 0) { // Found more of char c in t than in s.
                return false;
            }
            --letters[c];
            if (letters[c] == 0) {
                ++num_completed_t;
                 if (num_completed_t == num_unique_chars) {
                    // it’s a match if t has been processed completely
                    return i == s2.length() - 1;
                    }
                }
             }



         return false;

    }



    private void testing(String m){
        int spaceCount=0;
        char[]space=m.toCharArray();

        for(int i=0;i<space.length;i++){
           {
             if(space[i]==' '){
                spaceCount++;
             }
            }
        }
    }
}
