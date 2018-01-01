package google;

import java.util.*;

/**
 * Created by sumon.chatterjee on 30/12/17.
 */
public class WordBreakProblem2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        if (s == null || s.length() == 0) return null;

        Queue<Integer> queue = new ArrayDeque<>();
        Queue<String> sentences = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        queue.offer(0);
        sentences.add("");

        while (!queue.isEmpty()) {
            int start = queue.poll();
            String sent = sentences.poll();
            for (int end = start + 1; end <= s.length(); end++) {
                String sub = s.substring(start, end);
                if (wordDictSet.contains(sub)) {
                    String appended = sent+" "+sub;
                    if (end == s.length()) {
                        result.add(appended.trim());
                    } else {
                        queue.offer(end);
                        sentences.offer(appended.trim());
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<String>words= new ArrayList<>();
        words.add("cat");
        words.add("cats");
        words.add("and");
        words.add("sand");
        words.add("dog");

        String s="catsanddog";
        WordBreakProblem2 vb= new WordBreakProblem2();
        vb.wordBreak("catsanddog",words);
    }
}
