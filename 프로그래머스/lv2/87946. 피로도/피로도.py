import itertools
def solution(k, dungeons):
    answer = -1
    indx=[i for i in range(len(dungeons))]
    nPr=list(itertools.permutations(indx, len(dungeons)))
    # res=[]
    # print(nPr)
    res=0
    for p in nPr:
        # p=(0,1,2) 등 
        temp=k
        result=0
        check=True
        for i in p:
            if temp<0 or temp<dungeons[i][0]:
                check=False
                # print("nooo")
                break
            # print(i,temp, dungeons[i][0],dungeons[i][1])
            temp-=dungeons[i][1]
            result+=1
            # print(i, temp)
        res=max(result, res)
        # if check==True:
        #     res.append(result)
            # print("yessssss")
        
    # answer=max(res)
    answer=res
    return answer