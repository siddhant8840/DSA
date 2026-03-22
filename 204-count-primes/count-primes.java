class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] prime = new boolean[n];

        // mark from 2 to n-1 as true
        for (int i = 2; i < n; i++) {
            prime[i] = true;
        }

        // sieve
        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        // count
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i]) count++;
        }

        return count;
    }
}