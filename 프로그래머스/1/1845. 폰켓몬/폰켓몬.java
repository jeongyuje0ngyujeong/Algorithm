import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int ponketmonNum = nums.length;
        int checkNum = ponketmonNum / 2;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i = 0; i < ponketmonNum; i++) {
            if (map.containsKey(nums[i])){
                map.replace(nums[i], map.get(nums[i] + 1));
                
            } else {
                map.put(nums[i], 1);
                
            }
        }
        
        if(checkNum >= map.size()) return map.size();
        return checkNum;
    
    }
}