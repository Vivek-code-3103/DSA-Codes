package PriorityQueue;

import java.util.*;
import java.io.*;

public class CTAWMS_LT1354{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target[] = new int[n];
        for(int i = 0 ;i < n;i++)
           target[i]=sc.nextInt();

        if(target.length==1 && target[0]!=1){
            System.out.println(false);
            return;
        }
       if(target.length==1 && target[0]==1){
            System.out.println(true);
           return;
       }
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       int sum=0;
       for(int num : target){
           pq.offer(num);
           sum+= num;
       }
       while(pq.peek()!=1){
           int max = pq.poll();
           int diff = sum-max;
           if(diff==1){
            System.out.println(true);
           return;
           }
           int val = max % diff;
           sum = sum - max + val;
           if(val==0 || val==max){
            System.out.println(false);
           return;
           }
           else
               pq.add(val);
          }         
        System.out.println(true);
    
        sc.close();
    }
}