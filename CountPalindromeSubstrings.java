//Count the number of Palindrome Substrings
/*
Sample Input
aba
Sample Output
4
*/
import java.util.*;
public class MyClass {
    public static int countPalindromeSubstrings(String s) {

        int count=0;
        int n=s.length();
        //Odd Pallindromes
        for(int mid=0;mid<n;mid++)
        {
            count++;             //single length pallindrome
            int left=mid-1;
            int right=mid+1;
            while(left>=0&&right<n&&s.charAt(left)==s.charAt(right))
            {
                count++;
                left--;
                right++;
            }
        }
        
        //Even Pallindromes
        for(int mid1=0;mid1<n-1;mid1++)
        {
            int mid2=mid1+1;
            if(s.charAt(mid1)==s.charAt(mid2))
            {                                            
                count++;                     //palindrome of length 2
            }
            else
            {
                continue;
            }
            int left=mid1-1;
            int right=mid2+1;
             while(left>=0&&right<n&&s.charAt(left)==s.charAt(right))
            {
                count++;
                left--;
                right++;
            }
        }
        return count;

	}
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(countPalindromeSubstrings(s));
    }
}
