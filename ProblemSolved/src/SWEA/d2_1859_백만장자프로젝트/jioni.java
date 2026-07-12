package SWEA.d2_1859_백만장자프로젝트;

import java.util.Scanner;

//for문으로 마지막날 기준으로 1일 전으로 가면서 비교
//범위조심 1만*100만 = 100억
//21억 이상은 int가 overflow
// long을 사용한다 922경

public class jioni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for (int d = 0; d < N; d++) {
                arr[d] = sc.nextInt();
            }
            long sell = 0;
            int max = arr[N-1]; // 마지막날
            for (int d = N - 2; d >= 0; d--) {  //전날비교
                if (arr[d] > max) {
                    max = arr[d];
                } else if (arr[d] < max) {
                    sell += max - arr[d];
                }
            }
            System.out.println("#"+tc+" "+sell);
        }
    }
}
