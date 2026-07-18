class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = 0;
            int digit2 = 0;

            // Replace ternary with standard if blocks
            if (i >= 0) {
                digit1 = num1.charAt(i) - '0';
            }
            if (j >= 0) {
                digit2 = num2.charAt(j) - '0';
            }

            int total = digit1 + digit2 + carry;
            carry = total / 10;
            res.append(total % 10);

            i--;
            j--;
        }
        return res.reverse().toString();
    }
}
