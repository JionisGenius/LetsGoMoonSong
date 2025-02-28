package baekjoon.s5_2839_설탕배달;

import java.util.Scanner;

public class jioni {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int bags =0;
        while (N>0){
            if (N%5==0){
                System.out.print(N/5+bags);
            }else{
                N=-3;
                bags+=1;
            }
        }

    }
}
