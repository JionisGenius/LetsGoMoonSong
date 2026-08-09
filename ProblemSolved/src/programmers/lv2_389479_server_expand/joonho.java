package programmers.lv2_389479_server_expand;

//https://school.programmers.co.kr/learn/courses/30/lessons/389479
public class joonho {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int [] server = new int [24];
        int curSum = 0;
        for(int t = 0 ; t < 24 ; t++){
            int need = players[t] / m;
            int head = t - k + 1;
            if(head - 1 >= 0) {
                // System.out.println("현재 시간"+t+", head"+head);
                curSum -= server[head - 1];
            }
            if(need > curSum){
                server[t] = need - curSum;
                curSum += server[t];
                answer += server[t];
                // System.out.println("현재 시간"+t + ", 추가된 서버 수" + server[t]);
            }
        }

        return answer;
    }
}
