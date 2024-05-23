import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;
        int i = 0;

        while (i < str.length()) {
            if (i + 2 <= str.length() && (str.substring(i, i + 2).equals("c=") || str.substring(i, i + 2).equals("c-") || str.substring(i, i + 2).equals("d-") || str.substring(i, i + 2).equals("s=") || str.substring(i, i + 2).equals("z="))) {
                i += 2; 
            } else if (i + 3 <= str.length() && str.substring(i, i + 3).equals("dz=")) {
                i += 3; 
            } else if (i + 2 <= str.length() && (str.substring(i, i + 2).equals("lj") || str.substring(i, i + 2).equals("nj"))) {
                i += 2;
            } else {
                i += 1; 
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
