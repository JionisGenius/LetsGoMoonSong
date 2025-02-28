package baekjoon.s5_17286_유미;

import java.util.Scanner;

public class Joonho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xu = sc.nextInt();
        int yu = sc.nextInt();

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        sc.close();

        // 각 변의 길이 = 다른 친구로 가는 거리

        int leg12 = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        int leg13 = (int) Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        int leg23 = (int) Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        int[][] move = new int[4][2];
        move[1][0] = leg12 + leg23; // 1 2 3
        move[1][1] = leg13 + leg23; // 1 3 2
        move[2][0] = leg23 + leg13; // 2-3-1
        move[2][1] = leg12 + leg23; // 2-1-3
        move[3][0] = leg13 + leg12; // 3 1 2
        move[3][1] = leg23 + leg12; // 3 2 1

        // 처음 위치에서 친구에게 가는 거리
        int d1 = (int) Math.sqrt(Math.pow(x1 - xu, 2) + Math.pow(y1 - yu, 2));
        int d2 = (int) Math.sqrt(Math.pow(x2 - xu, 2) + Math.pow(y2 - yu, 2));
        int d3 = (int) Math.sqrt(Math.pow(x3 - xu, 2) + Math.pow(y3 - yu, 2));
        int[] d = new int[4];
        d[1] = d1;
        d[2] = d2;
        d[3] = d3;

        int min = Integer.MAX_VALUE;
        for (int first = 1; first <= 3; first++) {
            int sum0 = d[first] + move[first][0];
            min = Math.min(min, sum0);
            int sum1 = d[first] + move[first][1];
            min = Math.min(min, sum1);
        }
        System.out.println(min);
    }
}
