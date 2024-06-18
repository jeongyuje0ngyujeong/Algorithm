import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] graph;
    private static boolean[] isVisited;
    private static int node = 0;
    private static int cnt = 1;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[node + 1];
        answer = new int[node + 1];
        isVisited = new boolean[node + 1];
        for (int i = 0; i < node + 1; i++) {
            graph[i] = new ArrayList<>();

        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int check1 = Integer.parseInt(st.nextToken());
            int check2 = Integer.parseInt(st.nextToken());

            graph[check1].add(check2);
            graph[check2].add(check1);
        }

        dfs(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= node; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int start) {
        if (isVisited[start]) {
            return;
        }

        isVisited[start] = true;
        answer[start] = cnt++;
        Collections.sort(graph[start], Collections.reverseOrder());

        for (int i = 0; i < graph[start].size(); i++) {
            if (!isVisited[graph[start].get(i)]) {
                dfs(graph[start].get(i));
            }
        }
    }
}
