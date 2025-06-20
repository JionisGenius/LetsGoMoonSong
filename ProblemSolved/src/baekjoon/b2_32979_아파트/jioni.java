package baekjoon.b2_32979_아파트;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class jioni {
    public static void main (String[] args){


        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int T = sc.nextInt();

        Queue<Integer> q =new LinkedList<>();
        for(int i = 0 ; i < 2*N;i++){
            q.add(sc.nextInt());
        }

        for (int i=0 ; i<T; i++){
            int B = sc.nextInt();
            for(int j=0; j<B-1; j++){
                q.add(q.poll());
            }
            System.out.println(q.peek());

        }
    }
}

/// 32979번

/*아파트게임
 */


