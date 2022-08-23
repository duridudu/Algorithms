day = int(input())
t = []
pay = []
profit = [0]*(day+1)

for i in range(day):
    tt,payy = map(int, input().split())
    t.append(tt)
    pay.append(payy)

profit = [0]*(day+1)
for i in range(day-1,-1,-1):
    if i+t[i] <= day:
        #print(i, pay[i], t[i])
        profit[i] = max(pay[i]+profit[i+t[i]], profit[i+1])
        #print("이익은",profit[i])
    else:
        profit[i] = profit[i+1]

print(profit[0])