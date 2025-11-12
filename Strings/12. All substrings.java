// https://www.naukri.com/code360/problems/all-substrings_1262347?leftPanelTabValue=PROBLEM

// Tc = O(N^3)
// Sc = O(1)
import java.util.* ;
import java.io.*; 
import java.util.Scanner;
class Solution {
	
    static void printSubstrings(String input) {
        // Write your code here
        for(int start=0; start < input.length(); start++) {
            for(int end=start; end < input.length(); end++) {
                for(int k=start; k <= end; k++) {
                    System.out.print(input.charAt(k)); 
                }
                System.out.println();
            }
        }
    }
    
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        printSubstrings(input);
	}
}



// Tc = O(N^3)   even tc is same here but using substring function we can strore the subStrings
// Sc = O(1)
import java.util.* ;
import java.io.*; 
import java.util.Scanner;
class Solution {
	
    static void printSubstrings(String input) {
        // Write your code here
        for(int start=0; start < input.length(); start++) {
            for(int end=start; end < input.length(); end++) {
                    System.out.println(input.substring(start, end+1)); 
                }
            }
        }
    
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        printSubstrings(input);
	}
}





