import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int s = sc.nextInt();
		arr = new ArrayList[4]; // 상점+동근이 위치 기록 배열
		arr[0] = new ArrayList<Integer>();
		arr[1] = new ArrayList<Integer>();
		arr[2] = new ArrayList<Integer>();
		arr[3] = new ArrayList<Integer>();
		
		for (int i = 0; i < s; i++) {
			int dir = sc.nextInt();
			int b = sc.nextInt();
			location(dir, b);
		} // 위치 저장 완료

		// 각 행 별 정렬
		for (int i = 0; i < 4; i++) {
			Collections.sort(arr[i]);
		}

		// 동근이 정보 저장
		int dgDir = sc.nextInt();
		int dgB = sc.nextInt();
		location(dgDir, dgB);

		int dgR = 0;

		// 동근이는 arr[dgDir][]의 가장 마지막 원소임!!
		if (dgDir == 1) { // 북쪽
			dgR = 0;
		} else if (dgDir == 4) {// 동쪽
			dgR = 1;
		} else if (dgDir == 2) {// 남쪽
			dgR = 2;
		} else { // 3은 서쪽
			dgR = 3;
		}
		int dgC = arr[dgR].size() - 1;
		
//		for (int i = 0; i < 4; i++) {
//			System.out.println(arr[i].toString());
//		}
		// 계산을 해보자
		int minDist = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < arr[i].size(); j++) {
				int dist = Math.abs(arr[dgR].get(dgC) - arr[i].get(j));
				minDist += Math.min(dist, 2 * (N + M) - dist);
//				System.out.println(dist);
				// 동근이 양 옆 면이면 그냥 빼면 된다.
//				if (dgR == 0 || dgR == 2) { // 동근이가 북이나 남쪽에 있을 때
//					// 상점이 동근이 양 옆 면이면
//					if (i == 1 || i == 3) {
//						minDist += dist;
////						System.out.println(dist);
//					} else {// 동근이랑 같은 행이거나 마주보는 행이면 동근-상점 절댓값과 삥 돌아간 값 비교
//						minDist += Math.min(dist, 2 * (N + M) - dist);
////						System.out.println(Math.min(dist, 2 * (N + M) - dist));
//					}
//
//				} // 북, 남
//
//				// 동근이가 서나 동쪽에 있을 때
//				else {
//					// 상점이 동근이 양 옆이면
//					if (i == 0 || i == 4) {
//						minDist += dist;
////						System.out.println(dist);
//					} else {
//						minDist += Math.min(dist, 2 * (M + N) - dist);
////						System.out.println(Math.min(dist, 2 * (N + M) - dist));
//					}
//				} // 동,서
			}
		} // minDist 계산
		System.out.print(minDist);
	}

	private static void location(int dir, int b) {
		// arr 배열의 각 행에 동서남북 인덱스별로 정보 저장
		if (dir == 1) { // 북쪽
			arr[0].add(b);
		} else if (dir == 4) {// 동쪽
			arr[1].add(N + b);
		} else if (dir == 2) {// 남쪽
			arr[2].add(2 * N + M - b);
		} else { // 3은 서쪽
			arr[3].add(2 * N + 2 * M - b);
		}

//		if (isDG) {
//			return (2 * N + 2 * M - b);
//		}
//
//		return 0;
		// 동근이 좌표를 위해 좌푯값을 리턴해서 밖에서 arr에 저장할까? 아니 ㄱ-;;
	}
}
