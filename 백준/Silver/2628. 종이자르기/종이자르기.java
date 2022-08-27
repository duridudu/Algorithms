import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 인덱스 = 점선 번호 - 1
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int N = sc.nextInt();
		ArrayList<Integer> arrR;
		ArrayList<Integer> arrC;
		int max=0;
		// 네모의 수는 (가로로 자르는 횟수+1) * (세로로 자르는 횟수+1)
		arrR = new ArrayList<>();
		arrC = new ArrayList<>();
		arrR.add(0);
		arrC.add(0);
		for (int i = 1; i <= N; i++) {
			int dir = sc.nextInt();
			int idx = sc.nextInt();
			if (dir == 0) {
				arrR.add(idx);
			} else {
				arrC.add(idx);
			}
		} // 행-자르는 번호 배열 저장 완
		arrR.add(col);
		arrC.add(row);
		// 가로, 세로 저장된 점선 번호 정렬
		Collections.sort(arrR);
		Collections.sort(arrC);
//		System.out.println(arrR.toString());
//		System.out.println(arrC.toString());
		for (int i = 1; i < arrR.size(); i++) {
			int temp=0;
			for (int j = 1; j < arrC.size(); j++) {
				temp= (arrR.get(i) - arrR.get(i - 1)) * (arrC.get(j) - arrC.get(j - 1));
				max = Math.max(temp, max);
			}
		}
		System.out.println(max);
		sc.close();
	}//main
}
