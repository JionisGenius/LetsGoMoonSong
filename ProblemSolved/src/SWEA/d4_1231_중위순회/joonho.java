package SWEA.d4_1231_중위순회;

import java.util.Scanner;

public class joonho {
    static Node[] nodes; // 저장 형식
    static StringBuilder sb; // 정답 한글자씩 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            // 입력 시작
            int N = sc.nextInt();
            sc.nextLine(); // nextInt -> nextLine 사용하기 때문에 줄바꿈 없애기
            // 1부터 n까지 숫자가 있으므로 N + 1
            nodes = new Node[N + 1];
            sb = new StringBuilder();
            // 미리 결과값에 #tc 넣어주기
            sb.append("#").append(tc).append(" ");
            // nodes 값 입력
            for (int i = 0; i < N; i++) {
                // 이번 줄 배열 {숫자, 단어, 자식1, 자식2} 자식은 없을 수 있음
                String[] line = sc.nextLine().split(" ");
                int num = Integer.parseInt(line[0]);

                // node
                nodes[num] = new Node(); // 초기화
                nodes[num].letter = line[1]; // 단어 저장
                // 자식 저장
                if (line.length == 3) { // 자식 1명
                    nodes[num].child = new int[1];
                    nodes[num].child[0] = Integer.parseInt(line[2]);
                }
                if (line.length == 4) { // 자식 2명
                    nodes[num].child = new int[2];
                    nodes[num].child[0] = Integer.parseInt(line[2]);
                    nodes[num].child[1] = Integer.parseInt(line[3]);
                }
            }
            // 입력 끝
            // dfs 시작 지점 1
            dfs(1);

            System.out.println(sb);
        }
    }

    static void dfs(int num) {
        Node cur = nodes[num];

        // 왼쪽
        if (cur.child != null) // 자식이 있고
            if(cur.child.length >= 1) // 자식 갯수가 1개 이상이면
                dfs(cur.child[0]);
        // 나
        sb.append(cur.letter);
        // 오른쪽
        if (cur.child != null) // 자식이 있고
            if (cur.child.length >= 2) // 자식 갯수가 2개 이상이면
                dfs(cur.child[1]);
    }

    static class Node {
        String letter;
        int[] child;
    }
}

// Node[] nodes
// Node node = nodes[1]
// node.letter 1번 노드에 적힌 글자
// node.child 1번 노드의 자식 배열
// node.child[0] 1번 노드의 왼쪽 자식
// node.child[1] 1번 노드의 오른쪽 자식