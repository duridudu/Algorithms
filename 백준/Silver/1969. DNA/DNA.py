N,M=map(int, input().split(" "))
dna=[]
for _ in range(N):
    dna.append(list((map(str, input()))))

resDNA=''
cnt=0
for i in range(M):
    t,a,c,g=0,0,0,0
    for j in range(N):
        if dna[j][i]=='T':
            t+=1
        elif dna[j][i]=='A':
            a+=1
        elif dna[j][i]=='C':
            c+=1
        elif dna[j][i]=='G':
            g+=1
        
    if max(a,c,g,t)==a:
        resDNA+='A'
        cnt+= (c+g+t)
    elif max(a,c,g,t)==c:
        resDNA+='C'
        cnt+= (a+g+t)
    elif max(a,c,g,t)==g:
        resDNA+='G'
        cnt+= (a+c+t)
    elif max(a,c,g,t)==t:
        resDNA+='T'
        cnt+= (a+g+c)

print(resDNA)
print(cnt)