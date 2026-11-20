class Solution {
    public int reverse(int x) {
        long abs_int = Math.abs((long) x);

        String reversed = new StringBuilder(Long.toString(abs_int))
                .reverse()
                .toString();

        long result = Long.parseLong(reversed);
        if (x < 0) {
            result = -result;
        }

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) result;
    }
}
