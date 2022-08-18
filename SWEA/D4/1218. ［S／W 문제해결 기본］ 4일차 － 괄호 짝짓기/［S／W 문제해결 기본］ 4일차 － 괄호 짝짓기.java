
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int T = 10;
	static int top = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int res=0;
			String[] stack = new String[N];
			String arr = sc.next();
            
			// 괄호 문자열 길이만큼 반복문
			for (int i = 0; i < N; i++) {
				
				String c = arr.substring(i, i+1);
				if (c.equals("(") || c.equals("[") || c.equals("{") || c.equals("<")) {
					stackPush(stack, c);
				} else if (c.equals(")") || c.equals("]") || c.equals("}") || c.equals(">")) {
					// temp는 c 입력 직전에 스택에 있던 왼쪽 괄호!!1
					String temp = stackPop(stack);
					if (temp!=null) {
						// 짝이 맞는지 검사
						if (isEqual(temp, c)) { // 짝이 맞으면 패스
							res=1;
							continue;
						} else { // 짝이 맞지 않으면 결과 0, 종료
							res = 0; 
							break;
						}						
					}
                    // temp가 null인 경우
					else {
						res = 0;
					}
				}
			}
            // for문은 다 돌았는데 (괄호 수식 끝났는데) 스택에 괄호가 남아있는 경우 
			if (!isEmpty()) {
				res = 0;
			}
			System.out.printf("#%d %d\n", tc, res);
            // 다음 tc를 위해 top 초기화
			top=-1;
		}//tc
		sc.close();
	}// main

	private static boolean isEqual(String temp, String c) {
        // 이전 요소와 입력받은 요소 짝 검사
		switch (c) {
		case ")":
			if (temp.equals("(")) {
				return true;
			} else {
				return false;
			}
		case "]":
			if (temp.equals("[")) {
				return true;
			} else {
				return false;
			}
		case "}":
			if (temp.equals("{")) {
				return true;
			} else {
				return false;
			}
		case ">":
			if (temp.equals("<")) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	private static boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}// isEmpty()

	// 배열형태로 만들어 놓았으니까
	private static boolean isFull(String[] stack) {
//		return top == stack.length-1;
		if (top == stack.length - 1)
			return true; // top의 위치가 스택 꼭대기에 가있으면 가득 찼다는 true 반환
		return false; // 그게 아니면 false 반환
	}// isfull()

	private static void stackPush(String[] stack, String c) {
		// 푸쉬를 구현해본다.
		// 가득 찼니? 물어보고 값을 넣음
		if (isFull(stack)) {
			System.out.println("fuuulllllllll");
		} else {
			top += 1;
			stack[top] = c;
		}
	}// push

	private static String stackPop(String[] stack) {
		// 팝을 구현한다.
		// 공백이니? 하고 물어보고 구현
		if (isEmpty()) {
			System.out.println("Emmmppppppptyyyyyyyy");
			return null;
		} else {
//			System.out.println(stack[top]);
			String temp = stack[top];
			stack[top] = null;
			top -= 1;
			return temp;
		}
	}// pop

	private static void printStack(String[] stack) {
		System.out.println(Arrays.toString(stack));
	}// print

}
