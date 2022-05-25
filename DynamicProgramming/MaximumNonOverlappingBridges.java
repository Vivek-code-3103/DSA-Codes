package DynamicProgramming;

import java.io.*;
import java.util.*;

public class MaximumNonOverlappingBridges{
    class pair implements Comparable<pair>{
        int st;
        int en;
        pair(int st, int en){
            this.st = st;
            this.en = en;
        }
        public int compareTo(pair p){
            if(this.st==p.st)
               return this.en-p.en;
            else
               return this.st-p.st;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        MaximumNonOverlappingBridges m = new MaximumNonOverlappingBridges();
        int res = m.MNOB(n,arr);
        System.out.println(res);
        sc.close();
    }
    public int MNOB(int n, int[][]arr){
        pair pp[] = new pair[n];
        for(int i=0;i<n;i++)
          pp[i]=new pair(arr[i][0],arr[i][1]);
        Arrays.sort(pp);
        int dp[] = new int[n];
        dp[0]=1;
        int max=0;
        for(int i=1;i<n;i++){
            max=0;
            for(int j=0;j<i;j++){
                if(pp[i].en>pp[j].en)
                  max = Math.max(max,dp[j]);
            }
            dp[i]=max+1;
        }
        max=0;
        for(int val:dp)
          max = Math.max(max,val);
          return max;
    }

}