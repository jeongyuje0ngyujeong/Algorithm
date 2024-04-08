import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int jewelryNum = Integer.parseInt(st.nextToken());
        int bagNum = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < jewelryNum; i++) {
            st = new StringTokenizer(br.readLine());
            int[] input = new int[2];
            input[0] = Integer.parseInt(st.nextToken());
            input[1] = Integer.parseInt(st.nextToken());
            list.add(input);
        }

        list.sort((Comparator.comparingInt(o -> o[0])));

        int[] bag = new int[bagNum];
        for (int i = 0; i < bagNum; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long price = 0;
        int checkIdx = 0;
        for (int i = 0; i < bagNum; i++) {
            while (checkIdx < list.size() && bag[i] >= list.get(checkIdx)[0]) {
                pq.add(list.get(checkIdx++)[1]);
            }
            
            if (!pq.isEmpty()) {
                price += pq.poll(); 
            }
        }
        System.out.println(price);
    }
}
