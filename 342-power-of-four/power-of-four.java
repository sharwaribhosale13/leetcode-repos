class Solution {
    public boolean isPowerOfFour(int n) {
        // must be positive, power of 2, and (n-1) divisible by 3
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }
}