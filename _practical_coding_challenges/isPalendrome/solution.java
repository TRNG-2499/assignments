class Solution {
    public boolean isPalindrome(int x) {
        String str = new StringBuilder(String.valueOf(x)).reverse().toString();

        return (String.valueOf(x).equals(str)) ? true : false;
    }
}