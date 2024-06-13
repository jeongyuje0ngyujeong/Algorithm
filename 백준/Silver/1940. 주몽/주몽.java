import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int materialNum = Integer.parseInt(br.readLine());
        int armor = Integer.parseInt(br.readLine());

        int[] material = new int[materialNum];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < materialNum; i++) {
            material[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(material);
        int cnt = 0;
        int start = 0;
        int end = materialNum- 1;

        while(start < end) {
            if (material[start] + material[end] < armor) {
                start++;

            } else if (material[start] + material[end] > armor) {
                end--;

            } else {
                cnt++;
                start++;
                end--;
            }
        }

        System.out.println(cnt);
    }
}
