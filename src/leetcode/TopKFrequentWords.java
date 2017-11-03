package leetcode;

import java.util.*;

/**
 * Created by sumon.chatterjee on 03/11/17.
 */


      /*  Given a non-empty list of words, return the k most frequent elements.
        Your answer should be sorted by frequency from highest to lowest.
        If two words have the same frequency, then the word with the lower alphabetical order comes first.*/
      /*Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
              Output: ["i", "love"]
              Explanation: "i" and "love" are the two most frequent words.
              Note that "i" comes before "love" due to a lower alphabetical order.*/

public class TopKFrequentWords {

private List<String> topKfrequentWords(String[] words, int k){
    Map<String, Integer> count = new HashMap();
    for (String word: words) {
        count.put(word, count.getOrDefault(word, 0) + 1);
    }

    List<String> candidates = new ArrayList(count.keySet());
    Collections.sort(candidates, (w1, w2) -> count.get(w1) != count.get(w2) ?
            count.get(w2) - count.get(w1) : w1.compareTo(w2));
    return candidates.subList(0, k);

}


    public static void main(String[] args) {
        String[]words={"i", "love", "leetcode", "i", "love", "coding"};
        TopKFrequentWords frequentWords =  new TopKFrequentWords();
        List<String> ans=frequentWords.topKfrequentWords(words,2);
        for(String s:ans){
            System.out.println(s);
        }
    }

}
