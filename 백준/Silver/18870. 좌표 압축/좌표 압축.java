import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] array = new int[size];
        int[] copyArr = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            copyArr[i] = array[i];
        }

        Arrays.sort(copyArr);
        int cnt = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (hashMap.containsKey(copyArr[i])) continue;
            hashMap.put(copyArr[i], cnt++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(hashMap.get(array[i])).append(" ");
        }

        System.out.println(sb);
    }
}
