from collections import deque

N = int(input())
lst = list(map(int, input().split()))
a, b = map(int, input().split())

def bfs(a,b,lst,N):
  queue = deque()
  queue.append(a-1)
  visited = [-1 for i in range(N)]
  visited[a-1] += 1
  while(queue):
    now  = queue.popleft()
    dol = lst[now]
    for i in range(now, N, dol):
      if visited[i] == -1:
        queue.append(i)
        visited[i] = visited[now] + 1
        if i == b-1 :
          return visited[i]
    for i in range(now, -1, -dol):
      if visited[i] == -1:
        queue.append(i)
        visited[i] = visited[now] + 1
        if i == b-1 :
          return visited[i]
  return -1

print(bfs(a,b,lst,N))
        
  