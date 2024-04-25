import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i - 1) != num.charAt(i)) {
                if (num.charAt(i - 1) == '0') {
                    zeroCnt++;

                } else {
                    oneCnt++;

                }
            }
        }
        
        if (num.charAt(num.length() - 1) == '0') {
            zeroCnt++;

        } else {
            oneCnt++;

        }

        if (zeroCnt < oneCnt) {
            System.out.println(zeroCnt);

        } else {
            System.out.println(oneCnt);

        }

    }
}
