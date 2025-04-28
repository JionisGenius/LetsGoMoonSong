package baekjoon.s4_2164_카드2;

import java.util.*;

public class jioni {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int N= sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            q.add(i);
        }
        while (q.size()>1){
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.poll());
    }
}

//Integer : 객체
//int : 자료형
// 자바에서 자료형으로 auto boxing , auto unboxing 해줘서 헷갈린거다
// 그래서 null값이 가능한것
// int null안됨

// 객체는 해시값(주소값)을 가지고있다
// 큐는 추상클래스라서 링크드리스트로 만들어줘야한다

//q.peek() // 맨앞에 있는거 뭔지본다 // 비어있으면 null // 알고리즘에서는 try catch안하고 // size체크 1보다 크거나같으면peek
//q.poll() // 뭔지 꺼내서 본다 // 아얘뺀다
//스택 : 프링글스 // filo
//큐 : 줄 // fifo lilo

//remove
// 객체면 큐에 찾아서 삭제 : string q.remove('송') list 가나ㅏ다송지원 > 가나다지원
// 숫자면 인덱스 번호 : int  q.remove (3) list 12345 > 1235
// Integer 1 > 1을 찾아서 삭제