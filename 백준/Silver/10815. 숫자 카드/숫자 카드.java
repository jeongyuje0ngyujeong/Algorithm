import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cardNum = Integer.parseInt(br.readLine());
        HashMap<Integer, Boolean> cards = new HashMap<>(cardNum);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cardNum; i++) {
            cards.put(Integer.parseInt(st.nextToken()), true);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if (cards.containsKey(Integer.parseInt(st.nextToken()))) {
                sb.append(1).append(" ")  ;
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
