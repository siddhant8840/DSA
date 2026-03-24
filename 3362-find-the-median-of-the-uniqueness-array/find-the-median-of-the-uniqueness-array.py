from collections import defaultdict
from typing import List

class Solution:
    def medianOfUniquenessArray(self, nums: List[int]) -> int:
        n = len(nums)
        total = n * (n + 1) // 2
        median_pos = (total + 1) // 2

        def count_at_most_k(k):
            freq = defaultdict(int)
            distinct = 0
            count = 0
            left = 0

            for right in range(n):
                if freq[nums[right]] == 0:
                    distinct += 1
                freq[nums[right]] += 1

                while distinct > k:
                    freq[nums[left]] -= 1
                    if freq[nums[left]] == 0:
                        distinct -= 1
                    left += 1

                count += (right - left + 1)

            return count

        lo, hi = 1, n
        while lo < hi:
            mid = (lo + hi) // 2
            if count_at_most_k(mid) >= median_pos:
                hi = mid
            else:
                lo = mid + 1

        return lo