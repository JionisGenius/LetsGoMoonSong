package programmers.hide_catus;

// timeout
public class joonho {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] matrix = new int[m][n];
        int time = drops.length;
        int noRain = time + 1;
        for(int r = 0 ; r < m ; r++){
            for(int c = 0 ; c < n ; c++){
                matrix[r][c] = noRain;
            }
        }

        for(int t = 0 ; t < time ; t++){
            int r = drops[t][0];
            int c = drops[t][1];
            matrix[r][c] = t + 1;
        }

        int ansR = 0;
        int ansC = 0;
        int lastFirstDrop = -1;

        find:for(int mr = 0 ; mr < m ; mr++){
            for(int mc = 0 ; mc < n ; mc++){
                if(mr + h > m || mc + w > n) continue;
                int firstDrop = noRain;
                for(int cr = mr; cr < mr + h ; cr++){
                    for(int cc = mc; cc < mc + w; cc++){
                        if(firstDrop > matrix[cr][cc]){
                            firstDrop = matrix[cr][cc];
                        }
                    }
                }
                if(firstDrop > lastFirstDrop){
                    ansR = mr;
                    ansC = mc;
                    lastFirstDrop = firstDrop;
                }
                if(firstDrop == noRain) break find;
            }
        }

        int[] answer = {ansR, ansC};
        return answer;
    }
}
