from collections import deque

def bfs(start):
    que = deque([(start, 0)])
    visit[start] = 1

    while que:
        top, cnt = que.popleft()
        if top == k:
            return cnt
        for i in [top + 1, top * 2]:
            if not visit[i] and i <= k:
                    visit[i] = 1
                    que.append((i, cnt + 1))

a, k = map(int, input().split())
visit = [0] * (k*2 + 1)     # 이 부분 주의. k가 최대 움직일 수 있는 거리는 k*2이므로

print(bfs(a))