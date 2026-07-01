import java.util.*;

// solution utility using Floyd's Tortoise and Hare
class Solution {
    // find the duplicate using cycle detection
    static int findDuplicate(int[] nums) {
        // initialize pointers at the start
        int slow = nums[0];
        int fast = nums[0];

        // move slow by 1 step and fast by 2 steps until they meet
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // reset fast to start to find the entrance to the cycle
        fast = nums[0];

        // move both by 1 step until they meet at the duplicate
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // return the duplicate value
        return slow;
    }
}

