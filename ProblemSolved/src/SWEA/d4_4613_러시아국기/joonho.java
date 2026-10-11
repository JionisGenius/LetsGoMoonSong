package SWEA.d4_4613_러시아국기;

import java.util.*;

public class joonho {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // 입력 시작
            int N = sc.nextInt(); // 행
            int M = sc.nextInt(); // 열
            String[][] matrix = new String[N][M]; // 국기 이중배열
            // 국기 색 입력
            for (int r = 0; r < N; r++) {
                matrix[r] = sc.next().split("");
            }
            // 입력 끝
            // 비교 시작
            int minCount = Integer.MAX_VALUE; // 초기값을 아주 큰 값으로 설정

            // w : w 행까지 흰색으로 칠할 것이다
            // b : W+1행붵 b 행까지 파랑으로 칠할 것이다
            // b+1행부터 N-1 까지 빨강
            for (int w = 0; w < N - 2; w++) {
                for (int b = w + 1; b < N - 1; b++) {
                    // w값 정해짐, b값 정해짐
                    int count = 0;
                    // w 칠하기
                    for (int i = 0; i <= w; i++) {
                        for (int j = 0; j < M; j++) {
                            if (!matrix[i][j].equals("W")) {
                                count++;
                            }
                        }
                    }
                    // b 칠하기
                    for (int i = w + 1; i <= b; i++) {
                        for (int j = 0; j < M; j++) {
                            if (!matrix[i][j].equals("B")) {
                                count++;
                            }
                        }
                    }
                    // r 칠하기
                    for (int i = b + 1; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (!matrix[i][j].equals("R")) {
                                count++;
                            }
                        }
                    }
                    // 비교해서 최신화하기
                    minCount = Math.min(minCount, count);
                }
            }

            System.out.println("#"+tc+" "+minCount);
        }
    }
}
