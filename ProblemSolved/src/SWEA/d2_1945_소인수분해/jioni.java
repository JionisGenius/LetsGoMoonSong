package SWEA.d2_1945_소인수분해;

import java.util.ArrayList;
import java.util.Scanner;

public class jioni {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    for(int tc=1; tc<=N; tc++){
        int T = sc.nextInt();

        int arr[]= {2,3,5,7,11};
        int answer[]= new int[5];

        for(int i=0; i<5; i++){
            while (T%arr[i]==0){
                T=T/arr[i];
                answer[i]++;
            }
        }
        StringBuilder sb =new StringBuilder();
        sb.append("#");
        sb.append(tc);
        for(int i=0;i<5;i++){
            sb.append(" ");
            sb.append(answer[i]);
        }
        System.out.println(sb.toString());
    }
    }
}

