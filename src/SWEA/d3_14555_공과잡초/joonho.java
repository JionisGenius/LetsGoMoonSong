package SWEA.d3_14555_공과잡초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class joonho {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String line;
        for (int tc = 1; tc <= testcase; tc++) {
            line = br.readLine();

            int cnt = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '(' && line.charAt(i + 1) == ')')
                    cnt++;
                else if (line.charAt(i) == '(' && line.charAt(i + 1) == '|')
                    cnt++;
                else if (line.charAt(i) == ')' && line.charAt(i - 1) == '|')
                    cnt++;
            }
            if (sb.length() != 0)
                sb.append("\n");
            sb.append("#" + tc + " " + cnt);
        }
        System.out.println(sb.toString());
        br.close();

    }

}
