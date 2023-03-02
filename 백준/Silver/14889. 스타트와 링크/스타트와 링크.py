# ✨ 입력
import sys

input = sys.stdin.readline
N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
visited = [False for _ in range(N)]
INF = 2147000000
res = INF


# ✨ DFS
def DFS(L, idx):
    global res
    if L == N // 2:
        A = 0
        B = 0
        for i in range(N):
            for j in range(N):
                if visited[i] and visited[j]:
                    A += board[i][j]
                elif not visited[i] and not visited[j]:
                    B += board[i][j]
        res = min(res, abs(A - B))
        return
    for i in range(idx, N):
        if not visited[i]:
            visited[i] = True
            DFS(L + 1, i + 1)
            visited[i] = False


DFS(0, 0)
print(res)

# def dfs(player, idx):
#     # print(player, start)
#     global answer
#     if player==goal:
#         ## 차 비교해야됨
#         # print("hererer")
#         # print(list(range(N))-start)
#         start=0
#         link=0
#
#         for i in range(N):
#             for j in range(N):
#                 if visited[i] and visited[j]:
#                     start+=people[i][j]
#                 elif not visited[i] and not visited[j]:
#                     link+=people[i][j]
#
#         print("start and link is",start, link)
#         answer=min(answer, abs(start-link))
#         # player=0
#         return
#
#     ## i는 열, player는 행
#     for i in range(idx, N):
#         print("{}번 선수의 {}열".format(player, i))
#         if visited[idx]==True or i==player:
#             continue
#         visited[idx]=True
#         # start.append(people[player][i])
#         # start.append(people[i][player])
#         # link.append()
#         dfs(player+1, idx+1)
#         # start.pop()
#         visited[idx]=False
# N=int(input())
# people=[]
# for i in range(N):
#     people.append(list(map(int, input().split())))
# ## [3,6,8]
# ## 인덱스를 저장 [1,3,6] => 1,3/3,1 1,6/6,1 3,6/6,3
# ## 그걸로 더해바 그리고 더한걸. 비교해 ㄱ=
#
# goal=N//2
# # start=[]
# # link=[]
# answer= 2147000000
# visited=[False]*N
# dfs(0,0)
# print(answer)