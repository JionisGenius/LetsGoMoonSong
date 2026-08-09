package SWEA.d2_1859_백만장자프로젝트;
//BufferedReader와 StringTokenizer써보기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            int N=Integer.parseInt(br.readLine());
            int arr[]=new int[N];
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int d=0; d<N; d++){
                arr[d]=Integer.parseInt(st.nextToken());
            }
        }



    }
}
