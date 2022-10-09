
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		HashMap<Integer, Integer> map = new HashMap<>();

		int N = sc.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			// 맵에 높이랑 방문기록 저장 
			map.put(arr[i], 0);
		}

		int cnt = 0;
		// 개수만큼 반복하며 체크 
		for (int i = 0; i < N; i++) {
			// i번째 풍선의 높이에 화살이 간 적이 없으면 
			if (map.get(arr[i]) == 0) {
				// 가야할 곳이므로 카운트 + 
				cnt++;
			} else { // 쏘아진 화살 있으면 i번째 풍선의 높이의 화살 기록을 하나 낮춤 
				map.put(arr[i], map.get(arr[i]) - 1);
			}
			
			// 그러고 i번째 높이보다 하나 낮은 높이로 화살 이동해서 하나 + 
			// 젤 낮은 높이일 경우 -1 하면 없으므로 i번째 높이-1인 높이가 있을 경우에만 수행 
			if (map.containsKey(arr[i] - 1)) {
				map.put(arr[i] - 1, map.get(arr[i] - 1) + 1);
			}
//			System.out.println(map.toString());
//			System.out.println(cnt);
		}
		System.out.println(cnt);
	}

}
