class Solution {
    private static int cnt = 0;
    private static int sum = 0;
    private static int[] numbers;
    private static int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
            
        return cnt;
    }
    
    private static void dfs(int sum, int depth) {
        if(numbers.length == depth) {
            if (sum == target) cnt++;
            return;
        }
        
        dfs(sum + numbers[depth], depth + 1);
        dfs(sum - numbers[depth], depth + 1);
    }
}