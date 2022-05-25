package DynamicProgramming;

import java.util.*;
import java.io.*;

public class LIS{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
          arr[i] = sc.nextInt();
        LIS ss = new LIS();
        int res = ss.longestIncreasingSubstring(n,arr);
        System.out.println(res);
        sc.close();
    }
    public int longestIncreasingSubstring(int n, int []arr){
        int dp[] = new int[n];
        dp[0]=1;
        int max=0;
        for(int i=1;i<n;i++){
            max=0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j])
                   max = Math.max(max,dp[j]);
            }
            dp[i]=max+1;
        }
        max=0;
        for(int val: dp)
         max = Math.max(max,val);
         return max;
    }
}