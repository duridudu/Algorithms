from collections import deque

def bfs(conn, start, visit):
    queue = deque()
    # check[start] = True
    visit[start] = 1

    queue.append(start)

    while (queue):
        city = queue.popleft()
        # print("city in while is", city)
        for k in range(N):
            # print("이어진 도시는", city, conn[city])
            if conn[city][k] == 1 and visit[k] == 0:
                visit[k] = 1
                # if k == (plan[i + 1] - 1):
                #     check[k] = True
                    # print(plan[i+1],"나 브레이크걸린다아아아")
                    # queue.clear()
                # else:
                queue.append(k)


N=int(input())
M=int(input())


# 섬 번호가 1부터 시작하므로 맨 앞 0번 인덱스에 빈 리스트를 넣어놓는다.
conn=[]
for _ in range(N):
    conn.append(list(map(int,input().split())))


plan=list(map(int, input().split()))
check=[False]*N
visit=[0]*N

# print("conn is",conn)
# print(plan)
## 순환이 있을 수 있어서 일일이 for문으로 돌면 안됨!!!!!!!!
# for i in range(len(plan)-1):
    # queue = deque()
    # ## p는 방문하려는 도시 번호
    # p=(plan[i]-1)
    #
    # check[p]=True
    # visit[p]=1
    # # print("P IS", p)
    # for j in range(N):
    #     if conn[p][j] == 1:
    #         if j == (plan[i+1]-1):
    #             answer+=1
    #             check[j]=True
    #             queue.clear()
    #             # print("나 첫번째 브레이크으으으")
    #             break
    #         queue.append(j)
    # # print("queue now is", queue)
    # # t=0
    # while (queue):
    #     city=queue.popleft()
    #     # t+=1
    #     # print("city in while is", city," , p is",p)
    #     for k in range(N):
    #         # print("이어진 도시는", city, conn[city])
    #         if conn[city][k] == 1 and visit[k]==0:
    #             visit[k]=1
    #             if k==(plan[i+1]-1):
    #                 check[k] = True
    #                 # print(plan[i+1],"나 브레이크걸린다아아아")
    #                 answer+=1
    #                 queue.clear()
    #                 break
    #             else:
    #                 queue.append(k)

                # print(queue)

start=plan[0]-1
bfs(conn, start, visit)

ch=False
# print(visit)
for i in range(len(plan)):
    # print(i, plan[i])
    if (visit[plan[i]-1]==False):
        ch=True

if (ch==False):
    print("YES")
else:
    print("NO")
