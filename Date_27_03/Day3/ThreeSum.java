import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        
    }

    public List<List<Integer>> threeSum(int[] nums) {
            
        /*
        Approach: Sort the array. Have a set of list of integers (threeSumSet), to store three sum cobos.
                  Go through each item (i). For each item, have two pointers: one pointing to the next item (j), and another
                  one pointing to the end of the array (k). Now, do a 2-way-sweep. While j and k doesn't meet, at each step
                  calculate sum = (nums[i]+nums[j]+nums[k]).
                  [Starting sweep from next item to prevent duplicate combos because of indexes like ( [i,j,k], [j,i,k]).]
                  If sum == 0, we found a three-sum combo! Add it to the threeSumSet. If there is any
                  duplicate combo because of different indexes but same items like 
                  ([i1, j1, k1], [i2, j2, k2], but i1==i2, j1==j2, k1==k2). This will automatically be taken care of by the 
                  set, as it analyzes the added Lists and makes sure there is no duplicate.                   
                  If sum > 0, we should try decreasing the sum value. So we'll decrement k, as this should potentially
                  result nums[k] being smaller than previous value, as the array is sorted.
                  If sum < 0, because of the same reason, we'll increment j.
                  Finally, we'll convert the threeSumSet to ArrayList and return.
        
        Complexity analysis: Time: O(n^2), Space: O(n)
        */
        
        Set<List<Integer>> threeSumSet  = new HashSet<>();
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2;i++){                         //Doing length-2, because we want two elems j and k after i.
            int j =i+1;
            
            int k = nums.length-1;
            
            while(j<k){
                
                int sum = nums[i]+nums[j]+nums[k];
                
                if(sum==0){
                    threeSumSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                    j++;
                    k--;
                }
                else if (sum > 0){
                    k--;
                } 
                else if (sum < 0){
                    j++;
                } 
            }

        }
        
        return new ArrayList<>(threeSumSet);
    }

/*
    The idea is to sort an input array and then run through all indices of a possible first element of a triplet.
     For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array.
     Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
*/

    public List<List<Integer>> threeSumFast(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return res;
    }


}
