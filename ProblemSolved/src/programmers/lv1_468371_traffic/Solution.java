package programmers.lv1_468371_traffic;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] signals) {
        int trafficCnt = signals.length;
        int[] round = new int[trafficCnt];
        Queue<Integer>[] queue = new Queue[trafficCnt];
        for (int i = 0; i < trafficCnt; i++) {
            queue[i] = new LinkedList<>();
        }

        long lcm = 1;
        for (int i = 0; i < trafficCnt; i++) {
            round[i] = signals[i][0] + signals[i][1] + signals[i][2];
            for (int g = 0; g < signals[i][0]; g++) {
                queue[i].add(1); // green
            }
            for (int y = 0; y < signals[i][1]; y++) {
                queue[i].add(2); // yellow
            }
            for (int r = 0; r < signals[i][2]; r++) {
                queue[i].add(3); // red
            }
            lcm = findLcm(round[i], lcm);
        }

        int answer = 1;
        while (lcm > 0) {
            boolean allYellow = true;
            for (int i = 0; i < trafficCnt; i++) {
                if (queue[i].peek() != 2) {
                    allYellow = false;
                    break;
                }
            }
            if (allYellow) {
                return answer;
            }
            for (int i = 0; i < trafficCnt; i++) {
                queue[i].add(queue[i].poll());
            }
            lcm--;
            answer++;
        }

        return -1;
    }

    long findGcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    long findLcm(long a, long b) {
        return a * b / findGcd(a, b);
    }
}