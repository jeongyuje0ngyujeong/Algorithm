import java.io.*;
import java.util.*;

public class Main {
    private static int brother;
    private static Integer[] isVisited = new Integer[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());
        if (subin == brother) System.out.println(0);
        else {
            isVisited[subin] = 0;
            bfs(subin);
        }
    }

    private static void bfs(int location) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(location);

        while (!queue.isEmpty()) {
            int curLocation = queue.poll();
            int[] dx = {curLocation, -1, 1};

            for (int i = 0; i < 3; i++) {
                int move = curLocation + dx[i];
                if (move == brother) {
                    System.out.println(isVisited[curLocation] + 1);
                    return;
                }

                if (move < 0 || move >= isVisited.length) continue;
                if (isVisited[move] != null) continue;
                queue.add(move);
                isVisited[move] = isVisited[curLocation] + 1;

            }
        }
    }
}
