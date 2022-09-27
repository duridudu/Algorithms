import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int T, N, maxDate, tempRes, res, cnt;
    static int arr[][];
    static boolean check[][];
    static int dr[] = { -1, 1, 0, 0 };
    static int dc[] = { 0, 0, -1, 1 };
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            maxDate = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] > maxDate) {
                        maxDate = arr[i][j];
                    }
                }
            } // arr
            res = 0;
            // 날짜 올리며 덩어리 개수 세기 시작
            for (int k = 0; k < maxDate + 2; k++) {
                // day k마다 먹어치운 좌표 0 처리
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] == k) {
                            arr[i][j] = 0;
                        }
                    }
                }
 
                // cnt로 day k의 덩어리 개수 셀거야
                cnt = 0;
                check = new boolean[N][N];
                // day k 일 때 깊이우선탐색으로 좌표 돌기
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] != 0 && check[i][j]==false) {
                            // 한 덩어리마다 cnt 증가
                            dfs(i, j);
                            cnt++;
                        }
                    }
                }
                // day k의 덩어리 개수랑 여태까지 최대 개수 res랑 비교
                if (cnt > res) {
                    res = cnt;
                }
            } // 미친for문
 
            System.out.print("#" + tc + " " + res + "\n");
        } // TC
 
    }// main
 
    private static void dfs(int r, int c) {
        check[r][c]=true;
        for (int i = 0; i < 4; i++) {
            int rr = r + dr[i];
            int cc = c + dc[i];
            if (rr >= 0 && rr < N && cc >= 0 && cc < N && arr[rr][cc] != 0 && check[rr][cc]==false) {
                dfs(rr, cc);
            }
        }
        return;
    }
}