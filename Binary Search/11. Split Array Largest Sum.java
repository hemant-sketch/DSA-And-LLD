// Lc 410
// https://leetcode.com/problems/split-array-largest-sum/description/

// Lc 1011
// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

// TC = O(N*logN)
// SC = O(1)

class Solution {
    public long max(int[] books){
        long ans = Integer.MIN_VALUE;
        for(int pages : books){
            ans = Math.max(ans, pages);
        }
        return ans;
    }

    public long sum(int[] books){
        long ans = 0;
        for(int pages : books){
            ans += pages;
        }
        return ans;
    }

    public boolean isPossible(int[]books, int allowedStuds, long maxLoad){
        int currLoad = 0;
        int reqStudents = 1;
        
        for(int pages : books){
            if(currLoad + pages <= maxLoad){
                currLoad += pages;
            }else {
                currLoad = pages;
                reqStudents++;
            }
        }
        return (reqStudents <= allowedStuds);
    }


    public int splitArray(int[] books, int studs) {
        long left = max(books);
        long right = sum(books);
        
        while(left <= right){
            long mid = left + (right-left)/2;
            
            if(isPossible(books, studs, mid) == true){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return (int)left;
    }
}
