def dfs(player, score):
    global answer
    if player==11:
        answer=max(score, answer)
        return

    ## 처음엔 2중 for문으로 i번째 선수의 j번째 포지션 가능 여부를 저장하려했는데
    ## 그러면 11번째 선수까지 i 돌고 나면 첫번째 선수의 2번째 포지션부터 또다시 검사를 못함 ㄱ-
    ## for문을 한 번 더 쓰거나...다르게 표시할 방법이 필요 -> position 리스트로 기록
    for j in range(11):
        if (visited[j]!=False) or players[player][j]==0:
            continue
        visited[j]=True
        position[player]=True

        ## temp 리스트에 쌓이는 포지션을 기록하려함 (position과 비슷한 역할)
        # temp.append(players[i][j])

        dfs(player+1, score+players[player][j])
        visited[j]=False
        position[player]=True
    return
# global i
C=int(input())
for c in range(C):
    players=[]
    for t in range(11):
        players.append(list(map(int, input().split())))
    # print(players)
    ## dp로는 못풀깡? 먼가. 더해가면서 ㄱ=
    ## 이걸 모든 조합을 구하면서 조건에 안 맞는걸 쳐낸다고 생각하는게 어색했돠
    answer=0
    position=[False]*11
    visited=[False]*11
    dfs(0, 0)
    print(answer)