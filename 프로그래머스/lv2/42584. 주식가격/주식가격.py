from collections import deque
import copy

def solution(prices):
    answer=[0]*len(prices)
    stack=[]
    # stack=deque(prices)
    ## 뒤에 애들과 나의 크기를 비교하는 문제 
    for i in range(len(prices)):
        ## now인 prices[i]와 i+1부터 끝까지의 원소를 비교
        now=prices[i]
        ## 여기서 슬라이스로 리스트 잘라서 큐로 넣는게 .. 시간복잡도흐아앙
        # stack=deque(prices[i+1:])
        ## 그럼 새로 만들지말고 하나씩 pop을 해서 하나로 써보자 (for문 밖에서 초기화해서)
        # stack=deque() => deepcopy가 slicing보다 마니 느림 ㄱ-
        # stack=copy.deepcopy(check)
        # stack=deque(prices)
        
        ## 하락할때만 검사
        while stack and now<prices[stack[-1]]:
            temp=stack.pop()
            answer[temp]=i-temp
        
        ## 상승장이면 스택에 추가
        stack.append(i)
        
            
    while stack:
        i = stack.pop()
        answer[i] = len(prices)-1-i
        
    return answer