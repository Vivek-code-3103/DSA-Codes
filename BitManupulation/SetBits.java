package BitManupulation;
//package DynamicProgramming;

import java.util.*;
import java.io.*;

public class SetBits{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SetBits sb = new SetBits();
        int res = sb.countSetBits(n);
        System.out.println(res);
        sc.close();
    }
    public int countSetBits(int n ){
        int count=0;
        while(n!=0){
            int rsb = n&(-n);
            n ^= rsb;
            count++;
        }
        return count;
    }
}

