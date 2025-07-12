// Quick Sort Parititoning Logic
// https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/partition-an-array-official/ojquestion

// brute force - left right pointers, jo chota woh left and left++ aur jo chota woh right mien aur right--

// Time = O(N) Linear, Space = O(1) Constant (Inplace)
// Not Stable (Relative Order Not Maintained for Greater Elements)

// lomuto partitioning

class Main {

    public static void partition(int[] arr, int pivot) {
        int left = 0, right = 0;
        while (right < arr.length) {
            if (arr[right] <= pivot) {
                swap(arr, right, left);
                left++;
                right++;
            } else {
                right++;
            }
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}  
