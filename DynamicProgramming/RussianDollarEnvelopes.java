package DynamicProgramming;

import java.io.*;
import java.util.*;

  public class RussianDollarEnvelopes{
    class pair implements Comparable<pair>{
        int st;
        int en;
        pair(int st, int en){
            this.st = st;
            this.en = en;
        }
        public int compareTo(pair p){
            if(this.st==p.st)
               return p.en-this.en;
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
        RussianDollarEnvelopes m = new RussianDollarEnvelopes();
        int res = m.RDE(n,arr);
        System.out.println(res);
        sc.close();
    }
    public int RDE(int n, int[][]arr){
        pair pp[] = new pair[n];
        for(int i=0;i<n;i++)
          pp[i]=new pair(arr[i][0],arr[i][1]);
        Arrays.sort(pp);
        int dp[] = new int[n];
        int maxLength=0;
        for(int i=1;i<n;i++){
            int index = binarySearch(dp,0, maxLength,pp[i].en);
            dp[index] = pp[i].en;
            if(index==maxLength)
               maxLength++;
        }
        return maxLength;
    }
    public int binarySearch(int[] dp, int start, int end, int target){
           while(start<end){
               int mid = start + (end-start)/2;
               if(dp[mid]==target)
                  return mid;
               else if(dp[mid]<target)
                  start = mid+1;
               else
                  end = mid;
           }
        return start;
    }

}