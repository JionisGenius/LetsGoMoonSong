package baekjoon.b5_27433_팩토리얼2;

import java.util.*;

public class jioni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        func(N);
    }
    public static int func(int num){

        if(num <= 0){
            return 1;
        }
        else {
            return num * func(num-1);
        }
    }
}

/// 재귀함수
// base case  : 재귀 빠져나가기 위한 조건
// recursive case : 자신을 호출하는 부분
// 함수호출은 메모리 구조에서 스택을 사용
// 자기자신을 계속 호출하다보면 메모리초과 즉 스택오버플로우 발생할수있음
// 재귀의 꽃 '분기'
//