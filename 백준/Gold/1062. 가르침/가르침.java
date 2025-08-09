import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static String[] words;
    static boolean[] learned = new boolean[26];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }
        if (K == 26) {
            System.out.println(N);
            return;
        }

        words = new String[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            String filtered = s.replaceAll("[antic]", "");
            words[i] = filtered;
        }

        for (char c : new char[]{'a','n','t','i','c'}) {
            learned[c - 'a'] = true;
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int idx, int cnt) {
        if (cnt == K - 5) {
            int readCnt = 0;
            for (String word : words) {
                boolean canRead = true;
                for (int j = 0; j < word.length(); j++) {
                    char ch = word.charAt(j);
                    if (!learned[ch - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) readCnt++;
            }
            answer = Math.max(answer, readCnt);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true;
                dfs(i + 1, cnt + 1);
                learned[i] = false;
            }
        }
    }
}
