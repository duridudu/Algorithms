cands=[]
res=0
N=int(input())
for _ in range(N):
    cands.append(int(input()))

# 모두 같은 표이면 한번만 매수하면 된다.
if len(cands)>1 and min(cands)==max(cands):
    print(res+1)
# 후보 한명이면 0
elif len(cands)==1:
    print(res)
# 다솜이가 이미 일등이면 아무도 매수 안해도 된다.
elif cands[0]>max(cands[1:]):
    print(res)
else:
    while(True):
        if cands[0]>max(cands[1:]):
            print(res)
            break
        temp_lst=cands[1:]
        # print("temp list is ",temp_lst)
        temp_indx=(temp_lst.index(max(temp_lst)))+1
        cands[0]=cands[0]+1
        # print(temp_indx, cands[temp_indx])
        cands[temp_indx]=cands[temp_indx]-1
        # print(cands)
        res+=1


