package leetcode;

public class lc_2000 {
    public String reversePrefix(String word, char ch) {
        StringBuilder res = new StringBuilder();
        int len = word.length();
        boolean isReached = false;
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) == ch && !isReached) {
                isReached = true;
                res.insert(0, word.charAt(i));
            } else if (word.charAt(i) != ch && !isReached) {
                res.insert(0, word.charAt(i));
            } else {
                res.append(word.charAt(i));
            }
        }
        return isReached ? res.toString() : word;
    }

    public String reversePrefix_Better(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        StringBuilder reversedPrefix = new StringBuilder(word.substring(0, index + 1));
        return reversedPrefix.reverse().append(word.substring(index + 1)).toString();
    }

    public static void main(String[] args) {
        String word = "abcd";
        char ch = 'z';
        System.out.println(new lc_2000().reversePrefix(word, ch));
        System.out.println(new lc_2000().reversePrefix_Better(word, ch));
    }
}
