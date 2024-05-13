import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        //HashMap으로 묶기
        HashMap<String, Integer> dataExtIdx = new HashMap<>();
        dataExtIdx.put("code", 0);
        dataExtIdx.put("date", 1);
        dataExtIdx.put("maximum", 2);
        dataExtIdx.put("remain", 3);
        
        //필터링된 배열 저장할 리스트 생성
        List<int[]> filteredData = new ArrayList<>();
        
        //val_ext보다 작은 값 찾아 리스트에 저장
        for(int[]d : data) {
            if (d[dataExtIdx.get(ext)] < val_ext) {
                filteredData.add(d);
            }
        }
        
        //리스트 sort_by 기준으로 오름차순 정렬
        filteredData.sort(Comparator.comparingInt(arr -> arr[dataExtIdx.get(sort_by)]));
        
        int[][] answer = filteredData.toArray(new int[0][]);
        return answer;
    }
}