import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] isVisited;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int width = Integer.parseInt(info[0]);
        int height = Integer.parseInt(info[1]);
        
        map = new int[height][width];
        isVisited = new boolean[height][width];
        
        for (int i = 0; i < height; i++) {
            String[] stringNum = br.readLine().split(" ");
            for (int j = 0; j < width; j++) {
                int num = Integer.parseInt(stringNum[j]);
                map[i][j] = num;
            }
        }
        if (width == height && width == 1) {
            System.out.println("Yes");
            return;
        }
        bfs(0,0);
        if (isVisited[height - 1][width - 1]) {
            System.out.print("Yes");
            return;
        }
        System.out.print("No");
    }
    public static void bfs (int startR, int startC) {
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        isVisited[startR][startC] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 2; i++) {
                int curCol = cur[1] + dx[i];
                int curRow = cur[0] + dy[i];
                if (curCol < 0 || curCol >= map[0].length || curRow < 0 || curRow >= map.length || map[curRow][curCol] == 0) continue;
                if (!isVisited[curRow][curCol]) {
                    isVisited[curRow][curCol] = true;
                    queue.add(new int[]{curRow, curCol});
                }
            }
        }
    }
}