package programmers.lv1_389478_deposit_box;

// https://school.programmers.co.kr/learn/courses/30/lessons/389478
public class joonho {
    public int solution(int n, int w, int num) {
        int topRow = (n - 1) / w + 1; // 제일 위는 몇번째 row 인가
        int top = n % w; // 제일 위에는 몇개의 상자가 있는 가
        if(top == 0) top = w;

        int targetRow = (num - 1) / w + 1;; // 타겟은 몇번째 row 인가
        int target = num % w; // 해당 row에서 몇번째로 작나
        if(target == 0) target = w;

        // System.out.println(top + ", " +topRow);
        // System.out.println(target + ", " + targetRow);

        int answer;
        if(topRow == targetRow) return  1;
        if (topRow % 2 == targetRow % 2) { // 방향 같음
            if (top >= target) {
                answer = topRow - targetRow + 1;
            } else {
                answer = topRow - targetRow;
            }
        } else { // 방향 다름.
            if (top + target <= w) {
                answer = topRow - targetRow;
            } else {
                // top과 target 합이 w 보다 많다면 top 중에 하나가 target 위를 덮음
                // □□□□□
                // □□□□□□□□
                // □□□■□□□□
                answer = topRow - targetRow + 1;
            }
        }
        return answer;
    }
}
