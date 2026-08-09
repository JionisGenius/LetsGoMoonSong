package programmers.lv1_468370_secretMessage;

import java.util.HashMap;

//school.programmers.co.kr/learn/courses/30/lessons/468370
public class joonho {
    public int solution(String message, int[][] spoiler_ranges) {
        boolean[] spoiled = new boolean[message.length()];
        int srl = spoiler_ranges.length;
        for (int i = 0; i < srl; i++) {
            for (int j = spoiler_ranges[i][0]; j <= spoiler_ranges[i][1]; j++) {
                spoiled[j] = true;
            }
        }

        int ml = message.length();
        HashMap<String, Boolean> map = new HashMap<>();
        for (int i = 0, head = 0; i < ml; i++) {
            if (message.charAt(i) == ' ' || i == ml - 1) {
                StringBuilder sb = new StringBuilder();
                boolean isSpoiled = false;
                for (int h = head; h < i; h++) {
                    sb.append(message.charAt(h));
                    isSpoiled = isSpoiled || spoiled[h];
                }
                if (i == ml - 1) sb.append(message.charAt(i));

                String word = sb.toString();

                if (!isSpoiled) { // 비밀 글자 아님. false로 저장
                    map.put(word, false);
                } else { // 비밀 글자 가능성 있음
                    map.put(word, map.getOrDefault(word, true)); // 이미 있으면 그대로, 없으면 true
                }
                head = i + 1;
            }
        }

        int answer = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == true) {
                answer++;
            }
        }

        return answer;
    }
}