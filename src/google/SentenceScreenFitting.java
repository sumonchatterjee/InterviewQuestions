package google;

/**
 * Created by sumon.chatterjee on 04/12/17.
 */
public class SentenceScreenFitting {

    /*We first concatenate all strings together
    and add spaces between words.
    This string is the actual length we need to fit the string.
    Now we have a pos variable that initializes to 0, this is the position in the All string.
    Now for each row, we add cols to pos, this is the position in the All string
    that we can fit in the row. If the pos in the All string is pointing to a white space,
    we know we have just fitted (at least partial) strings in it. pos increment by 1.
    If its a letter, we know its in the middle of the word, so we need to decrease the pos to the start of the word.
    Here using pos % len indicates if pos is larger than len, it will go back to a position in the string.*/


    public static void main(String[] args) {
        String[] arr={"a", "bcd", "e"};
        SentenceScreenFitting fitting = new SentenceScreenFitting();
        fitting.wordsTyping(arr,3,6);
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String all = "";
      //  String s = String.join(" ", sentence) + " ";
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

//optimised o(m+n)
    //m-length of sentence by char,n rows
    public int wordsTypings(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length(), count = 0;
        int[] map = new int[len];
        for (int i = 1; i < len; ++i) {
            map[i] = s.charAt(i) == ' ' ? 1 : map[i-1] - 1;
        }
        for (int i = 0; i < rows; ++i) {
            count += cols;
            count += map[count % len];
        }
        return count / len;
    }
}
