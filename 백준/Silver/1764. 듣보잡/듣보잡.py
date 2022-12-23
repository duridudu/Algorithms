# 2차 시도
N,M=map(int, input().split())
hear=[]
see=[]
for i in range(N):
    hear.append(input())
for i in range(M):
    see.append(input())

hapzip=set(hear) & set(see)
res=sorted(list(hapzip))
print(len(res))
for r in res:
    print(r)