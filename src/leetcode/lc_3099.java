package leetcode;

class lc_678 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sumOfTheDigits = 0;
        int temp = x;
        while (temp > 0) {
            int digit = temp % 10;
            sumOfTheDigits += digit;
            temp = temp / 10;
        }
        return (x % sumOfTheDigits == 0) ? sumOfTheDigits : -1;
    }

    public static void main(String[] args) {
        int x = 18;
        int res = new lc_678().sumOfTheDigitsOfHarshadNumber(x);
        System.out.println(res);
    }
}
