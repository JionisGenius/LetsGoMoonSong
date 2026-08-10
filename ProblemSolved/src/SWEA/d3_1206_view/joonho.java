package SWEA.d3_1206_view;

import java.util.Scanner;

public class joonho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                //층을 배열에 저장하기
                arr[i] = sc.nextInt();
            }
            // 제일 높은 순 찾기
            int view = 0;
            for (int i = 0; i < N; i++) {
                int firstIdx = i;
                int first = 0;
                int second = 0;

                for (int j = i - 2; j <= i + 2; j++) {
                    if (j < 0 || j >= N) {
                        continue;
                    }
                    if (first < arr[j]) {
                        second = first; // 2등의 높이
                        first = arr[j]; // 최고층의 높이
                        firstIdx = j; // 최고층의 주소
                    } else if (second < arr[j]) {
                        second = arr[j]; // 2등의 높이만 바뀜
                    }
                }
                // j 범위 안에서 최고층이 i 이라면
                if (firstIdx == i) {
                    view += first - second; // 1등과 2등의 차이 만큼 조망권 획득
                }
            }
            System.out.println("#" + tc + " " + view);
        }
    }
}
