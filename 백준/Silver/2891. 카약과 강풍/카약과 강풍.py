N,S,R = map(int, input().split())
son=list(map(int, input().split()))
rep=list(map(int, input().split()))

check=[0]*len(son)
temp=[]
for i in range(len(son)):
    # print(son)
    if (son[i] in rep) and len(rep)>0:
        check.pop()
        temp.append(son[i])
        rep.remove(son[i])

        # print(rep)
for t in temp:
    son.remove(t)
# print(son)
# print(rep)

for i in range(len(son)):
    if len(rep)>0 and (son[i]-1 in rep) :
        check.pop()
        # print(son[i]-1)
        rep.remove(son[i]-1)
        # print(rep)
        continue
    elif len(rep)>0 and (son[i]+1 in rep):
        check.pop()
        # print(son[i] + 1)
        rep.remove(son[i]+1)
        # print(rep)
        continue
    elif len(rep)<=0:
        break

if len(check)>0:
    print(len(check))
else:
    print(0)