package programmers.lv2_389480_perfect_crime;

import java.util.Arrays;

public class joonho {
    public int solution(int[][] info, int n, int m) {
        int stuff = info.length;
        int INF = Integer.MAX_VALUE;

        // dp[i][bMark] = i번째 물품까지 처리했고, b의 흔적이 bMark 일 때, a 흔적의 최소값을 저장
        int[][] dp = new int[stuff + 1][m];
        for (int i = 0; i <= stuff; i++) {
            Arrays.fill(dp[i], INF); // INF 처리 이유: 최소값을 구하는 것이기 때문에. 최대로 해놓고, 도달할 수 있는 지 판단
        }
        dp[0][0] = 0; // 처리한 물품이 없을 때. 처음 A의 흔적 0, B의 흔적 0. [0][1~stuff]은 끝날 때까지 INF

        for (int i = 0; i < stuff; i++) {

            int markA = info[i][0];
            int markB = info[i][1];

            for (int curB = 0; curB < m; curB++) {
                if (dp[i][curB] == INF) continue;
                int curA = dp[i][curB];
                int nextA = curA + markA;
                int nextB = curB + markB;

                if (nextA < n) // A에 저장
                    dp[i + 1][curB] = Math.min(dp[i + 1][curB], nextA);
                if (nextB < m) // B에 저장
                    dp[i + 1][nextB] = Math.min(dp[i + 1][nextB], curA);
            }
        }

        int answer = INF;
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[stuff][i]);
        }
        return (answer == INF) ? -1 : answer;
    }

}
    // 시간 초과
    /*
    boolean[] selected;
    int[][] info;
    int n, m, answer, mark, size;
    public int solution(int[][] info, int n, int m) {
        this.info = info.clone();
        this.size = info.length;
        selected = new boolean[size];
        this.n = n;
        this.m = m;
        answer = Integer.MAX_VALUE;
        mark = 0;
        dfs(0, 0, 0, 0, 0);
        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        return answer;
    }

    void dfs (int index, int aSelectCnt, int bSelectCnt, int aMark, int bMark){
        if(aMark >= n || bMark >= m) return;
        if(aSelectCnt + bSelectCnt == size){
            answer = Math.min(answer, aMark);
        }

        if(index >= size) return;

        if(aSelectCnt < n){
            selected[index] = true;
            dfs(index + 1, aSelectCnt + 1, bSelectCnt, aMark + info[index][0], bMark);
            selected[index] = false;
        }
        if(bSelectCnt < m){
            selected[index] = true;
            dfs(index + 1, aSelectCnt, bSelectCnt + 1, aMark, bMark + info[index][1]);
            // selected[index] = false;
        }
    }
    */
