package SWEA.d4_1251_하나로;

import java.util.Scanner;

public class joonho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        // ===== 테스트케이스 시작 =====
        for (int tc = 1; tc <= T; tc++) {
            // ===== 입력 부분 시작 =====
            // 변수 선언
            int N, E; // 섬 갯수, 세율 실수
            int[] locX, locY; // 섬위치 X, Y
            long[][] dist; // 섬 거리제곱

            // 초기화
            N = sc.nextInt();
            locX = new int[N + 1];
            locY = new int[N + 1];
            dist = new long[N + 1][N + 1];

            // 섬 위치, 거리제곱(X^2 + Y^2) 저장
            for (int i = 1; i <= N; i++) {
                locX[i] = sc.nextInt();
                for (int j = 1; j < i; j++) {
                    dist[i][j] = (long) Math.pow(locX[i] - locX[j], 2); // 비용 += X 거리 제곱
                }
            }
            for (int i = 1; i <= N; i++) {
                locY[i] = sc.nextInt();
                for (int j = 1; j < i; j++) {
                    dist[i][j] += (long) Math.pow(locY[i] - locY[j], 2); // 비용 += Y 거리 제곱
                    dist[j][i] = dist[i][j]; // 양방향
                }
            }
            E = sc.nextInt(); // 세율 실수 E
            // ===== 입력 부분 끝 =====
            // ===== 크루스칼 시작 =====



            long answer = 0;
            sb.append("#" + tc + " " + answer+"\n");
        }
        System.out.println(sb);
    }
}
