package baekjoon.s4_2485_가로수;

import java.util.Scanner;

public class joonho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int [N];
        int [] dist = new int[N];
        int max = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
            if(i != 0){
                dist[i] = arr[i] - arr[i-1];
                max = Math.min(max, dist[i]);
            }
        }
        int d = max;
        while(d!= 1){
            boolean flag = false;
            for(int i = 1 ; i < N ; i++){
                if(dist[i] % d != 0){
                    flag = true;
                    break;
                }
            }
            if(flag){
                d--;
            } else {
                break;
            }
        }
        // System.out.println("d :"+d);

        int sum = (arr[N-1] - arr[0]) / d + 1 - N;

        System.out.println(sum);
    }
}
