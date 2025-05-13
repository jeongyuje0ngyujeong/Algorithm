import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap <String, Integer> nameList = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            nameList.put(participant[i], nameList.getOrDefault(participant[i], 0) + 1);
        }
        
        for (int i = 0; i < completion.length; i++) {
            nameList.put(completion[i], nameList.get(completion[i]) + 1);
        }
        
        String answer = "";
        for (Map.Entry<String, Integer> name: nameList.entrySet()) {
            System.out.println(name.getValue());
            if (name.getValue() % 2 == 1) {
                answer = name.getKey();
                break;
            }
        }
        
        return answer;
    }
}