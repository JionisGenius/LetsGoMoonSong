package baekjoon.b2_1371_가장많은글자;
import java.util.*;

public class jioni {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] english = new int[26]; // 알파벳이 머무는 배열. 각각 몇개씩 들어있는 지 셀꺼야
        while(sc.hasNextLine()){ // 다음줄이 있다면
            String line = sc.nextLine().replace(" ",""); // 다음줄을 받을꺼야
            for(int i=0; i<line.length(); i++){ // 받은줄을 한글자씩 읽을거야
                int index = line.charAt(i)-'a'; //읽은것을 숫자로 바꿀거야
                english[index]++; // [0] = a . 해당 숙소에 알파벳 한 명 추가요!

                // english => count
                // line => 글자
            }
        }
        int max =0;
        for(int j=0; j<26;j++){
            max= english[j] > max ? english[j] : max;
        }
        String str="";
        for(int i=0; i<26;i++){
            if(english[i]==max){
                str+= (char)( i + 'a');
            }
        }
        System.out.println(str);
    }
}
