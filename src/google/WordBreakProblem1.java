package google;

import java.util.*;

/**
 * Created by sumon.chatterjee on 30/12/17.
 */
public class WordBreakProblem1 {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0) return true;
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (!visited.contains(start)) {
                for (int end = start + 1; end <= s.length(); end++) {
                    String sub = s.substring(start, end);
                    if (wordDictSet.contains(sub)) {
                        queue.offer(end);
                        if (end == s.length()) return true;
                    }
                }
                visited.add(start);
            }
        }
        return false;
    }


    public static void main(String[] args) {

        List<String> word= new ArrayList<>();
        word.add("leet");
        word.add("code");
        WordBreakProblem1 bb= new WordBreakProblem1();
        bb.wordBreak("leetcode",word);
    }
}
