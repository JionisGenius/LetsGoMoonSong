package programmers.lv2_468379_hide_catus;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    public int[] solution(int m, int n, int h, int w, int[][] drops) {

        // 비 오는 위치 저장
        int noRain = drops.length + 1;
        int[][] rainTime = new int[m][n];

        for (int r = 0; r < m; r++) {
            Arrays.fill(rainTime[r], noRain);
        }

        for (int t = 0; t < drops.length; t++) {
            int r = drops[t][0];
            int c = drops[t][1];

            rainTime[r][c] = t + 1;
        }

        // 행 줄이기
        int possibleCols = n - w + 1;
        int[][] horizontalMin = new int[m][possibleCols];

        for (int r = 0; r < m; r++) {
            // deque 에는 열 번호 저장
            Deque<Integer> deque = new ArrayDeque<>();

            for (int c = 0; c < n; c++) {
                // 현재 가로 범위에서 벗어난 열 제거
                while (!deque.isEmpty() && deque.peekFirst() <= c - w) {
                    deque.pollFirst();
                }
                // 현재 값보다 크거나 같은 값 제거
                while (!deque.isEmpty() && rainTime[r][deque.peekLast()] >= rainTime[r][c]) {
                    deque.pollLast();
                }
                // 현재 열 번호를 deque 뒤에 추가
                deque.offerLast(c);

                if (c >= w - 1) {
                    int startCol = c - w + 1;
                    horizontalMin[r][startCol] = rainTime[r][deque.peekFirst()];
                }
            }
        }

        int bestTime = -1;
        int answerR = 0;
        int answerC = 0;

        // 열 줄이기
        for (int c = 0; c < possibleCols; c++) {
            // deque에는 행 번호를 저장한다.
            Deque<Integer> deque = new ArrayDeque<>();

            for (int r = 0; r < m; r++) {

                while (!deque.isEmpty() && deque.peekFirst() <= r - h) {
                    deque.pollFirst();
                }

                while (!deque.isEmpty() && horizontalMin[deque.peekLast()][c] >= horizontalMin[r][c]) {
                    deque.pollLast();
                }

                deque.offerLast(r);

                if (r >= h - 1) {
                    int startRow = r - h + 1;
                    int firstDrop = horizontalMin[deque.peekFirst()][c];

                    // 비가 가장 늦게 오는 곳 찾기
                    if (firstDrop > bestTime || (firstDrop == bestTime && (startRow < answerR || (startRow == answerR && c < answerC)))
                    ) {
                        bestTime = firstDrop;
                        answerR = startRow;
                        answerC = c;
                    }
                }
            }
        }

        return new int[]{answerR, answerC};
    }
}
