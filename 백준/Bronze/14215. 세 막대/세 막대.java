import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        Arrays.sort(num);

        if (num[0] + num[1] <= num[2]) System.out.println(num[0] * 2 + num[1] * 2 - 1);
        else System.out.println(num[0] + num[1] + num[2]);


    }
}
