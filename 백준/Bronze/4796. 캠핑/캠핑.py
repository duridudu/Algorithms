L=1
tc=1
while L!=0:
    L,P,V=map(int, input().split())
    if L==0:
        break
    res=0
    res+=(V//P)*L
    namoji=(V%P)

    if 1<=namoji<=L:
        res+=namoji
    elif 1<=L<=namoji:
        res+=L
    print("Case {}: {}".format(tc, res))
    tc+=1
    