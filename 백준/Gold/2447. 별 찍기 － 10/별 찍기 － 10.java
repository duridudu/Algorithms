
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static String arr[][];
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int N = sc.nextInt();
		arr = new String[N][N];
		for (int i=0; i<N;i++) {
			Arrays.fill(arr[i], " ");
		}
		star(N, 0, 0);
		for (int i=0; i<N; i++) {
			for (int j=0; j<N;j++) {
				sb.append(arr[i][j]);		
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void star(int N, int r, int c) {
		if (N == 1) {
//			System.out.print(r+", "+c+"\n");
			arr[r][c]="*";
//			sb.append("*");
//			for (int i = 0; i < 3; i++) {
//				if (i == 1) {
//					sb.append("* *"+"\n");
//				} else {
//					sb.append("***"+"\n");
//				}
//			}
			return;
		} // 1일 때
		
		int size = N / 3;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					continue;
				} else {
					star(size, r + size * i, c + size * j);
				}
			}
		}// for 문 

	}//star

}
