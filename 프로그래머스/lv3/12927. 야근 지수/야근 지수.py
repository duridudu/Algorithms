import heapq

def solution(n, works):
    heap = []
    answer=0

    if sum(works)<=n:
        answer=0
        return answer
    
    # 아래 for문을 실행시키고 나면 heap은 [-5,-4,-3,-1,-2]가 된다.
    for work in works:
        heapq.heappush(heap, -work)
        
    print("중간 힙이야", heap)
    # 아래 for문을 실행시키면 5,4,3,2,1이 출력된다. 즉, 큰 숫자부터 출력이 된다.
    for i in range(n):
        temp=-heapq.heappop(heap)
        temp=temp-1
        heapq.heappush(heap, -temp)

    for i in range(len(heap)):
        answer+=(heap[i]*heap[i])
    return answer