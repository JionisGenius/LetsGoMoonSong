package baekjoon.b1_2869_달팽이;

import java.util.Scanner;

public class jioni {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();
        int count=0;

        V=V-A;
        count++;
        count+=V/(A-B);
        if (V%(A-B)>0){
            count++;
        }
        System.out.println(count);
    }
}