a = int(input())
## 3, 5로 가능 
## 18키로를 만들기 위해서는 18-3=15 혹은 18-5 13에서 오는게 가능하다
## sugar[18] = min(sugar[18-3], suger[18-5])
sugars = [5000]*(a+1)
if 3<=a<5 : 
    sugars[3] = 1
elif a>=5 :
    sugars[3] = 1
    sugars[5] = 1


for i in range(6, a+1):
    sugars[i] = min(sugars[i-3]+1, sugars[i-5]+1)

if sugars[a] < 5000:
    print(sugars[a])
else:
    print(-1)