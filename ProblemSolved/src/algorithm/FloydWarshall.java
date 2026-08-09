package algorithm;

import java.util.Arrays;
import java.util.Scanner;

// 모든 정점에서 모든 정점을 도달하는 최소 경로의 수를 각각 구한다

public class FloydWarshall {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(input1);

        int V = sc.nextInt(); // 정점의 개수 ( 시작 정점의 번호 잘 확인 )
        int E = sc.nextInt(); // 간선의 개수

        int[][] dist = new int[V][V]; // 0번부터일 땐 V
        // 나 자신으로 가는 길은 0 나머지는 INF
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++) {
                if (i != j)
                    dist[i][j] = INF;
            }
        // 입력받아서 연결된 간선 정보 등록
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int cost = sc.nextInt();

            dist[s][e] = cost; // 유향
        }
        // 플로이드 워셜
        for (int k = 0; k < V; k++) { // 경유지
            for (int i = 0; i < V; i++) { // 출발지
                if (dist[i][k] == INF)
                    continue;
                for (int j = 0; j < V; j++) { // 도착지
                    if (dist[k][j] == INF)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        // 옵션) 음수 사이클 검사
        boolean negativeCycle = false;
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                negativeCycle = true;
                break;
            }
        }

        if(negativeCycle)
            System.out.println("음의 사이클 존재");
        else {
            for(int i = 0 ; i < V ; i++)
                System.out.println(Arrays.toString(dist[i]));
        }
    }

    static String input1 = "5 9\r\n" + "0 1 3\r\n" + "0 2 8\r\n" + "0 4 -4\r\n" + "1 3 1\r\n" + "1 4 7\r\n"
            + "2 1 4\r\n" + "3 0 2\r\n" + "3 2 -5\r\n" + "4 3 6";
    static String input2 = "4 5\r\n" + "0 1 1\r\n" + "0 3 4\r\n" + "1 2 1\r\n" + "2 0 -3\r\n" + "3 2 2";
}
