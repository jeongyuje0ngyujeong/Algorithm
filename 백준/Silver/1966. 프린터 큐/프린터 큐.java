import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCaseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int docNum = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < docNum; j++) {
                int a = Integer.parseInt(st.nextToken());
                queue.add(new int[]{a, j});
                pq.add(a);
            }

            int cnt = 0;
            while (true) {
                if (!queue.isEmpty() && !pq.isEmpty()) {
                    int[] check = queue.poll();
                    int max = pq.poll();

                    if (max == check[0] && idx == check[1]) {
                        sb.append(++cnt).append("\n");
                        break;

                    } else if (max == check[0]) {
                        cnt++;

                    }
                    else {
                        queue.add(check);
                        pq.add(max);
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
