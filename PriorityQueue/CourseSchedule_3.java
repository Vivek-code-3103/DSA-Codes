package PriorityQueue;

import java.util.*;
import java.io.*;

public class CourseSchedule_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]courses = new int[n][2];
        for(int i =0 ;i<n;i++){
            courses[i][0] = sc.nextInt();
            courses[i][1] = sc.nextInt();
        }
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        int sum=0;
        for(int i = 0 ;i < n; i++){
            if(courses[i][0]>courses[i][1])continue;
            if(sum+courses[i][0]<=courses[i][1]){
                ans++;
                sum+= courses[i][0];
                pq.add(courses[i][0]);
                
            }else{
                if(pq.peek()>courses[i][0]){
                    sum-= pq.poll();
                    pq.add(courses[i][0]);
                    sum+= courses[i][0];
                }             
            }
             
        }
        System.out.println(ans);
        sc.close();
    }
}