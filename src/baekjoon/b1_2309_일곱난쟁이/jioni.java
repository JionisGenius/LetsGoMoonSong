package baekjoon.b1_2309_일곱난쟁이;

import java.util.Scanner;

public class jioni {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Integer[] G = new Integer[9];


        for(int i=0; i<8; i++){
            int alt=0;
            if(G[i]>G[i+1]){
                alt=G[i];
                G[i]=G[i+1];
                G[i+1]=alt;
            }

        }

        int sum=0;
        for(int j=0; j<9; j++){
            sum+= G[j];
            if(sum==100){
                System.out.println(sum);
            } else if (sum>100) {
                sum-=G[j-1];
            }
        }




    }
}

///백준 2309번

