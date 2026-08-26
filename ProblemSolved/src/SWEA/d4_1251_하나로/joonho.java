package SWEA.d4_1251_하나로;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class joonho {
    static int[] p; // 대표를 저장할 배열
    static int N; // 섬 갯수
    static double E;// 세율 실수
    static int[] locX, locY; // 섬위치 X, Y

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        // ===== 테스트케이스 시작 =====
        for (int tc = 1; tc <= T; tc++) {
            // ===== 입력 부분 시작 =====
            // 초기화
            N = sc.nextInt();
            locX = new int[N + 1];
            locY = new int[N + 1];

            // 섬 위치, 거리제곱(X^2 + Y^2) 저장
            for (int i = 1; i <= N; i++) {
                locX[i] = sc.nextInt();
            }
            for (int i = 1; i <= N; i++) {
                locY[i] = sc.nextInt();
            }
            E = sc.nextDouble(); // 세율 실수 E

            List<Edge> edges = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j < i; j++) {
                    long dx = (long) locX[i] - locX[j];
                    long dy = (long) locY[i] - locY[j];
                    long dist = dx * dx + dy * dy;
                    edges.add(new Edge(i, j, dist));
                }
            }
            edges.sort((e1, e2) -> Long.compare(e1.d, e2.d));
            // ===== 입력 부분 끝 =====
            // ===== 크루스칼 시작 =====
            p = new int[N + 1]; // 대표를 저장할 배열
            // 일단 본인이 자신의 대표
            for (int i = 1; i <= N; i++) {
                p[i] = i;
            }
            // 변수 선언
            long answer = 0;
            int pick = 0; // 뽑은 갯수
            // 작은 순서대로 돌아가면서 연결하기
            for (Edge edge : edges) {
                // 대표 찾기
                int ps = findP(edge.s);
                int pe = findP(edge.e);
                // 대표 같으면 이미 이어짐. 다르면 이어주기
                if (ps != pe) {
                    union(ps, pe);
                    pick += 1;
                    answer += edge.d;
                }
                // 간선은 정점의 수보다 1개 적어야함. 탈출!
                if (pick == N - 1) break;
            }
            answer = Math.round(E * answer);
            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(answer)
                    .append("\n");
        }
        sc.close();
        System.out.println(sb);
    }

    // 대표 찾기
    static int findP(int x) {
        if (p[x] != x)
            p[x] = findP(p[x]);
        return p[x];
    }

    // 대표 통합
    static void union(int pEdge1, int pEdge2) {
        p[pEdge1] = pEdge2;
    }

    static class Edge {
        int s, e; // start, end
        long d; // dist 제곱

        Edge(int s, int e, long dist) {
            this.s = s;
            this.e = e;
            this.d = dist;
        }
    }
}
