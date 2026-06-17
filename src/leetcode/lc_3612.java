package leetcode;

public class lc_3612 {

    public static void main(String[] args) {
        lc_3612 solution = new lc_3612();
        String s = "a#b%*";
        System.out.println(solution.processStr(s));

    }

    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*' || c == '#' || c == '%') {
                if (sb.length() > 0 && c == '*') {
                    // if '*' then needs to delete the last character
                    sb.deleteCharAt(sb.length() - 1);
                    System.out.println("after reverse: " + sb.toString());
                } else if (sb.length() > 0 && c == '#') {
                    // A '#' duplicates the current result and appends it to itself.
                    sb.append(sb.toString());
                    System.out.println("after duplicate: " + sb.toString());
                } else if (sb.length() > 0 && c == '%') {
                    // A '%' removes the current string.
                    sb.reverse();
                    System.out.println("after reverse: " + sb.toString());
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}