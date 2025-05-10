import java.io.*;
import java.util.*;

//실버4 체스판 다시 칠하기
public class Main {
    //지민이가 찾은 체스판
    private static boolean[][] board;
    //바꿔야하는 색의 최소값 (8 * 8 = 64 이므로 64로 초기화 해줌)
    private static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //원래 체스판의 행 개수
        int row = Integer.parseInt(st.nextToken());
        //원래 체스판의 열 개수
        int col = Integer.parseInt(st.nextToken());
        //체스판 생성
        board = new boolean[row][col];

        //체스판 초기화
        for (int i = 0; i < row; i++) {
            //한 행씩 문자열로 받음
            String color = br.readLine();

            //받은 문자열을 쪼개기
            for (int j = 0; j < col; j++) {
                //char로 하나씩 체크하며 하얀색일 경우 true로 변환. 이외는 false로 이미 초기화 되어있어서 생략
                if (color.charAt(j) == 'W') board[i][j] = true;
            }
        }

        //8 * 8 체스판으로 만들 수 있는 값 파악
        //만약 row가 8이라면 세로가 8인 경우는 1개뿐임. 즉, 8(row) - 8(8 * 8의 행) + 1이 해당 경우의 수를 알 수 있음.
        int newRow = row - 7;
        //만약 column이 8이라면 가로가 8인 경우는 1개뿐임. 즉, 8(column) - 8(8 * 8의 열) + 1이 해당 경우의 수를 알 수 있음.
        int newCol = col - 7;
        //경우의 수에 맞춰서 해당 row, column이 갖고 있는 8 * 8배열 탐색
        for (int i = 0; i < newRow; i++) {
            for (int j = 0; j < newCol; j++) {
                //해당 배열의 첫번째 값 i, j 로 최소값 찾는 메서드 호출
                find(i, j);
            }
        }
        //최소값 출력
        System.out.println(min);
    }

    //최소값 찾는 메서드
    private static void find(int a, int b) {
        //체스판 색과 동일하게 만들기 위한 변수 선언, 초기화는 보드의 첫번째 위치 색으로 함
        boolean checkColor = board[a][b];
        //몇 번 바뀌는지 세는 count 메서드
        int count = 0;
        //매개변수로 온 행과 열의 끝 (8 * 8 체스판으로 만들었을 때 행과 열의 끝 위치이므로 a 혹은 b + 8)
        int rowEnd = a + 8;
        int colEnd = b + 8;

        //for문 돌면서 체스판기준으로 바꾸려면 얼마나 색을 바꿔야하는지 체크함
        //a, b가 첫번째 기준이 되므로 i, j 시작점은 a, b로 설정
        for (int i = a; i < rowEnd; i++) {
            for (int j = b; j < colEnd; j++) {
                //체스판으로 만들었을 때 해당 색이어야하는데 원래 보드판은 그 색이 아닌 경우에 count 해줌
                if (board[i][j] != checkColor) count++;
                //기준 색 바꿔줌 (다음 색을 위한 준비. 무조건 흰,검이 교차되어야함)
                checkColor = (!checkColor);
            }
            //행이 바뀌면 바로 위 행 색과 달라져야하는데 8 * 8은 짝수이므로 같은 색이 나옴. 그래서 한 번 더 기준 색을 바꿔줌
            checkColor = (!checkColor);
        }

        //count는 내가 첫번째 색이 원 체스판의 색이라고 했을 경우 센 숫자, 다른 색이었을 경우는 64 - count로 표현
        //예를 들어 첫번째가 흰색이고 다음 색이 흰색 그 이후로는 모두 체스판과 동일할 때 count = 63이 됨, but 첫번째 색만 바꾸면 되니까 64 - 1 이 되기도 함
        count = Math.min(count, 64 - count);
        //8 * 8로 만드는 경우의 수마다 최소값이 다를 수 있으므로 이전 최소값과 카운트값 비교하여 최소값 업데이트
        min = Math.min(min, count);
    }
}