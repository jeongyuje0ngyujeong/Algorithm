import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] testSite = new int[Integer.parseInt(br.readLine())];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testSite.length; i++) {
            testSite[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int chief = Integer.parseInt(st.nextToken());
        int supervisor = Integer.parseInt(st.nextToken());
        long count = 0;

        for (int i = 0; i < testSite.length; i++) {
            int people = testSite[i];
            people -= chief;
            count++;
            if (people <= 0) continue;
            if (people % supervisor != 0) count += ((people / supervisor) + 1);
            else count += (people / supervisor);
        }
        System.out.println(count);
    }
}
