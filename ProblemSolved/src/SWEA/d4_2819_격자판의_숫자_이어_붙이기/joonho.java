package SWEA.d4_2819_격자판의_숫자_이어_붙이기;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class joonho {
    static String[][] matrix;
    static Set<String> set;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int tc = 1; tc <= T; tc++) {
            // ==== 입력 및 조기화 ====
            matrix = new String[4][4];
            for (int r = 0; r < 4; r++) {
                matrix[r] = sc.nextLine().split(" ");
            }
            set = new HashSet<>();
            // ==== 입력 끝 ====
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    dfs(r, c, matrix[r][c]);
                }
            }
            System.out.println("#" + tc + " " + set.size());
        }
    }

    static void dfs(int r, int c, String word) {
        if (word.length() == 7) {
            set.add(word);
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= 4 || nc >= 4) continue;
            dfs(nr, nc, word + matrix[nr][nc]);
        }
    }
}
