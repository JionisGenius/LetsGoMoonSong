package programmers.lv2_388353_crane;

public class joonho {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    char[][] matrix;
    boolean[][] visited;
    int m, n;
    public int solution(String[] storage, String[] requests) {
        m = storage.length;
        n = storage[0].length();
        matrix = new char[m][n];
        visited = new boolean[m][n];

        for(int r = 0 ; r < m ; r ++){
            matrix[r] = storage[r].toCharArray();
        }


        int answer = 0;
        return answer;
    }

    void dfs(int r, int c){
        visited[r][c] = true;

        for(int d = 0 ; d < 4 ; d++){
            int nr = dr[d];
            int nc = dc[d];

            if(nr >= m || nc >= n) continue;
            if(visited[nr][nc]) continue;
            dfs(nr, nc);
        }

    }

    void all(char ch){
        for(int r = 0 ; r < m ; r++){
            for(int c = 0 ; c < n ; c++){
                if(matrix[r][c] == ch) visited[r][c] = true;
            }
        }
    }
}
