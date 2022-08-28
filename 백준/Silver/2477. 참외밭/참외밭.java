import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[] dir = new int[6];
		int[] len = new int[6];
		for (int i = 0; i < 6; i++) {
			dir[i] = sc.nextInt();
			len[i] = sc.nextInt();
		}

		int idx1 = 0;
		int idx2 = 0;
		int row = 0;
		int col = 0;
		for (int i = 0; i < 6; i++) {
			// 제일 작은 사각형 인덱스 찾기
			if (i == 5) {
				if ((dir[i] == 1 && dir[0] == 3) || (dir[i] == 2 && dir[0] == 4) || (dir[i] == 4 && dir[0] == 1)
						|| (dir[i] == 3 && dir[0] == 2)) {
					idx1 = i;
					idx2 = 0;
				}
			} else {
				if ((dir[i] == 1 && dir[i + 1] == 3) || (dir[i] == 2 && dir[i + 1] == 4)
						|| (dir[i] == 4 && dir[i + 1] == 1) || (dir[i] == 3 && dir[i + 1] == 2)) {
					idx1 = i;
					idx2 = i + 1;
				}
			}

			// 제일 긴 변 찾기
			if (dir[i] == 1 || dir[i] == 2) { // in 북, 남
				row = Math.max(row, len[i]);

			} else { // in 동,서
				col = Math.max(col, len[i]);
			}

		}
		int total = col * row;
		int small = len[idx1] * len[idx2];
		System.out.println((total - small) * K);
	}
}
