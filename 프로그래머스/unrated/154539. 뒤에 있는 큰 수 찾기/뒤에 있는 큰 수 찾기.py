def solution(numbers):
    answer=[-1]*len(numbers)
    stack=[]
    stack.append(0)
    # stack, answer, numbers 세개를 왔다갔다해야해서 어렵다
    for i in range(1, len(numbers)):
        now=numbers[i]
        idx=stack[-1]
        ## 스택 비어있지 않고, 지금 본 애가 그 전 애(스택[-1])보다 크면 뒷큰수 조건 충족.
        # 처음에 이렇게 했다가 while문 돌 때 idx는 안바뀌어서 답이 안맞음! 
        # while stack and numbers[idx]<now:
        while stack and numbers[stack[-1]]<now:    
            ## 정답 갱신, 이 때 갱신할 인덱스는 그 전 애
            ## 바뀔 내용은.. 인덱스 idx인 애의 뒷큰수는 지금 보고 있는 number[i]
            answer[stack[-1]]=now
            ## 뒷큰수 충족됐으니 없애기
            stack.pop()
            
        ## 스택에 이번 인덱스 이제 넣어주기. 이제 얘보다 큰 애 찾으러 가야됨
        stack.append(i)
    
    return answer

# from heapq import heapify, heappush, heappop
# from collections import deque

# def solution(numbers):
#     answer = []
#     memo=[-1]*len(numbers)
#     now_max=numbers[-1]
    
#     for i in range(len(numbers)-2,-1,-1):
#         # print(numbers[i], now_max)
#         ## nowmax 갱신, 이 뒤에 얘보다 큰 애 없음
#         if numbers[i] >= now_max:
#             now_max=numbers[i]
#             # memo[i]=-1
#             continue
            
#         ## 내 뒤에 나보다 크면서 nowmax보다 작은애 없는지
#         # else:
#         for j in range(i+1, len(numbers)):
#             if numbers[j]>numbers[i]:
#                 memo[i]=numbers[j]
#                 break
#             if numbers[i]>=numbers[j] and numbers[i]<memo[j]:
#                 memo[i]=memo[j]
#                 break
#         # answer=memo
#     return memo