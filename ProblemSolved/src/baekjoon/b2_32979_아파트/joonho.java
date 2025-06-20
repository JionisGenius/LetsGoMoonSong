package baekjoon.b2_32979_아파트;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class joonho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int person = sc.nextInt();
        int tc = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int t = 0 ; t < 2 * person ; t++){
            queue.add(sc.nextInt());
        }
        StringBuilder sb = new StringBuilder();
        for(int t = 0 ; t < tc ; t++){
            int lose = sc.nextInt();
            for(int i = 0 ; i < lose - 1 ; i++){
                queue.add(queue.poll());
            }
            int loser = queue.peek();
            sb.append(loser).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
