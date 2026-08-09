package programmers.lv1_완주하지못한선수;

import java.util.HashMap;
import java.util.Map;

public class jioni {
        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> map = new HashMap<>();

            //저장
            for (String p : participant ){ // 참여자 명단
                if(map.get(p)==null){
                    map.put(p,1);
                }else{
                    map.put(p,map.get(p)+1);// nullpointexception발생
                }
            }

            //완주자 제거
            for (String c :completion){
                map.put(c, map.get(c)-1);
            }

            //value 1인거 찾아내기
            for(String key : map.keySet()) { // key만 있는 배열
                //set : 값만 저장 중복안됨 (key뭉쳐진 느낌)
                //key : 중복안됨
                if (map.get(key) != 0) { //완주 못한 이름
                    return key;
                }
            }

            return "ㅎㅎ";
        }
    }
/*

        //키,벨류(중복된다)
        //이름,개수

        //참여자 - 완료자 = 1 범인

        //사전작업 -> 이름별 몇개가있는지
        //참여자저장

문제 설명
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.
입출력 예
                participant	            completion                                                  	return
        ["leo", "kiki", "eden"]	["eden", "kiki"]	                                                    "leo"
        ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
        ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]                         	"mislav"
입출력 예 설명
예제 #1
        "leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

        예제 #2
        "vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

        예제 #3
        "mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.*/

