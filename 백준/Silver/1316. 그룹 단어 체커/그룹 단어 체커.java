import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < num; i++) {
            String word = br.readLine();
            char check = word.charAt(0);
            ArrayList<Character> list = new ArrayList<>();
            list.add(check);

            for (int j = 1; j < word.length(); j++) {
                if (check != word.charAt(j)) {
                    check = word.charAt(j);
                    list.add(check);
                }
            }

            HashMap<Character, Integer> hash = new HashMap<>(list.size());
            boolean flag = true;
            for (Character character : list) {
                if (hash.containsKey(character)) {
                    flag = false;
                    break;
                }
                hash.put(character, 1);
            }

            if (flag) cnt++;
        }

        System.out.println(cnt);
    }
}
