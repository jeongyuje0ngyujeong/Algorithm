import java.io.*;

public class Main {
    static int size = 0;
    static int fullSize = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        fullSize = size * 5;

        int depth = 1;
        sb = new StringBuilder();

        while (depth <= fullSize) {
            for (int i = 0; i < size; i++) {
                blank();
                depth++;
            }

            if (depth > fullSize) {
                break;
            }

            for (int i = 0; i < size; i++) {
                full();
                depth++;
            }
        }

        System.out.println(sb);
    }

    private static void blank() {
        int blank =  fullSize - (size * 2);
        sb.append("@".repeat(size));
        sb.append(" ".repeat(blank));
        sb.append("@".repeat(size));
        sb.append("\n");
    }

    private static void full() {
        sb.append("@".repeat(fullSize));
        sb.append("\n");
    }
}
