A,B,C = map(int, input().split())

def Mod(A,B):
    if B==1:
        return A%C
    temp=Mod(A,B//2)
    if B%2==0:
        return temp*temp%C
    else:
        return temp*temp*A%C

print(Mod(A,B))