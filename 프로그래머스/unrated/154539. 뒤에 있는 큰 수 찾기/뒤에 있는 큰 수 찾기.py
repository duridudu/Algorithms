from heapq import heapify, heappush, heappop
from collections import deque

def solution(numbers):
    answer = []
    memo=[-1]*len(numbers)
    now_max=numbers[-1]
    
    for i in range(len(numbers)-2,-1,-1):
        # print(numbers[i], now_max)
        ## nowmax 갱신, 이 뒤에 얘보다 큰 애 없음
        if numbers[i] >= now_max:
            now_max=numbers[i]
            # memo[i]=-1
            continue
            
        ## 내 뒤에 나보다 크면서 nowmax보다 작은애 없는지
        # else:
        for j in range(i+1, len(numbers)):
            if numbers[j]>numbers[i]:
                memo[i]=numbers[j]
                break
            if numbers[i]>=numbers[j] and numbers[i]<memo[j]:
                memo[i]=memo[j]
                break
        # answer=memo
    return memo