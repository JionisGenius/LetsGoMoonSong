package baekjoon.s5_2839_설탕배달;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class joonho {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int N = Integer.parseInt(br.readLine());

            if (N == 4 || N == 7) {
                System.out.println(-1);
            } else {
                if (N % 5 == 0) { // 전부 5키로 봉지로
                    System.out.println(N / 5);
                } else if (N % 5 == 1) { // 5키로 1 봉지 빼고 3키로 2봉지
                    System.out.println(N / 5 + 1);
                } else if (N % 5 == 2) { // 5키로 2 봉지 빼고 3키로 4봉지
                    System.out.println(N / 5 + 2);
                } else if (N % 5 == 3) { // 남는거 3키로 1 봉지
                    System.out.println(N / 5 + 1);
                } else if (N % 5 == 4) { // 5키로 1봉지 빼고 3키로 3봉지
                    System.out.println(N / 5 + 2);
                }
            }

        } catch (Exception e) {

        }
    }
}
