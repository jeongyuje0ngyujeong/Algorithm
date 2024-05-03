import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        if (num < 100) {
            System.out.println(num);

        } else if (num == 1000) {
            System.out.println(144);

        } else {
            int cnt = 0;
            for (int i = 100; i <= num; i++) {
                int a = i / 100;
                int b = (i / 10) % 10;
                int c = i % 10;
                int d1 = b - a;
                int d2 = c - b;
                if (d1 == d2) cnt++;
            }
            System.out.println(99 + cnt);
        }
    }
}
