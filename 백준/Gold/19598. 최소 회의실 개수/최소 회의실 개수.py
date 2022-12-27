import heapq
N=int(input())
times=[]
cnt=1
for i in range(N):
    times.append(list(map(int, input().split())))
times.sort(key=lambda x:(x[0], x[1]))

# 세번째 시도 - 최소힙 ㅡㅡ
q=[]
heapq.heappush(q, times[0][1])
for i in range(1, N):
    if q[0] <= times[i][0]:
        heapq.heappop(q)
    heapq.heappush(q, times[i][1])

print(len(q))