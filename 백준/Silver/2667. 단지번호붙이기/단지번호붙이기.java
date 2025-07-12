import java.io.*;
import java.util.*;

public class Main {
    static int mapSize = 0;
    static int[][] map;
    static int totalDanji = 0;
    public static void main(String[] args) throws IOException {
        // map 구성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(br.readLine());
        map = new int[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            String[] mapRow = br.readLine().split("");
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = Integer.parseInt(mapRow[j]);
            }
        }

        // map 탐색
        ArrayList<Integer> houseCnt = new ArrayList<>();
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] != 0) {
                    map[i][j] = 0;
                    houseCnt.add(bfs(i, j));
                    totalDanji++;
                }
            }
        }

        System.out.println(totalDanji);
        Collections.sort(houseCnt);
        for (Integer cnt : houseCnt) {
            System.out.println(cnt);
        }
    }
    private static int bfs(int row, int col){
        //BFS 용 데이터 생성
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 1;
        queue.add(new int[] {row, col});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            int[] dy = {-1, 1, 0, 0};
            int[] dx = {0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int moveRow = curRow + dy[i];
                int moveCol = curCol + dx[i];

                if (mapSize <= moveRow || moveRow < 0 || mapSize <= moveCol || moveCol < 0 || map[moveRow][moveCol] == 0) {
                    continue;
                }

                map[moveRow][moveCol] = 0;
                queue.add(new int[] {moveRow, moveCol});
                cnt++;
            }
        }
        return cnt;
    }
}
