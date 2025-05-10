import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] graphInfo = br.readLine().split(" ");
        int vertex = Integer.parseInt(graphInfo[0]);
        int edge = Integer.parseInt(graphInfo[1]);
        int startVertex = Integer.parseInt(graphInfo[2]);
        isVisited = new boolean[vertex + 1];

        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= vertex; i++) {
            Collections.sort(graph.get(i));
        }
        dfs(startVertex);
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);

        Arrays.fill(isVisited, false);
        sb.setLength(0);
        bfs(startVertex);
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }

    public static void dfs(int cur) {
        if (isVisited[cur]) return;

        isVisited[cur] = true;
        sb.append(cur).append(" ");
        for (int i = 0; i < graph.get(cur).size(); i++) {
            dfs(graph.get(cur).get(i));
        }
        return;
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int check = graph.get(cur).get(i);
                if (!isVisited[check]) {
                    isVisited[check] = true;
                    queue.add(check);
                }
            }
        }
    }
}
