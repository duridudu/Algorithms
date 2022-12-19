N,K=map(int, input().split(" "))
babies=list(map(int, input().split(" ")))
subt=[]
for i in range(N-1):
    # subt[i]=babies[i+1]-babies[i]
    subt.append(babies[i+1]-babies[i])

subt.sort()
print(sum(subt[:N-K]))

# maxes=[]
# for k in range(K-1):
#     nowMax=max(subt, key=subt.get)
#     maxes.append(nowMax)
#     del(subt[nowMax])
# print(maxes)