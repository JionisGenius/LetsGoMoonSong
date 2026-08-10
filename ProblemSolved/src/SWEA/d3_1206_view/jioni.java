package SWEA.d3_1206_view;

import java.util.Scanner;

public class jioni {
    public static void main(String[] args) {
        // 이중배열 문제로 순회하면서 -2 부터 +2까지 범위를 정해
        // 인덱스 기준점이 첫번째 높이일때
        // 첫번째 높이와 두번째 높이를 뺀다
        // 2중 for문으로 시간복잡도 O(n^2)
        Scanner sc= new Scanner(System.in);
        int T =10;
        for (int tc=1; tc<=T; tc++){
            int N =sc.nextInt();
            int [] arr = new int[N];
            for (int add=0; add<N; add++){
                arr[add]= sc.nextInt();
            }
            // 기준 인덱스와 첫번째 높이 두번째 높이
            int view=0;
            for (int i=0; i<N;i++){
                int first=0;
                int second=0;
                int firstidx=0;
                for (int j=i-2;j<=i+2;j++){
                    if (j<0 || j>=N){
                        continue;
                    } else if (first<arr[j]) {
                        second=first;
                        first=arr[j];
                        firstidx=j;
                    } else if (second<arr[j]) {
                        second=arr[j];
                    }
                }if (firstidx==i){
                    view+=first-second;
                }
            }
            System.out.println("#"+tc+" "+view);
        }
    }
}
