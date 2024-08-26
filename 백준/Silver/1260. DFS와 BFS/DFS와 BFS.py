import sys
input = sys.stdin.readline

def dfs(cur):
    visited[cur] = True
    ans_dfs.append(cur)

    for i in graph[cur]:
        if not visited[i]:
            dfs(i)

    return ans_dfs

def bfs(cur):
    queue = []

    visited[cur] = True
    ans_bfs.append(cur)
    queue.append(cur)

    while queue:
        cur = queue.pop(0)
        for i in graph[cur]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
                ans_bfs.append(i)

    return ans_bfs


if __name__ == "__main__":
    n, m, v = map(int, input().split())
    graph = [[] for _ in range(n+1)]

    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    for i in graph:
        i.sort()


    visited = [False for _ in range(n + 1)]
    ans_dfs = []
    print(*dfs(v))

    visited = [False for _ in range(n + 1)]
    ans_bfs = []
    print(*bfs(v))