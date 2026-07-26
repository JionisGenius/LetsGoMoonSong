package algorithm;

import java.util.Arrays;

public class TSP {
    static final long INF = Long.MAX_VALUE / 4;

    static long tsp(int[][] cost, int start) {
        int n = cost.length;
        int full = (1 << n) - 1;

        long[][] dp = new long[1 << n][n];

        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[1 << start][start] = 0;

        for (int visited = 0; visited <= full; visited++) {
            for (int current = 0; current < n; current++) {
                if (dp[visited][current] == INF) continue;

                for (int next = 0; next < n; next++) {
                    // 이미 방문한 정점
                    if ((visited & (1 << next)) != 0) continue;
                    // 갈 수 없는 경로
                    if (cost[current][next] == 0) continue;

                    int nextVisited = visited | (1 << next);
                    dp[nextVisited][next] = Math.min(dp[nextVisited][next], dp[visited][current] + cost[current][next]);
                }
            }
        }

        long answer = INF;

        for (int last = 0; last < n; last++) {
            if (last == start) continue;
            if (dp[full][last] == INF || cost[last][start] == 0) continue;
            answer = Math.min(answer, dp[full][last] + cost[last][start]);
        }

        return answer == INF ? -1 : answer;
    }
}
