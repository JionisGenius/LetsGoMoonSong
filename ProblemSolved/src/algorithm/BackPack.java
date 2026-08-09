package algorithm;

import java.util.Scanner;

public class BackPack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 물건의 개수
        int W = sc.nextInt(); // 배낭의 무게

        // 무게와 값어치 -> 2차원 배열 입력 / 1차원 2개
        int[] weights = new int[N + 1];
        int[] cost = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            weights[i] = sc.nextInt();
            cost[i] = sc.nextInt();
        } // 입력 완료

        int[][] dp = new int[N + 1][W + 1];
        // 물건은 한개씩만 존재
        // i : 이번에 고민할 물건
        for (int i = 1; i <= N; i++) {
            // 임시 무게
            for (int w = 0; w <= W; w++) {
                // 1. 내가 고려할 물건의 무게가 임시 무게보다 작다면
                if (weights[i] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + cost[i]);
                }
                // 2. 내가 고려할 물건의 무게가 임시 무게보다 크다면
                // 배낭에 안들어갈 정도로 크다면
                else {
                    // 바로 직전의 행의 열의 값을 그대로 가져오면 되겠다.
                    dp[i][w] = dp[i - 1][w];
                }
            }//임시무게
        }// 물건
        System.out.println(dp[N][W]);
    }

}
/* 스캐너 입력
4
10
5 10
4 40
6 30
3 50
*/