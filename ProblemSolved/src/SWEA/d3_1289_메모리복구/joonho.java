package SWEA.d3_1289_메모리복구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class joonho {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String line;
        int cnt;
        char ch;
        for (int tc = 1; tc <= T; tc++) { //tc {
            line = br.readLine();
            cnt = 0;
            ch = '0';
            for (int i = 0; i < line.length(); i++) {
                if (ch != line.charAt(i))
                    cnt++;
                ch = line.charAt(i);
            }
            if (sb.length() != 0) {
                sb.append("\n");
            }
            sb.append("#").append(tc).append(" ").append(cnt);
        } // tc }
        System.out.println(sb.toString());
        br.close();
    } // main }

}
