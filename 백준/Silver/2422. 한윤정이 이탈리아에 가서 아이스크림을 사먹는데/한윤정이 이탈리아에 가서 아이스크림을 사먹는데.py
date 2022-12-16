from itertools import combinations,permutations
from collections import defaultdict
N,M=map(int, input().split(" "))
ice = [[False for _ in range(N)] for _ in range(N)]
allTaste=list(range(N))
combi=list(combinations(allTaste, 3))
res=0
for i in range(M):
    n1,n2=map(int, input().split(" "))
    # combinations 결과는 큰 수부터 나오지만 입력은 그렇지 않을 수 있어서 둘 다 트루로 바꿔줌
    ice[n1-1][n2-1]=True
    ice[n2-1][n1-1]=True
# print(ice)

# combinations에서는 0부터 N-1까지 적용돼서 -1 헤서 ice에 넣어줄 필요 x 
for i in combi:
    if not ice[i[0]][i[1]] and not ice[i[0]][i[2]] and not ice[i[1]][i[2]]:
        res += 1
# print(combi)
print(res)
