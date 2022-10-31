## 스위치를 껐다 켜보자 
def control_switch(gender, n):
    if gender==1:
        i=1
        while(True):
            if ((n*i)-1<len(switch)) :
                switch[(n*i)-1]=1-switch[(n*i)-1]
                i+=1
            else:
                break
    else :
        idx=n-1
        i=1
        switch[idx]=1-switch[idx]
        while (True):
            if (idx-i >= 0) and (idx+i<len(switch)) and (switch[idx-i]==switch[idx+i]):
                switch[idx-i]=1-switch[idx-i]
                switch[idx+i]=1-switch[idx+i]
                i+=1
            else:
                break

if __name__=="__main__":
    N=int(input())
    global switch
    switch=list(map(int, input().split()))
    st_num=int(input())
    kids=[]
    for _ in range(st_num):
        gender, num= map(int, input().split())
        control_switch(gender, num)
    if len(switch)<=20:
        print(*switch)
    else :
        for i in range(len(switch)//20):
            print(*switch[20*i:20*(i+1)])
        temp=[]
        for i in range(len(switch)%20):
            temp.append(switch[20*(len(switch)//20)+i])
        if len(temp)!=0 :
            print(*temp)