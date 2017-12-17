package google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sumon.chatterjee on 16/12/17.
 */
public class UniqueWordAbbrebiation {

        private Map<String, Integer> abbrDict;
        private Map<String, Integer> dict;
        public UniqueWordAbbrebiation(String[] dictionary) {
            abbrDict = new HashMap<>();
            dict = new HashMap<>();


            for (String word : dictionary) {

                if (dict.containsKey(word)) {
                    int freq = dict.get(word);
                    dict.put(word, freq + 1);
                } else {
                    dict.put(word, 1);
                }

                String abbr = abbreviation(word);
                if (abbrDict.containsKey(abbr)) {
                    int freq = abbrDict.get(abbr);
                    abbrDict.put(abbr, freq + 1);
                } else {
                    abbrDict.put(abbr, 1);
                }
            }
        }

        public boolean isUnique(String word) {
            if (word == null || word.length() == 0) {
                return true;
            }

            String abbr = abbreviation(word);
            if (!abbrDict.containsKey(abbr)) {
                return true;
            } else {
                if (dict.containsKey(word) && dict.get(word) == abbrDict.get(abbr)) {
                    return true;
                }
            }

            return false;
        }

        private String abbreviation(String word) {
            if (word.length() <= 2) {
                return word;
            }

            StringBuffer sb = new StringBuffer();
            sb.append(word.charAt(0));
            sb.append(word.length() - 2);
            sb.append(word.charAt(word.length() - 1));

            return sb.toString();
        }

}
