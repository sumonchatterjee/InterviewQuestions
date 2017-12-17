package google;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sumon.chatterjee on 16/12/17.
 */
public class Wordbreak {

    private boolean check(String s, Set<String> dict){

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }


    public static void main(String[] args) {
        Set<String>v=new HashSet<>() ;

        v.add("leet");
        v.add("code");
        Wordbreak brk = new Wordbreak();
        brk.check("leetcode",v);
    }
}
