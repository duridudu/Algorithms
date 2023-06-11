def solution(sequence, k):
    ## 합이 k 
    # 1112345라고 쳣을때 0부터 누적합을 다저장해놓음
    # 그 때 1부터 n까지 합 알고싶으면 0부터 n까지 합에서 0번째값 빼면됨 
    # now=sequence[0]
    now=0
    sums=[0]
    
    for i in range(len(sequence)):
        now+=sequence[i]
        sums.append(now)
    # print(sums)
    
    answer = []
    # start=0
    # fin=0
    length=len(sequence)+1
    
    # print(sums)
    ## 한번에 찾을 수 있으면 0부터 시작하는 합인 것
    # if k in sums:
    #     ## 시작(0), 끝, 길이 저장
    #     fin=sums.index(k)
    #     length=fin
    #     answer=[start,fin]

    ## 시도3    
    left=0
    right=0
    
    while (True):
        # print("left and right",left,right, "누적합 is",sums[right]-sums[left])
        if sums[right]-sums[left]==k and right-left<length:
            # start=left
            # fin=right
            length=right-left
            # print("length is", length)
            answer=[left,right-1]
            
        if sums[right]-sums[left]<k:
            right+=1
        else:
            left+=1
            
        if left>right or left>=len(sums)-1 or right>=len(sums):
            break
    ## 시도2    
    # for i in range(1,len(sums)-1):
    #     j=i+1
    #     while j<len(sums) and j-i+1<length:
    #         if sums[j]-sums[i]==k:
    #             start=i
    #             fin=j
    #             length=j-i+1
    #             answer=[start+1, fin]
    #         j+=1
    
    ## 시도1
    # for i in range(1,len(sums)):
    #     for j in range(len(sums)-1):
    #         if sums[i]-sums[j]==k and i-j+1<length:
    #             start=j
    #             fin=i
    #             length=i-j+1
    #             answer=[start+1,fin]
    
    
    return answer