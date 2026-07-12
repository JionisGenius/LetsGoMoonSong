package SWEA.d2_2005_파스칼삼각형;

import java.util.Arrays;
import java.util.Scanner;

public class g2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int arr[][] = new int[N][N];
            for (int r = 0; r < N; r++) {
                arr[r][0] = 1;
                arr[r][r]=1;
                for (int c = 1; c < r; c++) {
                    arr[r][c] = arr[r - 1][c - 1] + arr[r - 1][c];
                }
            }
            System.out.println("#"+tc);
            for(int r=0;r<N;r++){
                for(int c=0;c<=r;c++){
                    if(arr[r][c]!=0){
                        System.out.print(arr[r][c]);
                        if(r!=c){
                            System.out.print(" ");
                        }

                    }
                }
                System.out.println();
            }
        }
    }
}
