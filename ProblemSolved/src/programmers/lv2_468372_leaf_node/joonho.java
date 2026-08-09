package programmers.lv2_468372_leaf_node;

// https://school.programmers.co.kr/learn/courses/30/lessons/468372
// 시간 초과
public class joonho {

    public int solution(int dist_limit, int split_limit) {
        int answer = 0;

        // a: 2개 자식을 갖는 분배 노드 갯수
        // b: 3개 자식을 갖는 분배 노드 갯수
        for (int a = 0; a <= dist_limit; a++) {
            for (int b = 0; b <= dist_limit; b++) {
                if(a + b > dist_limit) break;
                // a는 한층 증가하면 기존 마지막 층의 2배만큼 그 층에 넣을 수 있다.
                // b는 한층 증가하면 기존 마지막 층의 3배만큼 그 층에 넣을 수 있다.
                int i = stepCalc(a, 2, 1);
                int aLast = lastStepCalc(a, 2, 1);
                int j = stepCalc(b, 3, aLast);
                if (Math.pow(2, i) * Math.pow(3, j) > split_limit) continue;
                answer = Math.max(answer, 1 + a + 2 * b);
            }
        }

        return answer;
    }

    int stepCalc(int ab, int multipleNum, int able) {
        int step = 0;
        while (ab > 0) {
            ab = ab - able;
            able *= multipleNum;
            step++;
        }
        return step;
    }

    int lastStepCalc(int ab, int multipleNum, int able) {
        int last = 0;
        while (ab > 0) {
            if (ab <= able) last = ab;
            ab = ab - able;
            able *= multipleNum;
        }
        if (last == 0) return 1;
        return last * multipleNum;
    }

}