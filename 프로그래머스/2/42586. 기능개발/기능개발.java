import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            if((100 - progresses[i]) % speeds[i] == 0) queue.add((100 - progresses[i]) / speeds[i]);
            else queue.add((100 - progresses[i]) / speeds[i] + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        int a = queue.poll();
        int b = 0;
        int cnt = 1;
        
        while (!queue.isEmpty()) {
            b = 0;
            b = queue.poll();
            
            if (a < b) {
                list.add(cnt);
                cnt = 1;
                a = b;
                
            } else {
                cnt++;
               
            }            
        }
        
        if (b != 0) list.add(cnt);
        
        int[] answer = list.stream()
                       .mapToInt(i -> i)
                       .toArray();
        
        return answer;
    }
}