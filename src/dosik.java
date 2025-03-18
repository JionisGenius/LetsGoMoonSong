import java.util.Scanner;

public class dosik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String line = sc.next();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if(ch >='a')
                sb.append(ch - 'a' + 1).append(",");
            else if(ch >='A')
                sb.append(ch- 'A'+1).append(",");
        }
        sc.close();
        System.out.println(sb);
    }
}
