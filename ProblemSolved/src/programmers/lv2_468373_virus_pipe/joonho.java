package programmers.lv2_468373_virus_pipe;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/468373
// dfs bfs 동시에 사용하는 문제

public class joonho {

    List<Edge>[] graph;
    boolean[] infected;
    int n;
    int k;
    int answer;

    public int solution(int n, int infection, int[][] edges, int k) {
        // 연결
        graph = new ArrayList[n + 1];
        for (int node = 1; node <= n; node++) {
            graph[node] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int to = edge[0];
            int from = edge[1];
            int type = edge[2];
            graph[to].add(new Edge(from, type));
            graph[from].add(new Edge(to, type));
        }
        // 감염
        infected = new boolean[n + 1];
        infected[infection] = true;
        this.k = k;
        this.n = n;

        dfs(0, infected);

        return answer;
    }

    void dfs(int depth, boolean[] infected) {
        // 계산
        int infectCnt = 0;
        for (int i = 1; i <= n; i++)
            if (infected[i])
                infectCnt++;

        answer = Math.max(answer, infectCnt);

        // 종료
        if (depth == k || infectCnt == n) return;

        // 다음
        for (int type = 1; type <= 3; type++) {
            boolean[] next = infected.clone();
            spread(next, type);
            dfs(depth + 1, next);
        }

    }

    // bfs
    void spread(boolean[] infected, int type) {
        // 기존
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                queue.add(i);
            }
        }
        // 다음
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Edge e : graph[cur]) {
                if (infected[e.to] || type != e.type) // 이미 큐에 포함 또는 감염시킬 수 없음
                    continue;
                infected[e.to] = true;
                queue.add(e.to);
            }
        }

    }

    static class Edge {
        int to;
        int type;

        Edge(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }

}
