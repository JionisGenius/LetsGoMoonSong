package SWEA.a_test_농사;

import java.util.Arrays;
import java.util.Scanner;

public class joonho {
    // {우, 전, 좌, 후}
    static int[] dc = {1, 0, -1, 0};
    static int[] dr = {0, -1, 0, 1};
    static int[] ndir = {3, 0, 2, 1}; // 보고 있는 방향에 따른 다음 dr, dc 변화량
    static int[][] matrix;
    static int[][] harvest_condition;
    static int[][] harvest_cnt;
    static boolean[][] isPlanted;
    static int N, M; // 한변의 크기, 날짜수
    static int max;
    // static boolean flag;

    static void main() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            max = 0;
            // 입력 시작
            N = sc.nextInt();
            M = sc.nextInt();
            matrix = new int[N][N];
            for (int r = 0; r < N; r++) {
                String[] line = sc.next().split("");
                for (int c = 0; c < N; c++) {
                    matrix[r][c] = Integer.parseInt(line[c]);
                }
            }

            // 잘 심어졌는지 확인
            // for (int r = 0; r < N; r++)
            //    System.out.println(Arrays.toString(matrix[r]));

            // 입력 끝
            for (int r = 1; r < N - 1; r++) {
                for (int c = 1; c < N - 1; c++) {
                    if (matrix[r][c] == 1) continue;
                    for (int d = 0; d < 4; d++) {
                        // flag = (tc == 1 && r == 2 && c == 2 && d == 0);
                        // if(flag) System.out.println("(2, 2) 시작");
                        harvest_condition = new int[N][N];
                        harvest_cnt = new int[N][N];
                        isPlanted = new boolean[N][N];
                        dfs(r, c, 1, 0, 0);
                    }
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }

    // dir : 0, 1, 2, 3 보는 방향 상, 좌, 하, 우
    static void dfs(int r, int c, int today, int cnt, int dir) {
        // 제한 조건
        if (today == M) {
            max = Math.max(max, cnt);
            return;
        }
        // 재귀 조건
        // ==== 낮 ====
        // 심기 가능 여부
        if (!isPlanted[r][c]) { // 안 심어져있다
            isPlanted[r][c] = true;
            harvest_condition[r][c] = today + 3 + harvest_cnt[r][c];
        } else if (harvest_condition[r][c] <= today) { // 심어져 있는데 수확 가능하다면
            isPlanted[r][c] = false; // 안심은 상태로 만든다
            cnt++; // 수확량+1
        }
        // ==== 밤 ====
        // 다음 이동
        int nr = -1;
        int nc = -1;
        int nd = -1;
        // 방향 정하기
        for (int d = 0; d < 4; d++) {
            nd = (dir + ndir[d]) % 4;
            int rr = r + dr[nd];
            int cc = c + dc[nd];
            // if(rr < 0 || rr >= N || cc < 0 || c >= N) continue; // 갈 수 없는 곳. (어차피 테두리는 1이라 안해도 됨)
            if (matrix[rr][cc] == 1) continue; // 산지
            if (harvest_condition[rr][cc] > today) continue; // 성장 중
            nr = rr;
            nc = cc;
            break;
        }
        // 이동 여부
        if (nr != -1) { // 이동
            // if(flag) System.out.printf("(%d, %d) 이동 \n", nr, nc);
            dfs(nr, nc, today + 1, cnt, nd);
        } else {// 가만히
            // if(flag) System.out.printf("(%d, %d) 멈춤 \n", r, c);
            dfs(r, c, today + 1, cnt, dir);
        }
    }
}
