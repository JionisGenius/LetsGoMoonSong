package SWEA.d3_1209_sum;

import java.util.Scanner;
// 행합 vs 열합 vs 대각선 합

public class jioni {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=10;
        for (int tc=1;tc<=T;tc++){
            int t=sc.nextInt();
            // 배열 값 입력
            int[][] arr = new int[100][100];
            for (int row=0; row<100;row++){
                for (int col=0; col<100; col++){
                    arr[row][col]=sc.nextInt();
                }
            }
            // 행합
            int row_max=0;
            for(int row=0; row<100; row++){
                int row_sum=0;
                for( int col=0; col<100; col++){
                    row_sum+=arr[row][col];
                }
                if (row_max<row_sum){
                    row_max=row_sum;
                }
            }
            // 열합
            int col_max=0;
            for (int col=0; col<100; col++){
                int col_sum=0;
                for (int row=0;row<100;row++){
                    col_sum+=arr[row][col];
                }
                if (col_max<col_sum){
                    col_max=col_sum;
                }
            }
            //대각선합
            int crossMax=0;
            for (int r=0; r<100; r++){
                crossMax+=arr[r][r];
            }
            int crossMax2=0;
            for (int r=0; r<100; r++){
                crossMax2+=arr[r][99-r];
            }
            // 4개의 변수 중에서 최대값
            int answer =0;
            if (answer<row_max){
                answer=row_max;
            }
            if (answer<col_max) {
                answer=col_max;
            }
            if (answer<crossMax){
                answer=crossMax;
            }
            if (answer<crossMax2){
                answer=crossMax2;
            }
            System.out.println("#"+tc+" "+answer);
        }
    }
}