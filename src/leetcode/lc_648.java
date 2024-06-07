package leetcode;

import java.util.ArrayList;
import java.util.List;


public class lc_648 {
    public String replaceWords_sol_1(List<String> dictionary, String sentence) {
        // Split the String into words array
        String[] words = sentence.split(" ");

        // iterate over the word array
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // initialize length to Integer.MAX_VALUE for picking up the shortest word
            int len = Integer.MAX_VALUE;
            for (String s : dictionary) {
                // check if the word starts with the dictionary word
                if (word.startsWith(s)) {
                    // if yes and len is less than prev matching, update the length
                    if (s.length() < len) {
                        len = s.length();
                        words[i] = s;
                    }
                }
            }
        }
        return String.join(" ", words);
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        List<String> mutableDictionary = new ArrayList<>(dictionary);
        mutableDictionary.sort((a, b) -> a.length() - b.length());

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (String s : mutableDictionary) {
                if (words[i].startsWith(s)) {
                    words[i] = s;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        //Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
        //Output: "the cat was rat by the bat"

        String[] dictionary = new String[]{"cat", "bat", "rat"};
        String sentence = "the cattle was rattled by the battery";
        String res = new lc_648().replaceWords(List.of(dictionary), sentence);
        System.out.println(res);
    }
}




