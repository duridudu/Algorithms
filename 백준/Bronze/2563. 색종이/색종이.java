import java.util.Scanner;

public class Main { 
	static int[][] paper;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		paper = new int[100][100];
		for (int i = 0; i < num; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			for (int nr = r; nr < r + 10; nr++) {
				for (int nc = c; nc < c + 10; nc++) {
					paper[nr][nc] = 1;
				}
			}
		} // 입력받은 좌표에 종이 입력
		int ans = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				ans += paper[i][j];
			}
		} // 더하기
		System.out.print(ans);
	}// main
}
