import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gasStationCnt = Integer.parseInt(br.readLine());
        List<int[]> gasStInfo = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < gasStationCnt; i++) {
            int[] gasInfo = new int[2];
            st = new StringTokenizer(br.readLine());
            gasInfo[0] = Integer.parseInt(st.nextToken());
            gasInfo[1] = Integer.parseInt(st.nextToken());
            gasStInfo.add(gasInfo);
        }

        gasStInfo.sort((Comparator.comparingInt(o -> o[0])));

        PriorityQueue<Integer> pq = new PriorityQueue<> (Collections.reverseOrder());
        int count = 0;
        int idx = 0;

        st = new StringTokenizer(br.readLine());
        int townDistance = Integer.parseInt(st.nextToken());
        int currentFuel = Integer.parseInt(st.nextToken());

        if (townDistance <= currentFuel) {
            System.out.println(0);
            return;
        }

        while (townDistance > currentFuel) {
            while (idx < gasStInfo.size() && gasStInfo.get(idx)[0] <= currentFuel) {
                pq.add(gasStInfo.get(idx++)[1]);
            }

            if (!pq.isEmpty()) {
                currentFuel += pq.poll();
                count++;

            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count);
    }
}

