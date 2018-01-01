package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumon.chatterjee on 24/12/17.
 */
public class GenerateAbbrevition {


    public static void main(String[] args) {
        GenerateAbbrevition ab= new GenerateAbbrevition();
        ab.generateAbbreviations("word");
    }

    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();

        result.add(word);
        generateHelper(0, word, result);

        return result;
    }

    private void generateHelper(int start, String s, List<String> result) {
        if (start >= s.length()) {
            return;
        }

        for (int i = start; i < s.length(); i++) {
            for (int j = 1; i + j <= s.length(); j++) {
                String num = Integer.toString(j);
                String abbr = s.substring(0, i) + num + s.substring(i + j);
                result.add(abbr);
                generateHelper(i + 1 + num.length(), abbr, result); // skip 1b
            }
        }
    }
}
