#import sys
#input = sys.stdin.readline()

n = int(input())
orders = []
shorts = []
for _ in range(n):
   orders.append(input().split())

answer = ['0']*n

def order(o, index):
    ## 단어 수만큼 첫번째 인덱스 확인 
    for i in range(len(o)):
        now = o[i]
        if now[0].upper() not in shorts:
            shorts.append(now[0].upper())
            answer[index] = (i, 0)
            return
    ## 첫번째 인덱스에서 답이 나오지 않으면 왼쪽에서부터 순서대로
    for i in range(len(o)):
        now = o[i]
        for j in range(1,len(now)):
            if now[j].upper() not in shorts:
                shorts.append(now[j].upper())
                answer[index] = (i, j)
                return

for i in range(len(orders)):
    order(orders[i], i)


for i in range(len(orders)):
   now = orders[i]
   a = ""

   for j in range(len(now)):
      for k in range(len(now[j])):
         if answer[i] == '0':
            a += now[j][k]
            continue
         if j == answer[i][0] and k == answer[i][1] :
            a+=("[" + now[j][k] + "]") 
            continue
         a += now[j][k]
      a += " "



   print(a)

 



