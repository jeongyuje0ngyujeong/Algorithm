import java.util.*;
import java.io.*;

class Solution {
    private static int answer = 0;
    private static boolean[][] isVisited;
    private static int[][] maps;
    private static int height;
    private static int width;
    
    public int solution(int[][] maps) {
        this.maps = maps;
        height = maps.length;
        width = maps[0].length;
        isVisited = new boolean[height][width];
        
        if (maps[0][0] != 1) return -1;
        
        return bfs(new int[]{0,0,1});
        
    }
    
    private static int bfs(int[] startArr) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(startArr);
        int[] check = new int[3];
        
        while (!queue.isEmpty()) {
            check = queue.poll();
            
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};
            
            if(!isVisited[check[0]][check[1]]) {
                isVisited[check[0]][check[1]] = true;
                if(check[0] == height - 1 && check[1] == width - 1) {
                    return check[2];
                }
                
                for (int i = 0; i < 4; i++) {
                    int checkX = check[1] + dx[i];
                    int checkY = check[0] + dy[i];
                    int count = check[2];
                    if (checkX >= width || checkX < 0 || checkY >= height || checkY < 0) continue;
                    if (maps[checkY][checkX] == 1 && !isVisited[checkY][checkX]) {
                        queue.add(new int[]{checkY, checkX, count+1});
                    }     
                }
            }
        }
        return -1;
    }
}