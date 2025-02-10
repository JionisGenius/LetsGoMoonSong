package baekjoon.b1_2309_일곱난쟁이;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class joonho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] gnomes = new int[9];
        for (int i = 0; i < 9; i++) {
            gnomes[i] = sc.nextInt();
        }
        sc.close();

        int real[] = new int[9];
        find : for (int i = 0; i <= 1; i++) {
            real[0] = i;
            for (int ii = 0; ii <= 1; ii++) {
                real[1] = ii;
                for (int iii = 0; iii <= 1; iii++) {
                    real[2] = iii;
                    for (int iv = 0; iv <= 1; iv++) {
                        real[3] = iv;
                        for (int v = 0; v <= 1; v++) {
                            real[4] = v;
                            for (int vi = 0; vi <= 1; vi++) {
                                real[5] = vi;
                                for (int vii = 0; vii <= 1; vii++) {
                                    real[6] = vii;
                                    for (int viii = 0; viii <= 1; viii++) {
                                        real[7] = viii;
                                        for (int ix = 0; ix <= 1; ix++) {
                                            real[8] = ix;
                                            // 인원 수, 키의 합 구하기
                                            int cnt = 0;
                                            int heightSum = 0;
                                            for (int j = 0; j < 9; j++) {
                                                cnt += real[j];
                                                if (real[j] == 1)
                                                    heightSum += gnomes[j];
                                            }
                                            // 조건 달성 시 탈출
                                            if (cnt == 7 && heightSum == 100)
                                                break find;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int[] answer = new int[7];
        int in = 0;
        int num = 0;
        while (in < 7) {
            if (real[num] == 1) {
                answer[in] = gnomes[num];
                in++;
            }
            num++;
        }
        Arrays.sort(answer);
        for (int elem : answer) {
            System.out.println(elem);
        }
    }//main }
}
