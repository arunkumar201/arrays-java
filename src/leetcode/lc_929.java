package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class lc_929 {
    //929. Unique Email Addresses
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for (String email : emails) {
            String[] arr = email.split("@");
            String local = arr[0].replace(".", "");
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf("+"));
            }
            String domain = arr[1];
            set.add(local + "@" + domain);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] email = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};

        int res = new lc_929().numUniqueEmails(email);
        System.out.println(res);
    }
}
