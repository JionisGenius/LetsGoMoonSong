package programmers.lv2_hash_전화번호목록;

import java.lang.reflect.Array;
import java.util.*;

public class jioni {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                return false;
            }
        }
        return answer;
    }
}

// 길이순으로 정렬
// 맨앞요소 비교 ( 여기서 길이가 더 긴 요소만 비교한다)
// 순차적으로 for

// 사전순정렬 123 1234

// 앞뒤 하나씩만 비교해서 for문 작성하기
// String 내장함수
// startsWith : 시작하는
// substring : 자르기
// contains : 포함
// append

// 1 10 11 12 13
// 1 10 100 101 , 2 20

// 123 222 2224

// 전화번호부에 있는 모
// 기준이 되는 접두사와 그 다음 전화번호랑 비교한다
// 접두사면 false
// 접두사 아니면 true

/*
전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

제한 사항
phone_book의 길이는 1 이상 1,000,000 이하입니다.
각 전화번호의 길이는 1 이상 20 이하입니다.
같은 전화번호가 중복해서 들어있지 않습니다.
입출력 예제
phone_book	return
["119", "97674223", "1195524421"]	false
["123","456","789"]	true
["12","123","1235","567","88"]	false
입출력 예 설명
입출력 예 #1
앞에서 설명한 예와 같습니다.

입출력 예 #2
한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.

입출력 예 #3
첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.

 */
