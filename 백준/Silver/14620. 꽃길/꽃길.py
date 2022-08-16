from operator import truediv
### 방문했는지 안했는지 확인하는 함수 (했으면 False, 안했으면 True 리턴)
def check(x,y):
    ### 0~4까지. x+0, y+0은 현재 위치 나타냄
    for i in range(5):
        dx = x+dr[i]
        dy = y+dc[i]
        if visited[dx][dy] == 1:
            return False 
    return True

def search(cnt):
    ### 꽃이 세송이 다 피었으면 종료
    ### 이 때 최솟값과 새로 누적된 비용을 비교해 작은 값 리턴 
    global total, res
    if cnt ==3:
        res = min(res, total)
        # print("지금 res는 ", res)
        return 
    ### N*N 꽃밭 순회 
    for i in range(1, N-1):
        for j in range(1, N-1):
            ### 네군데 + 현재 위치 다 아직 안 심은 공간이면 
            if (check(i,j) == True) :
                ### 방문처리 함. 방문 처리는 5개 다 안 가본 곳일때만 함
                for k in range(5):
                    dx = i+dr[k]
                    dy = j+dc[k]
                    visited[dx][dy] = 1### 그 점 방문처리 완료
                    total+=lst[dx][dy]     ### 현재 지나온 점 5개 비용 누적 
                
                search(cnt+1)

                for k in range(5):
                    dx = i+dr[k]
                    dy = j+dc[k]
                    ### 방문 처리 함. 
                    visited[dx][dy] = 0
                    total -= lst[dx][dy]


N = int(input())
lst = []
### 화단 입력 받기 
for i in range(N):
    lst.append(list(map(int, input().split())))

### 상하좌우
dr = [0, 1,-1,0,0]
dc = [0, 0,0,-1,1]

### 방문했는지 안했는지 확인용 배열 
visited=[]
for i in range(N):
    visited.append([0]*N)

### 방문한 자리의 비용 합산용 변수
total=0
### 비용 최댓값으로 설정 후 비교 
res = 987654321
search(0)
print(res)
