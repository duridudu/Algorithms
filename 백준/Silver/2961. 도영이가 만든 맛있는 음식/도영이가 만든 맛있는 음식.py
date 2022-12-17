from itertools import combinations
N=int(input())
tastes=[]
nums=list(range(N))
res=1000000000
for i in range(N):
    tastes.append(list(map(int, input().split(" "))))
for i in range(N):
    # 만들 수 있는 모든 경우의 수 조합
    combi=list(combinations(nums, i+1))
    for j in range(len(combi)):
        # 신맛과 쓴맛 초기화
        sin=1
        ssn=0
        # 주어진 맛에 대해 모든 경우의 수를 해본다
        for k in range(len(combi[j])):
            sin*=tastes[combi[j][k]][0]
            ssn+=tastes[combi[j][k]][1]
        temp=abs(sin-ssn)
        # 저번 맛보다 차가 적으면 res 갱신 
        if temp<res:
            res=temp
print(res)