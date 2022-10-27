t=int(input())
a=300
b=60
c=10
cnt_a=0
cnt_b=0
cnt_c=0
check=0
while t!=0:
    if t>=300:
        ans=t//300
        mod=t%300
        t=mod
        cnt_a+=ans
    elif t>=60:
        ans=t//60
        mod=t%60
        t=mod
        cnt_b+=ans
    elif t>=10:
        ans=t//10
        mod=t%10
        t=mod
        cnt_c+=ans

    if t!=0 and t<10:
        check=1
        break

if check==1:
    print(-1)
else:
    print(cnt_a, cnt_b, cnt_c)