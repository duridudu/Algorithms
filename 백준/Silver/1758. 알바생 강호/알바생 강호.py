price=[]
N=int(input())
answer=0
for i in range(N):
    price.append(int(input()))
price = sorted(price, reverse=True)

for i in range(N) :
    temp=price[i]-i
    if temp>=0:
        answer+=temp
print(answer)