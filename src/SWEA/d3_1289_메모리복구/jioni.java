package SWEA.d3_1289_메모리복구;

import java.util.*;

public class jioni {
    public static void main (String[]args){
        Scanner sc =new Scanner(System.in);
        int T = sc.nextInt();
        String S;
        for(int tc=1; tc<=T; tc++){
            S = sc.next();
            int count=0;
            char ch= '0';
            for(int i=0; i<S.length();i++){
                S.charAt(i); //1010 10000
                if(ch!=S.charAt(i)){
                    count++;
                    ch=S.charAt(i);
                }
            }
            System.out.println("#"+tc+" "+count);
        }//tc}
    }//main}
}
