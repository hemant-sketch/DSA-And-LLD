// https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

// TC = O(N*logN)
// SC = O(1)

class Solution {
    public static long max(int[] books){
        long ans = Integer.MIN_VALUE;
        for(int pages : books){
            ans = Math.max(ans, pages);
        }
        return ans;
    }
    
    public static long sum(int[] books){
        long ans = 0;
        for(int pages : books){
            ans += pages;
        }
        return ans;
    }
    
    public static boolean isPossible(int[]books, int allowedStuds, long maxLoad){
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
    
    public static int findPages(int[] books, int studs) {
        // code here
        if (books.length < studs)
            return -1;
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
