package SWEA.d2_1926_369게임;

import java.util.Scanner;

public class g2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            int temp = i;
            int count = 0;
            while (temp > 0) {
                if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9) {
                    count++; // 369마다 1씩 카운트 // %10 일의자리 나머지
                }
                temp = temp / 10; // 자릿수 0빼기 하면서 각 자릿수 나머지 구하기
            }
            if (count > 0) {
                for (int j = 1; j <= count; j++) {
                    System.out.print("-");
                }
            }else {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}
