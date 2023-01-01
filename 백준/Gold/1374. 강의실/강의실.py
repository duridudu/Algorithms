from heapq import heappop, heappush
N = int(input())
arr=[]
for i in range(N):
    arr.append(list(map(int, input().split())))
arr.sort(key=lambda x:(x[1],x[2]))

heap=[]
heappush(heap, arr[0][2])

for i in range(1, N):
    now=heap[0]
    # i번째 강의 시작 시간이 최소힙보다 크거나 같으면 
    # 이 강의실에서 이어서 할 수 있으므로 이 최소힙 끝나는 시간을 빼준다. 
    if arr[i][1] >= now:
        heappop(heap)
    # 강의 하나 이어서 하든 안하든 i번째 강의 끝나는 시간 추가해야됨! 
    # i번째 강의와 now 강의를 이어서 해도 i번째 강의가 끝나는 시간을 알아야하니까
    heappush(heap, arr[i][2])
    # print(heap)

print(len(heap))