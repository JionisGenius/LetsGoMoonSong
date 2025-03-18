import java.util.Scanner;

public class Dosik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String line = sc.next();

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            // 숫자는 그대로 append
            if (ch >= '0' && ch <= '9') {
                sb.append(ch).append(",");
            }
            // 알파벳 변환 (A-Z, a-z)
            else if (ch >= 'a' && ch <= 'z') {
                sb.append(ch - 'a' + 1).append(",");
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append(ch - 'A' + 1).append(",");
            }
            // 한글 초성 변환 (ㄱ~ㅎ, 겹받침 제외)
            else {
                switch (ch) {
                    case 'ㄱ': sb.append(1); break;
                    case 'ㄴ': sb.append(2); break;
                    case 'ㄷ': sb.append(3); break;
                    case 'ㄹ': sb.append(4); break;
                    case 'ㅁ': sb.append(5); break;
                    case 'ㅂ': sb.append(6); break;
                    case 'ㅅ': sb.append(7); break;
                    case 'ㅇ': sb.append(8); break;
                    case 'ㅈ': sb.append(9); break;
                    case 'ㅊ': sb.append(10); break;
                    case 'ㅋ': sb.append(11); break;
                    case 'ㅌ': sb.append(12); break;
                    case 'ㅍ': sb.append(13); break;
                    case 'ㅎ': sb.append(14); break;

                    // 한글 중성 변환 (ㅏ~ㅣ)
                    case 'ㅏ': sb.append(1); break;
                    case 'ㅑ': sb.append(2); break;
                    case 'ㅓ': sb.append(3); break;
                    case 'ㅕ': sb.append(4); break;
                    case 'ㅗ': sb.append(5); break;
                    case 'ㅛ': sb.append(6); break;
                    case 'ㅜ': sb.append(7); break;
                    case 'ㅠ': sb.append(8); break;
                    case 'ㅡ': sb.append(9); break;
                    case 'ㅣ': sb.append(10); break;

                    default: continue; // 처리할 문자가 아니면 건너뜀
                }
                sb.append(",");
            }
        }

        sc.close();

        // 마지막에 붙은 "," 제거
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        System.out.println(sb);
    }
}
