import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[] isVisited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int searchStart = Integer.parseInt(st.nextToken());

        map = new int[nodes + 1][nodes + 1];
        isVisited = new boolean[nodes + 1];
        isVisited[0] = true;

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start][end] = map[end][start] = 1;
        }

        dfs(searchStart);
        sb.append("\n");
        bfs(searchStart);
        
        System.out.println(sb);
    }

    private static void dfs(int searchStartNum) {
        if (!isVisited[searchStartNum]) {
            sb.append(searchStartNum).append(" ");
            isVisited[searchStartNum] = true;
            for (int i = 1; i < map.length; i++) {
                if (map[searchStartNum][i] == 1 && !isVisited[i]) dfs(i);
            }
        }
    }

    private static void bfs(int searStartNum) {
        Queue<Integer> bucket = new LinkedList<>();
        isVisited = new boolean[map.length];
        isVisited[0] = true;

        bucket.add(searStartNum);
        while (!bucket.isEmpty()) {
            int check = bucket.poll();
            sb.append(check).append(" ");
            isVisited[check] = true;

            for (int i = 1; i < map[check].length; i++) {
                if (map[check][i] == 1 && !isVisited[i]) {
                    isVisited[i] = true;
                    bucket.add(i);
                }
            }
        }
    }
}
