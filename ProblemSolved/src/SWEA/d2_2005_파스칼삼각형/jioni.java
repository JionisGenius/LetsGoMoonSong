package SWEA.d2_2005_파스칼삼각형;

import java.util.Scanner;


public class jioni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int arr[][] = new int[N][N];
            arr[0][0] = 1;

            for (int r = 1; r < N; r++) {
                arr[r][0] = 1;
                for (int c = 1; c <= r; c++) {
                    arr[r][c] = arr[r - 1][c - 1] + arr[r - 1][c];
                    //c-1가 마이너스가 나올수가 있다 //c=1부터시작했다
                    //j가 0일때 값이없다
                }
            }

            System.out.println("#" + tc);
            for (int r = 0; r < N; r++) {
                //행
                for (int c = 0; c < N; c++) {
                    //각 글자
                    if (arr[r][c] != 0) {
                        //글자가 0이 아니면 프린트합니다
                        System.out.print(arr[r][c]);
                        //프린트할때 어떤조건에서는 띄어쓰기를 안할거에요
                        if (r!=c) {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}

