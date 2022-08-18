import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		int T = 10;
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= T; tc++) {
			// 연산자이면 여기 스택에 저장
			Stack<String> plus = new Stack<>();
			// 피연산자이면 여기 저장
			ArrayList<String> arr = new ArrayList<>();
			int nums = sc.nextInt(); // 개수 받는거 모르고 arraylist를 써버려서 이 변수는 사용하지 않게 됨 ㄱ-
			String test = sc.next();

			// step1 : 후위 표기법으로 변환
			for (int i = 0; i < test.length(); i++) {
				String temp = test.substring(i, i + 1);
				// 임시 데이터 저장용 변수
				String data = null;
				// temp가 숫자이면
				if (temp.equals("+") == false) {
					// 일단 arr에 숫자 추가
					arr.add(temp);
					// 연산자 스택이 비어있지 않으면
					if (!plus.isEmpty()) {
						// 젤 위에 있는 연산자 뽑아서 숫자 배열에 추가
						data = plus.pop();
						arr.add(data);
					}
					// 연산자 스택이 비어있으면 쓰루
					else {
						continue;
					}
				}
				// temp가 숫자가 아니면 (+이면) 연산자 스택에 추가
				else {
					plus.push(temp);
				}
			}
//			System.out.println(arr);

			// step2 : 계산
			Stack<Integer> num = new Stack<>();
			// 저장한 배열에서 하나씩 빼와서 피연산자이면 스택에 넣고, 연산자이면 스택에서 pop해와서 계산한 후 스택에 다시 저장함.
			for (int i = 0; i < arr.size(); i++) {
				String temp2 = arr.get(i);
                // 피연산자이면 int로 바꾼 후 스택에 push
				if (!temp2.equals("+")) {
					num.push(Integer.parseInt(temp2));
				} else { // 연산자이면 스택에서 두 개 pop 해와서 계산 후 그것을 다시 스택에 push
					int num1 = num.pop();
					int num2 = num.pop();
					num.push(num1 + num2);
				}
			}
			System.out.printf("#%d %d\n", tc, num.peek());
		} // TC
	}
}
