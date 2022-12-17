from itertools import combinations
N=int(input())
tastes=[]
nums=list(range(N))
res=1000000000
for i in range(N):
    tastes.append(list(map(int, input().split(" "))))
for i in range(N):
    combi=list(combinations(nums, i+1))
    # print(combi)
    for j in range(len(combi)):
        sin=1
        ssn=0
        # print(combi[j])
        for k in range(len(combi[j])):
            # print(combi[j][k])
            sin*=tastes[combi[j][k]][0]
            ssn+=tastes[combi[j][k]][1]
        temp=abs(sin-ssn)
        if temp<res:
            res=temp
print(res)