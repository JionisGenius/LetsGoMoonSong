package SWEA.d3_14555_공과잡초;

import java.util.*;

public class jioni {
    public static void main (String[]args){
        Scanner sc =new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            String S = sc.next();
            int count =0;
            for(int i=0; i<S.length(); i++){
                char C= S.charAt(i);
                if(S.charAt(i)=='('){
                    if(S.charAt(i+1)=='|'){
                        count++;
                    }
                }else if (S.charAt(i)==')'){
                    count++;
                }
            }
            System.out.println("#"+tc+" "+count);
        }//tc
    }
}
