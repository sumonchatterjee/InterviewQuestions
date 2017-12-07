package google;

/**
 * Created by sumon.chatterjee on 04/12/17.
 */
public class SentenceScreenFitting {


    public static void main(String[] args) {
        String[] arr={"a", "bcd", "e"};
        SentenceScreenFitting fitting = new SentenceScreenFitting();
        fitting.wordsTyping(arr,3,6);
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String all = "";
        for (String s : sentence) {
            all += s + " ";
        }
        int pos = 0;
        int len = all.length();
        for (int i = 0; i < rows; i++) {
            pos += cols;
            if (all.charAt(pos % len) == ' ') {
                pos++;
            } else {
                while (pos > 0 && all.charAt((pos - 1) % len) != ' ') {
                    pos--;
                }
            }
        }
        return pos / len;
    }
}
