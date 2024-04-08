import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int questionNum = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < questionNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] deadlineSet = new int[2];
            deadlineSet[0] = Integer.parseInt(st.nextToken());
            deadlineSet[1] = Integer.parseInt(st.nextToken());
            list.add(deadlineSet);
        }

        list.sort(((o1, o2) -> o2[0] - o1[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int checkIdx = 0;

        int sum = 0;
        for (int i = list.get(checkIdx)[0]; i > 0; i--) {
            while (checkIdx < list.size() && list.get(checkIdx)[0] == i) {
                pq.add(list.get(checkIdx++)[1]);
            }

            if (!pq.isEmpty()) sum += pq.poll();
        }

        System.out.println(sum);

    }
}
