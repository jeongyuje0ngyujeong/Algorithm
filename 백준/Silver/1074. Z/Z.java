import java.util.*;
import java.io.*;

public class Main {
    static int x = 0;
    static int y = 0;
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int result = Z((int)Math.pow(2, n), row, col);
		System.out.println(result);
	}
	
	public static int Z(int n, int row, int col) {
		n /= 2;
		
		if (row < x + n && col < y + n) {
			count += (n * n * 0);
		
        } else if (row < x + n && col >= y + n) {
			count += (n * n * 1);
			y += n;
		
		} else if(col < y + n) {
			count += (n * n * 2);
			x += n;
		
		} else {
			count += (n * n * 3);
			x += n;
			y += n;
		}
		if(n == 1) return count;
		return Z(n, row, col);
	}

}