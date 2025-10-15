package baekjoon.b1_1032_명령프롬프트;

import java.util.Scanner;

public class jioni {
    public static void main (String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//
//        String[] st = new String[N];
//        for(int i=0; i<N; i++){
//            st[i]=sc.nextLine();
//        }
//        // 배열 문자열을 문자로 쪼개기
//        // 쪼갠거끼리 비교하기
//        // 비교하면 다음열로 넘어가기 sc.length까지 비교
//        // 같으면 문자출력 다르면 ?출력
        Scanner sc = new Scanner(System.in); // 입력받기
        int N = sc.nextInt();               // 숫자 받기
        sc.nextLine();                      // 한줄 받기

        String[] files = new String[N];     // 배열선언
        for (int i = 0; i < N; i++) {       // 받은숫자만큼 반복
            files[i] = sc.nextLine();       // 배열에 한줄 저장
        }

        int len = files[0].length();
        StringBuilder pattern = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char c = files[0].charAt(i);
            boolean same = true;
            for (String file : files) {
                if (file.charAt(i) != c) {
                    same = false;
                    break;
                }
            }
            pattern.append(same ? c : '?');
        }
    }
}
