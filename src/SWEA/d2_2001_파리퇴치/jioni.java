package SWEA.d2_2001_파리퇴치;

import java.util.*;

public class jioni {
    public static void main (String[] agrs){
        Scanner sc =new Scanner(System.in);
        int tc = sc.nextInt();
        int N;
        int M;

        for(int i=1; i<=tc; i++){
            N=sc.nextInt();
            M=sc.nextInt();
            int[][] arr =new int[N][N];
            for(int row=0; row<N; row++){
                for(int col=0; col<N; col++){
                    arr[row][col]= sc.nextInt();
                }
            }

            int largest=0;
            for(int nrow=0; nrow<N; nrow++){
                for(int ncol=0; ncol<N; ncol++){
                    int sum=0;
                    if(nrow+M-1<N && ncol+M-1<N){
                        for(int mrow=0; mrow<M; mrow++){
                            for(int mcol=0; mcol<M; mcol++){
                                sum+= arr[mrow+nrow][mcol+ncol];
                                if(sum > largest){
                                    largest=sum;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("#"+i+" "+largest);
        }
    }
}