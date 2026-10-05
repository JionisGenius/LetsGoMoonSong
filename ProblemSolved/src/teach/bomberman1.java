package teach;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bomberman1 {
    static int[] df = {1, -1, 0, 0, 0, 0};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        // 선언
        char[][][] cube = new char[8][8][8];
        boolean[][][] visited = new boolean[8][8][8];

        // 입력
        Scanner sc = new Scanner(System.in);
        for (int f = 0; f < 8; f++) {
            for (int r = 0; r < 8; r++) {
                cube[f][r] = sc.nextLine().toCharArray();
            }
        }

        // 시작, 도착 지점 찾기
        int[] start = new int[3];
        int[] end = new int[3];
        for (int f = 0; f < 8; f++)
            for (int r = 0; r < 8; r++)
                for (int c = 0; c < 8; c++) {
                    if (cube[f][r][c] == 'A') {
                        start[0] = f;
                        start[1] = r;
                        start[2] = c;
                    }
                    if (cube[f][r][c] == 'Z') {
                        end[0] = f;
                        end[1] = r;
                        end[2] = c;
                    }
                }

        // BFS
        int answer = -1;
        // 시작
        Queue<Node> queue = new LinkedList<>();
        Node startNode = new Node(start[0], start[1], start[2], 0);
        queue.add(startNode);
        visited[start[0]][start[1]][start[2]] = true;
        // 현재 위치에서 지나갈 수 있는 지점을 Queue에 넣기
        while (!queue.isEmpty()) {
            Node cur = queue.poll(); // 현재 위치
            if (cur.f == end[0] && cur.r == end[1] && cur.c == end[2]) { // 현재 위치가 탈출 위치와 같다면
                answer = cur.d; // 정답 = 탈출까지 거리
                break;
            }
            for (int d = 0; d < 6; d++) {
                int nf = cur.f + df[d];
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                int nd = cur.d + 1;
                if (nf < 0 || nf >= 8 || nr < 0 || nr >= 8 || nc < 0 || nc >= 8) continue; // 인덱스 밖
                if (visited[nf][nr][nc]) continue; // 이미 왔던 곳
                if (cube[nf][nr][nc] == '1') continue; // 벽
                Node nextNode = new Node(nf, nr, nc, nd);
                queue.add(nextNode);
                visited[nf][nr][nc] = true;
            }
        }
        System.out.println(answer);
    }

    static class Node {
        int f, r, c; // 위치
        int d; // A부터 거리

        Node(int f, int r, int c, int d) {
            this.f = f;
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
