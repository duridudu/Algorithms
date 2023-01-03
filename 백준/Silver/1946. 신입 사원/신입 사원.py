from heapq import heappop, heappush, heapify

import sys

# sys.stdin.readline()
TC = int(sys.stdin.readline())

for _ in range(TC):
    N = int(input())
    arr = []
    for i in range(N):
        arr.append(list(map(int, sys.stdin.readline().split())))
    arr.sort(key=lambda x: x[0])
    heap = []
    heappush(heap, arr[0][1])
    for i in range(1, N):
        now = heap[0]
        # now가 최소힙보다 작으면 순위 하나라도 높은 것
        if arr[i][1] < now:
            # heappop(heap)
            heappush(heap, arr[i][1])
    print(len(heap))