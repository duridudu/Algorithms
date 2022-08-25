
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] arr;
	static int[] mul;
	static boolean[] check;
	static int k;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			arr = new int[N];
			mul = new int[1000000];
			check = new boolean[1000000];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			} // arr입력완

			max = -1; // 모든 플래그가 false라서 이프문에 들지 못하면 그대로 출력!! <-- 초기에 설정해두면 나중에 따로 조건 걸 일이 없다.  
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					// 곱을 mul에 따로 저장
					int mul = arr[i] * arr[j];
					// mul을 문자열로 바꾼 후 하나씩 쪼개서 볼 것임. 
					// 이 때 단조 증가 수이면 플래그를 트루로 그대로 두고, 기존 Max와 비교해서 max보다 크면 새로운 Max로 만든다. 
					// 단조증가 수가 아니면 (앞 수가 뒷 수보다 크면) 플래그를 false로 바꾼 후 종료시키고, 다음 곱을 받는다.
					// 이렇게 끝까지 돈 후 남아있는 max가  최댓값. 
					String str = String.valueOf(mul);
					boolean flag = true;
					for (int k = 1; k < str.length(); k++) {
						if (str.charAt(k - 1) > str.charAt(k)) {
							flag = false;
							break;
						}
					}
					if (flag == true) {
						max = Math.max(max, mul);
					}
				}
			}
			System.out.println("#" + tc + " " + max);
			
//					mul[k] = arr[i] * arr[j];
			// 그 곱이 단조인지 확인하고 단조이면 체크 배열을 트루로 바꿈
//					if (isDanzo(arr[i] * arr[j])) {
//						check[k] = true;
//					}
			// 인덱스 증가를 위한 k
//					k += 1;
//				}
//			} // mul & check 입력완

//			// 단조 증가 수 중 최댓값 확인
//			int max = 0;
//			int cntFalse = 0; // false의 개수를 세는 변수
//			for (int i = 0; i < check.length; i++) {
//				System.out.println(check[i]);
//				if (check[i]) {
//					if (mul[i] > max) {
//						max = mul[i];
//					}
//				} else {
//					cntFalse += 1;
//				}
//				System.out.println(cntFalse);
//				if (cntFalse == check.length) {
//					max = -1;
//				}
//			}

		} // tc
	}// main

//	private static boolean isDanzo(int num) {
//		String str = Integer.toString(num);
//		char[] temp = str.toCharArray();
	// 숫자 하나 하나 쪼개서 단조인지 확인
//		ArrayList<Integer> temp = new ArrayList<>();
//		while (num > 0) {
//			temp.add(num % 10);
//			num /= 10;
//		}
//		int before = temp.get(temp.size()-1);
//		for (int i = temp.size()-2; i >= 0; i--) {
//			int n = temp.get(i);
//			// 이전 수보다 작으면 단조 아니므로 종료
//			if (n < before) {
//				return false;
//			}
//		}
//		return true;
//	}

}
