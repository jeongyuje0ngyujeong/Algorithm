public class Main {
    public static void main(String[] args) {
        int[] memo = new int[10001];

        for (int i = 1; i < 10000; i++) {
            if (i < 10) {
                memo[i * 2] = 1;

            } else if (i < 100) {
                int check = i + (i / 10) + (i % 10);
                if (memo[check] != 0) continue;
                memo[check] = 1;

            } else if (i < 1000) {
                int check = i + (i / 100) + ((i % 100) / 10) + (i % 10);
                if (memo[check] != 0) continue;
                memo[check] = 1;

            } else {
                int check = i + (i / 1000) + ((i % 1000) / 100) + ((i % 100) / 10) + (i % 10);
                if (check > 10000 || memo[check] != 0) continue;
                memo[check] = 1;

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < memo.length; i++) {
            if (memo[i] == 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
