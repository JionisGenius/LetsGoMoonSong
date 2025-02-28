package baekjoon.b2_2292_벌집;
import java.util.Scanner;

public class jioni {
    public static void main(String[] agrs){
        Integer N;  // 주어지는 값
        Integer g; // 지나가는 방 개수
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();


        // 1+3g(g-1)< N <= 1+3(1+g)g
        g=0;
        while ((1+3*g*(g+1) < N)){
            g++;

        }
        System.out.println(g+1);
    }

}
