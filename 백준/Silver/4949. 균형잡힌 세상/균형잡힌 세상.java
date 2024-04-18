import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();

        while (true) {
            str = br.readLine();
            boolean flag = true;
            if (str.equals(".")) break;


            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                    stack.add(str.charAt(i));

                } else if (str.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        sb.append("no").append("\n");
                        flag = false;
                        break;

                    } else {
                        stack.pop();

                    }

                } else if (str.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        sb.append("no").append("\n");
                        flag = false;
                        break;

                    } else {
                        stack.pop();

                    }
                }
            }
            if (flag) {
                if (stack.isEmpty()) sb.append("yes").append("\n");
                else sb.append("no").append("\n");
            }
        }

        System.out.println(sb);

    }
}
