def solution(s):
    answer = True
    lst=[]
    temp=list(s)
    lst.append(temp[0])
    
    for i in range(1,len(temp)):
        ## 비어있지 않으면
        if len(lst)!=0:
            now=lst[-1]
            if now=="(":
                if temp[i]==")":
                    lst.pop()
                    continue
                else:
                    lst.append(temp[i])
            elif now==")":
                lst.append(temp[i])
        ## 비어있으면 넣어준다
        else:
            lst.append(temp[i])
    if len(lst)!=0:
        answer=False
    
    return answer